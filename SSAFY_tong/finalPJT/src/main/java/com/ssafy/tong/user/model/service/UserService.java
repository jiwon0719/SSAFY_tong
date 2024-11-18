package com.ssafy.tong.user.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.tong.user.model.User;

public interface UserService {
	//전체 사용자 목록 불러오기
		public List<User> getUserList();
		//사용자 등록하기
		public boolean signUp(User user);
		//로그인 하기
		public User	signIn(String id, String password);
		
		// id 로 조회
		User findUserByUserId(String userId);
		
		
		
		void updatePassword(User loggedInUser);
		
		
		
		
		
}

