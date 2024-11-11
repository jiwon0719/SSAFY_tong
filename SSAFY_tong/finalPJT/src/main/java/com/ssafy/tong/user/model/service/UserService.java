package com.ssafy.tong.user.model.service;

import org.springframework.stereotype.Service;

import com.ssafy.tong.user.model.User;

public interface UserService {
	
	// 회원가입
	void signUp(User user);

	// 로그인
	User signIn(String userId, String password);
	
	// 비밀번호 변경
	void updatePassword(User loggedInUser);
	
	// 카카오 회원 확인을 위해서
	User findUserByUserId(String kakaoId);


}
