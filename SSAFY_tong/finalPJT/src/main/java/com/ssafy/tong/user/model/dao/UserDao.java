package com.ssafy.tong.user.model.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ssafy.tong.user.model.User;

public interface UserDao {
	
	// 전체 조회
	public List<User> selectAll();
	
	// 회원 가입
	public int signUp(User user);
	
	// 로그인
	User signIn(String userId);
	
	// 
	public User selectOne(Map<String, String> info);
	
	// id로 조회
	public void findByUserId(String userId);

	public void updatePassword(User loggedInUser);

	// 아이디로 이미지 가져오기
	public String getProfileImageByUserId(String userId);

	// 전문가 등록시, 첫 번째 이미지의 system_name을 사용자 프로필 이미지로 설정
	public void updateUserProfileImage(User user);


	
	
		
		
		
}
