package com.ssafy.tong.jwt;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {
	private String key = "SSAFY_NonMajor_JavaTrack_SecretKey";
	private SecretKey secretKey = Keys.hmacShaKeyFor(key.getBytes(StandardCharsets.UTF_8));
	
	//토큰 생성시 다양한 데이터를 저장할 수 있음 (DTO or Map)
	public String createToken(String name, String userId) {
		//유효기간 
		Date exp = new Date(System.currentTimeMillis()+ 1000*60*60); //1시간
		return Jwts.builder().header().add("typ", "JWT").and()
				.claim("name", name).expiration(exp)
				.claim("user_id", userId)
				.signWith(secretKey).compact();
	}
	
	
	//유효성 검증 (실제로 내용물을 확인하기 위함은 아니고요... 
	//이거 실행했을때 에러나면 유효기간 지난거....
	public Jws<Claims> vaildate(String token ){
		return Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token);
	}
	
	
	
	
	
	
	
	
	
	
	
}
