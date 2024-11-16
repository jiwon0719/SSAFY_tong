package com.ssafy.tong.expert.model;

// user 테이블과 expert 테이블 조인
// 전문가 리스트 보이기 위함
public class ExpertList {
	private int expertId; // expert
	private String userId; // user
	private String name; // user
	private String loacation; // expert
	private String grade; // expert
	private String userProfileImgPath; // user
	public int getExpertId() {
		return expertId;
	}
	public void setExpertId(int expertId) {
		this.expertId = expertId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLoacation() {
		return loacation;
	}
	public void setLoacation(String loacation) {
		this.loacation = loacation;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getUserProfileImgPath() {
		return userProfileImgPath;
	}
	public void setUserProfileImgPath(String userProfileImgPath) {
		this.userProfileImgPath = userProfileImgPath;
	}
	@Override
	public String toString() {
		return "ExpertList [expertId=" + expertId + ", userId=" + userId + ", name=" + name + ", loacation=" + loacation
				+ ", grade=" + grade + ", userProfileImgPath=" + userProfileImgPath + "]";
	}
}
