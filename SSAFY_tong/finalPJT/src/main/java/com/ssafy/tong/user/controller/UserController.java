package com.ssafy.tong.user.controller;

import java.util.Map;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.tong.user.model.User;
import com.ssafy.tong.user.model.service.UserService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/user")
@CrossOrigin
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping("/signUp")
	public void signUp(@RequestBody User user, HttpSession session) {
		// 세션에서 Kakao 사용자 정보 가져오기
		String kakaoUserInfo = (String) session.getAttribute("kakaoUserInfo");
		
		if (kakaoUserInfo != null) {
			JSONObject userJson = new JSONObject(kakaoUserInfo);

			// Kakao 사용자 정보에서 ID, 이메일 추출
			String kakaoId = String.valueOf(userJson.getLong("id"));
			String email = userJson.getJSONObject("kakao_account").optString("email", "");
			String profileImg = userJson.getJSONObject("properties").getString("profile_image");

			// User 객체에 Kakao 사용자 정보 설정
			user.setUserId(kakaoId); // 카카오 고유 ID를 userId로 사용
			user.setEmail(email);
			user.setIsKakaoMember('O'); // 'O'로 설정하여 Kakao 유저임을 표시
			user.setPassword(""); // 비밀번호는 빈 문자열로 설정
			user.setUserProfileImgPath(profileImg);
			
			// UserService를 통해 회원가입 처리
			userService.signUp(user);
			
			// 세션에 로그인 유저 정보 저장
			session.setAttribute("user", user);
		}

		else {
			user.setIsKakaoMember('X'); // 'X'로 설정 
			
			// UserService를 통해 회원가입 처리
			userService.signUp(user);
			
			// 세션에 로그인 유저 정보 저장
			session.setAttribute("user", user);
			
		}

		// 나중에 메인 페이지로 리다이렉트
		// new ModelAndView("redirect:/main");
	}

	// 로그인
	@PostMapping("/signIn")
	public ResponseEntity<String> signIn(@RequestBody User user, HttpSession session) {
		User user_signIn = userService.signIn(user.getUserId(), user.getPassword());

		if (user_signIn != null) {
			// 로그인 성공 시 세션에 사용자 정보 저장
			session.setAttribute("user", user_signIn);
			return ResponseEntity.ok("로그인 성공");
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인 실패: 아이디 또는 비밀번호가 잘못되었습니다.");
		}
	}

	// 로그아웃
	@PostMapping("/signOut")
	public ResponseEntity<String> signOut(HttpSession session) {
		// 세션에서 사용자 정보 제거
		if (session.getAttribute("user") != null) {
			session.invalidate(); // 세션 무효화
			return ResponseEntity.ok("로그아웃 성공");
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("로그인된 사용자가 없습니다.");
	}

	// 비밀번호 변경
	@PutMapping("/updatePassword")
	public ResponseEntity<String> updatePassword(@RequestBody Map<String, String> passwordMap, HttpSession session) {
		// 세션에서 로그인된 사용자 정보 가져오기
		User loggedInUser = (User) session.getAttribute("user");

		if (loggedInUser == null) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인 상태가 아닙니다.");
		}

		// 입력받은 새 비밀번호와 확인 비밀번호 가져오기
		String newPassword = passwordMap.get("newPassword");
		String confirmPassword = passwordMap.get("confirmPassword");

		// 비밀번호 확인
		if (newPassword == null || confirmPassword == null || !newPassword.equals(confirmPassword)) {
			return ResponseEntity.badRequest().body("새 비밀번호와 비밀번호 확인이 일치하지 않습니다.");
		}

		// 새로운 비밀번호로 업데이트
		loggedInUser.setPassword(newPassword); // 새 비밀번호 설정
		userService.updatePassword(loggedInUser);

		return ResponseEntity.ok("비밀번호가 성공적으로 변경되었습니다.");
	}

}
