package com.ssafy.tong.user.model.dao;

import com.ssafy.tong.user.model.User;

public interface UserDao {
	
	// 회원가입
	void signUp(User user);
	
	// 로그인
	User signIn(String userId);

	// 비밀번호 변경
	void updatePassword(User loggedInUser);
	

	
	
	
	
}
