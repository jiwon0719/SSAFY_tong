package com.ssafy.tong.user.controller;


import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
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


    // 새로운 엔드포인트: 사용자 정보 조회
    @GetMapping("/user-info")
    public ResponseEntity<?> getUserInfo(@RequestHeader("Authorization") String accessToken) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", accessToken);  // "Bearer " 접두사는 프론트에서 붙여서 보내줌
        
        RestTemplate restTemplate = new RestTemplate();
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
        JSONObject userJson = new JSONObject(userInfo);
        String kakaoId = String.valueOf(userJson.getLong("id"));

        // DB에서 카카오 ID로 사용자 정보 조회
        User user = userService.findUserByUserId(kakaoId);

        if (user != null) {
            return ResponseEntity.ok().body(user);
        } else {
            return ResponseEntity.status(200)
                    .body("User not found. Redirecting to sign-up page.");
        }
    }

}
