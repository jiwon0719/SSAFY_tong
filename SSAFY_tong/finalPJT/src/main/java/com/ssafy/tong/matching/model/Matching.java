package com.ssafy.tong.matching.model;

public class Matching {
    private int matchingId;
    private String userId;
    private String expertUserId;
    private char status;
    private String createdAt;
    private int score;
	public int getMatchingId() {
		return matchingId;
	}
	public void setMatchingId(int matchingId) {
		this.matchingId = matchingId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getExpertUserId() {
		return expertUserId;
	}
	public void setExpertUserId(String expertUserId) {
		this.expertUserId = expertUserId;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "Matching [matchingId=" + matchingId + ", userId=" + userId + ", expertUserId=" + expertUserId
				+ ", status=" + status + ", createdAt=" + createdAt + ", score=" + score + "]";
	}
}
