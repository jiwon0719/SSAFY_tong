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

    
    
    @GetMapping("/user-info")
    public ResponseEntity<Object> getUserInfo(@RequestHeader("Authorization") String authorization) {
        try {
            // 헤더 설정
            HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization", authorization);
            HttpEntity<String> entity = new HttpEntity<>(headers);

            // 카카오 API 호출
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> userResponse = restTemplate.exchange(
                    "https://kapi.kakao.com/v2/user/me",
                    HttpMethod.GET,
                    entity,
                    String.class
            );

            // 요청 실패 시 처리
            if (!userResponse.getStatusCode().is2xxSuccessful()) {
                return new ResponseEntity<>(Collections.singletonMap("message", "Kakao token invalid"), HttpStatus.UNAUTHORIZED);
            }

            // 사용자 정보 추출
            String userInfo = userResponse.getBody();
            System.out.println("userInfo : " + userInfo);
            JSONObject userJson = new JSONObject(userInfo);

            // 필요한 사용자 정보 추출 (id, nickname, email, profile_image)
            String kakaoId = String.valueOf(userJson.getLong("id"));
            String nickname = userJson.getJSONObject("properties").getString("nickname");
            String email = userJson.getJSONObject("kakao_account").getString("email");
            String profileImage = userJson.getJSONObject("properties").optString("profile_image", "");
            
            System.out.println(kakaoId);
            System.out.println(nickname);
            System.out.println(email);
            System.out.println(profileImage);

            // 사용자 정보 조회
            // 회원가입시 아이디 보안을 위해 js에서 까다롭게 해서 그냥 숫자인 kakaoId 값은 제대로 구현되지 못한다. 그래서 a! 추가시켰다 
            User user = userService.findUserByUserId(kakaoId+"a!");
            
            
            if (user == null) {
            	// 데이터베이스에 해당 사용자가 없으면 카카오 정보를 반환
                KakaoUserInfo kakaoUserInfo = new KakaoUserInfo(kakaoId, nickname, email, profileImage);
                return new ResponseEntity<>(kakaoUserInfo, HttpStatus.valueOf(250)); 
            } else {
                // 사용자가 있으면 정상 처리
                return ResponseEntity.ok().body(new KakaoUserInfo(kakaoId, nickname, email, profileImage));
            }
        } catch (Exception e) {
        	System.out.println("비정상반환");
            return new ResponseEntity<>(Collections.singletonMap("message", "Error retrieving user info"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}