package com.ssafy.tong.user.controller;


import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ssafy.tong.user.model.User;
import com.ssafy.tong.user.model.service.UserService;

import jakarta.servlet.http.HttpSession;

@CrossOrigin("*")
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
    public ResponseEntity<?> getAccessToken(@RequestParam("code") String code, HttpSession session) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded;charset=utf-8");

        // 1. Access Token 요청
        StringBuilder params = new StringBuilder();
        params.append("grant_type=authorization_code");
        params.append("&client_id="+apiKey);
        params.append("&redirect_uri=http://localhost:8080/oauth2/kakao");
        params.append("&code=").append(code);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> tokenResponse = restTemplate.exchange(
                "https://kauth.kakao.com/oauth/token",
                HttpMethod.POST,
                new HttpEntity<>(params.toString(), httpHeaders),
                String.class
        );

        // 2. Access Token 추출
        if (!tokenResponse.getStatusCode().is2xxSuccessful()) {
        	System.out.println("access token 추출 완료");
            return ResponseEntity.status(tokenResponse.getStatusCode()).body("Failed to get access token");
        }

        String responseBody = tokenResponse.getBody();
        String accessToken = new JSONObject(responseBody).getString("access_token");
        
        System.out.println(accessToken);
        
        // 3. 사용자 정보 요청
        httpHeaders.clear();
        httpHeaders.add("Authorization", "Bearer " + accessToken);
        ResponseEntity<String> userResponse = restTemplate.exchange(
                "https://kapi.kakao.com/v2/user/me",
                HttpMethod.GET,
                new HttpEntity<>(httpHeaders),
                String.class
        );

        if (!userResponse.getStatusCode().is2xxSuccessful()) {
            return ResponseEntity.status(userResponse.getStatusCode()).body("Failed to get user info");
        }

        String userInfo = userResponse.getBody();
        
        System.out.println(userInfo);
        
        
        session.setAttribute("kakaoUserInfo", userInfo);

        // 4. 유저 정보 파싱 및 DB 조회
        JSONObject userJson = new JSONObject(userInfo);
        String kakaoId = String.valueOf(userJson.getLong("id"));

        // DB에서 카카오 ID로 사용자 정보 조회
        User user = userService.findUserByUserId(kakaoId);

        if (user != null) {
            // 사용자 정보가 존재할 경우 세션에 로그인 정보 저장
            session.setAttribute("user", user);

            // 로그인 성공 응답
            return ResponseEntity.ok().body("User login successful. Redirecting to main page.");
            
            // 로그인 후 메인페이지로 이동하는 거 나중에 필요
            
            
        } else {
            // 사용자 정보가 없을 경우 회원가입 필요
            return ResponseEntity.status(200)
                    .body("User not found. Redirecting to sign-up page for additional information.");
            
            // 회원가입 페이지로 이동하는 로직 나중에 필요
        }
    }

}
