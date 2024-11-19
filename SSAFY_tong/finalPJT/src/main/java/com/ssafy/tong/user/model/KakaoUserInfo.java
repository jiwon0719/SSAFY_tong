package com.ssafy.tong.user.model;

public class KakaoUserInfo {
    private String kakaoId;
    private String nickname;
    private String email;
    private String profileImage;

    public KakaoUserInfo(String kakaoId, String nickname, String email, String profileImage) {
        this.kakaoId = kakaoId;
        this.nickname = nickname;
        this.email = email;
        this.profileImage = profileImage;
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
}
