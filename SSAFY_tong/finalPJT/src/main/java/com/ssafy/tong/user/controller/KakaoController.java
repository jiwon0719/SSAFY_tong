package com.ssafy.tong.user.controller;


import java.util.Collections;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ssafy.tong.user.model.KakaoUserInfo;
import com.ssafy.tong.user.model.User;
import com.ssafy.tong.user.model.service.UserService;

@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true", allowedHeaders = "*")
@RestController
@RequestMapping("/oauth2/kakao")
public class KakaoController {
	
	private final UserService userService;

    public KakaoController(UserService userService) {
        this.userService = userService;
    }
    
    @Value("${kakaoapi.key}")
    private String apiKey;
    
    
    @GetMapping
    public ResponseEntity<?> getAccessToken(@RequestParam("code") String code) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded;charset=utf-8");

        // Access Token 요청
        StringBuilder params = new StringBuilder();
        params.append("grant_type=authorization_code");
        params.append("&client_id=").append(apiKey);
        params.append("&redirect_uri=http://localhost:8080/oauth2/kakao");
        params.append("&code=").append(code);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> tokenResponse = restTemplate.exchange(
                "https://kauth.kakao.com/oauth/token",
                HttpMethod.POST,
                new HttpEntity<>(params.toString(), httpHeaders),
                String.class
        );

        if (!tokenResponse.getStatusCode().is2xxSuccessful()) {
            return ResponseEntity.status(tokenResponse.getStatusCode()).body("Failed to get access token");
        }

        String responseBody = tokenResponse.getBody();
        String accessToken = new JSONObject(responseBody).getString("access_token");

        // 메인 페이지로 리다이렉트하며 액세스 토큰 전달
        String redirectUrl = "http://localhost:5173/main?accessToken=" + accessToken;
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", redirectUrl);
        return ResponseEntity.status(302).headers(headers).build();
    }

    
    
    @GetMapping("/user-info")
    public ResponseEntity<KakaoUserInfo> getUserInfo(@RequestHeader("Authorization") String authorization) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization", authorization);
            headers.add("Accept", "application/json");
            HttpEntity<String> entity = new HttpEntity<>(headers);

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> userResponse = restTemplate.exchange(
                    "https://kapi.kakao.com/v2/user/me",
                    HttpMethod.GET,
                    entity,
                    String.class
            );

            if (!userResponse.getStatusCode().is2xxSuccessful()) {
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }

            String userInfo = userResponse.getBody();
            JSONObject userJson = new JSONObject(userInfo);
            String kakaoId = String.valueOf(userJson.getLong("id")) + "a!";
            
            // 사용자 존재 여부 확인
            User user = userService.findUserByUserId(kakaoId);
            
            if (user == null) {
                // 신규 사용자
                KakaoUserInfo kakaoUserInfo = new KakaoUserInfo(
                    kakaoId,
                    userJson.getJSONObject("properties").getString("nickname"),
                    userJson.getJSONObject("kakao_account").getString("email"),
                    userJson.getJSONObject("properties").optString("profile_image", ""),
                    null  // 신규 사용자는 아직 userType이 없음
                );
                return new ResponseEntity<>(kakaoUserInfo, HttpStatus.CREATED);
            } else {
                // 기존 사용자
                KakaoUserInfo kakaoUserInfo = new KakaoUserInfo(
                    kakaoId,
                    user.getName(),
                    user.getEmail(),
                    user.getUserProfileImgPath(),
                    user.getUserType()  // 기존 사용자의 userType 포함
                );
                
                System.out.println("kakaoUserInfo : "  + kakaoUserInfo);
                return new ResponseEntity<>(kakaoUserInfo, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
   
    
    
    // 카카오 로그아웃
    @GetMapping("/kakao-logout")
    public ResponseEntity<Object> logout(@RequestHeader("Authorization") String authorization) {
        try {
            // 헤더 설정
            HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization", authorization);
            HttpEntity<String> entity = new HttpEntity<>(headers);

            // 카카오 API 호출 (로그아웃)
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> logoutResponse = restTemplate.exchange(
                    "https://kapi.kakao.com/v1/user/logout",
                    HttpMethod.POST,
                    entity,
                    String.class
            );

            // 요청 실패 시 처리
            if (!logoutResponse.getStatusCode().is2xxSuccessful()) {
                return new ResponseEntity<>(Collections.singletonMap("message", "Failed to log out"), HttpStatus.UNAUTHORIZED);
            }

            // 응답 처��
            String responseBody = logoutResponse.getBody();
            JSONObject responseJson = new JSONObject(responseBody);
            long userId = responseJson.getLong("id"); // 로그아웃된 사용자 ID

            return ResponseEntity.ok(Collections.singletonMap("message", "User logged out successfully, UserId: " + userId));
        } catch (Exception e) {
            return new ResponseEntity<>(Collections.singletonMap("message", "Error during logout"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    
    @GetMapping("/unlink")
    public ResponseEntity<Object> unlink(@RequestHeader("Authorization") String authorization) {
        try {
            // 헤더 설정
            HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization", authorization);
            HttpEntity<String> entity = new HttpEntity<>(headers);

            // 카카오 API 호출 (연결 끊기)
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> unlinkResponse = restTemplate.exchange(
                    "https://kapi.kakao.com/v1/user/unlink",
                    HttpMethod.POST,
                    entity,
                    String.class
            );

            // 요청 실패 시 처리
            if (!unlinkResponse.getStatusCode().is2xxSuccessful()) {
                return new ResponseEntity<>(Collections.singletonMap("message", "Failed to unlink account"), HttpStatus.UNAUTHORIZED);
            }

            // 응답 처리
            String responseBody = unlinkResponse.getBody();
            JSONObject responseJson = new JSONObject(responseBody);
            long userId = responseJson.getLong("id"); // 연결이 해제된 사용자 ID

            return ResponseEntity.ok(Collections.singletonMap("message", "User unlinked successfully, UserId: " + userId));
        } catch (Exception e) {
            return new ResponseEntity<>(Collections.singletonMap("message", "Error during unlinking"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}