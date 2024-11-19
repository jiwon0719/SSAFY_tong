package com.ssafy.tong.expert.model;

public class UserList {
	private String userId; // user
	private String name; // user
	private String userProfileImgPath; // user
	private char status; // matching
	private String createAt; // matching
	private Integer score; // matching
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
	public String getUserProfileImgPath() {
		return userProfileImgPath;
	}
	public void setUserProfileImgPath(String userProfileImgPath) {
		this.userProfileImgPath = userProfileImgPath;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}
	public String getCreateAt() {
		return createAt;
	}
	public void setCreateAt(String createAt) {
		this.createAt = createAt;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "UserList [userId=" + userId + ", name=" + name + ", userProfileImgPath=" + userProfileImgPath
				+ ", status=" + status + ", createAt=" + createAt + ", score=" + score
				+ "]";
	}
}
