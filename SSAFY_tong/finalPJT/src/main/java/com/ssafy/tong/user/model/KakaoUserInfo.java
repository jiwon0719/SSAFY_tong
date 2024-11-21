package com.ssafy.tong.user.model;

public class KakaoUserInfo {
    private String kakaoId;
    private String nickname;
    private String email;
    private String profileImage;
    private char userType; // user 테이블 참조

	public KakaoUserInfo(String kakaoId, String nickname, String email, String profileImage) {
		super();
		this.kakaoId = kakaoId;
		this.nickname = nickname;
		this.email = email;
		this.profileImage = profileImage;
	}
    
	public KakaoUserInfo(String kakaoId, String nickname, String email, String profileImage, char userType) {
		super();
		this.kakaoId = kakaoId;
		this.nickname = nickname;
		this.email = email;
		this.profileImage = profileImage;
		this.userType = userType;
	}

	public String getkakaoId() {
        return kakaoId;
    }

    public void setkakaoId(String kakaoId) {
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

	public String getKakaoId() {
		return kakaoId;
	}

	public void setKakaoId(String kakaoId) {
		this.kakaoId = kakaoId;
	}

	public char getUserType() {
		return userType;
	}

	public void setUserType(char userType) {
		this.userType = userType;
	}    
}
