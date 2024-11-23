package com.ssafy.tong.user.model;

// 날짜정보까지만 필요해서 java.sql.Date 사용 (yyyy-mm-dd 형식)
// 만약 시간정보까지 필요하면 java.util.Date 사용하면 된다.
import java.sql.Date;   

public class User {
	private String userId; // 아이디 (일반 유저: 입력된 ID, 카카오 유저: 카카오 고유 ID)
	private char userType; // 사용자 유형 (U: 일반 유저, E: 전문가 유저, A: 관리자)
	private String password; // 비밀번호
	private String name; // 이름
	private String email; // 이메일
	private String phone; // 전화번호
	private String birthdate; // 생일
	private String addressZipcode; // 우편 주소
	private String address; // 주소
	private String addressDetail; // 주소
	private Date updatedPassword; // 비밀번호 변경 날짜
	private char isKakaoMember; // 카카오 유저 여부 ('O': 카카오 유저, 'X': 일반 유저)
	private String userProfileImgPath; // user 프로필 이미지 경로
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public char getUserType() {
		return userType;
	}
	public void setUserType(char userType) {
		this.userType = userType;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	public String getAddressZipcode() {
		return addressZipcode;
	}
	public void setAddressZipcode(String addressZipcode) {
		this.addressZipcode = addressZipcode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddressDetail() {
		return addressDetail;
	}
	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}
	public Date getUpdatedPassword() {
		return updatedPassword;
	}
	public void setUpdatedPassword(Date updatedPassword) {
		this.updatedPassword = updatedPassword;
	}
	public char getIsKakaoMember() {
		return isKakaoMember;
	}
	public void setIsKakaoMember(char isKakaoMember) {
		this.isKakaoMember = isKakaoMember;
	}
	public String getUserProfileImgPath() {
		return userProfileImgPath;
	}
	public void setUserProfileImgPath(String userProfileImgPath) {
		this.userProfileImgPath = userProfileImgPath;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userType=" + userType + ", password=" + password + ", name=" + name
				+ ", email=" + email + ", phone=" + phone + ", birthdate=" + birthdate + ", addressZipcode="
				+ addressZipcode + ", address=" + address + ", addressDetail=" + addressDetail + ", updatedPassword="
				+ updatedPassword + ", isKakaoMember=" + isKakaoMember + ", user_profile_img_path="
				+ userProfileImgPath + "]";
	}
	
	
	
}

