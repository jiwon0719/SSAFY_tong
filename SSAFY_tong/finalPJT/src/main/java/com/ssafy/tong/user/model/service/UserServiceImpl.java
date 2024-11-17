package com.ssafy.tong.user.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.tong.user.model.User;
import com.ssafy.tong.user.model.dao.UserDao;

@Service
public class UserServiceImpl implements UserService {

	private final UserDao userDao;

	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public List<User> getUserList() {
		return userDao.selectAll();
	}

	@Override
	public boolean signUp(User user) {
		return userDao.signUp(user) == 1;
	}

	// 로그인
	@Override
	public User signIn(String userId, String password) {
		// 사용자 정보 조회
		User user = userDao.signIn(userId);

		// 사용자 존재 여부 및 비밀번호 확인
		if (user != null && password.equals(user.getPassword())) {
			return user; // 로그인 성공
		}

		return null; // 로그인 실패
	}

	// 카카오 회원이 이미 가입 되었는지 확인 위해서
	@Override
	public User findUserByUserId(String kakaoId) {
		// 사용자 정보 조회
		User user = userDao.signIn(kakaoId);

		// 카카오 회원으로 이미 가입 했었음
		if (user != null) {
			return user;
		}
		return null; // 카카오 회원으로 가입 안함
	}

	// 비밀번호 변경
	@Override
	public void updatePassword(User loggedInUser) {
		userDao.updatePassword(loggedInUser);
	}
}
