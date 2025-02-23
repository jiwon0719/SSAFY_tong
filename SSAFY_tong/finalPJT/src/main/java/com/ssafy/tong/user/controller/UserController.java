package com.ssafy.tong.user.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.tong.jwt.JwtUtil;
import com.ssafy.tong.user.model.User;
import com.ssafy.tong.user.model.service.UserService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.UnsupportedJwtException;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true", allowedHeaders = "*")
public class UserController {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    public UserController(UserService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    // 사용자 목록 전체 가져오기
    @GetMapping("/users")
    public ResponseEntity<?> users() {
        List<User> list = userService.getUserList();
        if (list == null || list.isEmpty()) {
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<User>>(list, HttpStatus.OK);
    }

    // 사용자 회원가입
    @PostMapping("/signUp")
    public ResponseEntity<Object> signUp(@RequestBody User user) {
//        if (userService.findUserByUserId(user.getUserId())) {  // 사용자 중복 확인
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("이미 존재하는 사용자입니다.");
//        }

        if (userService.signUp(user)) {
            return ResponseEntity.status(HttpStatus.CREATED).body("User added successfully");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add user");
    }

    // 사용자 로그인
    @PostMapping("/signIn")
    public ResponseEntity<Map<String, Object>> signIn(@RequestBody User user) {
        Map<String, Object> result = new HashMap<>();
        HttpStatus status;

        // 비밀번호 확인을 안전하게 해야함, 예시로 간단한 비교만 사용
        User loginUser = userService.signIn(user.getUserId(), user.getPassword());

        if (loginUser != null) {
            String token = jwtUtil.createToken(loginUser.getName(), loginUser.getUserId(), loginUser.getUserType());
            result.put("message", "로그인 성공. JWT 토큰 발급됨");
            result.put("access-token", token);
            status = HttpStatus.ACCEPTED;
        } else {
            result.put("message", "로그인 실패");
            status = HttpStatus.UNAUTHORIZED;
        }
        return new ResponseEntity<>(result, status);
    }

    // 사용자 정보 가져오기 (JWT 토큰을 이용한 인증)
    @GetMapping("/user-info")
    public ResponseEntity<Object> getUserInfo(@RequestHeader("Authorization") String authorizationHeader) {
    	System.out.println("user-info 불렸따");
        String token = authorizationHeader.startsWith("Bearer ") ? authorizationHeader.substring(7) : authorizationHeader;
        
        try {
            // JWT 토큰 검증 및 클레임 추출
            Jws<Claims> claimsJws = jwtUtil.validate(token);
            Claims claims = claimsJws.getBody();

            // JWT에서 사용자 정보 추출
            String userId = claims.get("user_id", String.class);
            String name = claims.get("name", String.class);

            // 사용자 정보 조회
            User user = userService.findUserByUserId(userId);
            if (user == null) {
                return new ResponseEntity<>(Collections.singletonMap("message", "User not found"), HttpStatus.NOT_FOUND);
            }

            Map<String, Object> response = new HashMap<>();
            response.put("userId", userId);
            response.put("name", name);
            response.put("userDetails", user);
            
            System.out.println(userId + "==================================================================================================================================");
            System.out.println(name);
            System.out.println(user);

            // JSON 형식으로 응답을 보냄
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_JSON)  // 응답 타입을 JSON으로 설정
                    .body(response);
        } catch (ExpiredJwtException e) {
            return new ResponseEntity<>(Collections.singletonMap("message", "Token has expired"), HttpStatus.UNAUTHORIZED);
        } catch (UnsupportedJwtException e) {
            return new ResponseEntity<>(Collections.singletonMap("message", "Unsupported token"), HttpStatus.UNAUTHORIZED);
        } catch (Exception e) {
            return new ResponseEntity<>(Collections.singletonMap("message", "Invalid or expired token"), HttpStatus.UNAUTHORIZED);
        }
    }
    
    
    
    // 사용자 프로필 이미지 가져오기
    @GetMapping("/profileImg/{userId}")
    public ResponseEntity<Map<String, Object>> getProfileImage(@PathVariable String userId) {
        Map<String, Object> result = new HashMap<>();
        HttpStatus status;

        try {
            // userId로 사용자 정보를 조회
            String profileImage = userService.getProfileImageByUserId(userId);

            if (profileImage != null) {
                result.put("profileImage", profileImage);
                result.put("message", "프로필 이미지 가져오기 성공");
                status = HttpStatus.OK;
            } else {
                result.put("message", "프로필 이미지가 없습니다.");
                status = HttpStatus.NOT_FOUND;
            }
        } catch (Exception e) {
            result.put("message", "서버 에러 발생");
            result.put("error", e.getMessage());
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return new ResponseEntity<>(result, status);
    }
    
    
 // 사용자 아이디 중복 검사
    @GetMapping("/checkUserIdDuplicate")
    public ResponseEntity<Map<String, Object>> checkUserIdDuplicate(@RequestParam String userId) {
        Map<String, Object> result = new HashMap<>();

        try {
            // userId로 사용자 정보 조회
            User isDuplicate = userService.findUserByUserId(userId); 

            // 중복 여부 확인
            if (isDuplicate != null) {
                result.put("duplicate", true); // 중복됨
                result.put("message", "아이디가 이미 존재합니다.");
            } else {
                result.put("duplicate", false); // 중복되지 않음
                result.put("message", "사용 가능한 아이디입니다.");
            }

            return ResponseEntity.ok(result); // HTTP 200 상태코드와 결과 반환
        } catch (Exception e) {
            // 예외 발생 시 처리
            result.put("message", "중복 검사 중 오류가 발생했습니다.");
            return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    
    
}
