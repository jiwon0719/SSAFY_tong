package com.ssafy.tong.user.model;

import java.io.Serializable;

public class KakaoUserInfo implements Serializable {
    private String kakaoId;
    private String nickname;
    private String email;
    private String profileImage;
    private Character userType;
    private String birthdate;
	public KakaoUserInfo(String kakaoId, String nickname, String email, String profileImage, Character userType,
			String birthdate) {
		super();
		this.kakaoId = kakaoId;
		this.nickname = nickname;
		this.email = email;
		this.profileImage = profileImage;
		this.userType = userType;
		this.birthdate = birthdate;
	}
	public String getKakaoId() {
		return kakaoId;
	}
	public void setKakaoId(String kakaoId) {
		this.kakaoId = kakaoId;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getProfileImage() {
		return profileImage;
	}
	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}
	public Character getUserType() {
		return userType;
	}
	public void setUserType(Character userType) {
		this.userType = userType;
	}
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	
	@Override
	public String toString() {
		return "KakaoUserInfo [kakaoId=" + kakaoId + ", nickname=" + nickname + ", email=" + email + ", profileImage="
				+ profileImage + ", userType=" + userType + ", birthdate=" + birthdate + "]";
	}
    
}
