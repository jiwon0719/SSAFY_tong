package com.ssafy.tong.user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.tong.jwt.JwtUtil;
import com.ssafy.tong.user.model.User;
import com.ssafy.tong.user.model.service.UserService;

@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserController {

	private final UserService userService;
	private final JwtUtil jwtUtil;

	public UserController(UserService userService, JwtUtil jwtUtil) {
		super();
		this.userService = userService;
		this.jwtUtil = jwtUtil;
	}

	// 사용자 목록 전체 가져오기
	@GetMapping("/users")
	public ResponseEntity<?> users() {
		List<User> list = userService.getUserList();
		if (list == null || list.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<User>>(list, HttpStatus.OK);
	}

	// 사용자 회원가입
	@PostMapping("/signUp")
	public ResponseEntity<String> signUp(@RequestBody User user) {
		if (userService.signUp(user)) {
			return ResponseEntity.status(HttpStatus.CREATED).body("User added successfully");
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add user");
	}
	
	

	// 사용자 로그인
	@PostMapping("/signIn")
	public ResponseEntity<Map<String, Object>> signIn(@RequestBody User user) {
		HttpStatus status = null;
		Map<String, Object> result = new HashMap<>();
		User loginUser = userService.signIn(user.getUserId(), user.getPassword());

		System.out.println(loginUser);
		if (loginUser != null) {
			result.put("message", "로그인 성공");
			result.put("access-token", jwtUtil.createToken(loginUser.getName(), loginUser.getUserId()));
			status = HttpStatus.ACCEPTED;
		} else {
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<>(result, status);
	}
}
