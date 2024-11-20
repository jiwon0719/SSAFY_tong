package com.ssafy.tong.expert.model;

// user 테이블과 expert 테이블 조인
// 전문가 리스트 보이기 위함
public class ExpertList {
	private int expertId; // expert
	private String userId; // user
	private String name; // user
	private String addressZipcode;
	private String address;
	private String addressDetail;
	private String grade; // expert
	private String userProfileImgPath; // user
	private String status;
	private String createAt;
	private Integer score;
    private Integer totalScore;
    private Integer totalScoreCnt;
	
    // 평균 점수 계산 메서드
    public double getAverageScore() {
        if (totalScoreCnt == null || totalScoreCnt == 0) return 0.0;
        return Math.round((double)totalScore / totalScoreCnt * 10) / 10.0;
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
	public Integer getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(Integer totalScore) {
		this.totalScore = totalScore;
	}
	public Integer getTotalScoreCnt() {
		return totalScoreCnt;
	}
	public void setTotalScoreCnt(Integer totalScoreCnt) {
		this.totalScoreCnt = totalScoreCnt;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
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
		return "ExpertList [expertId=" + expertId + ", userId=" + userId + ", name=" + name + ", addressZipcode="
				+ addressZipcode + ", address=" + address + ", addressDetail=" + addressDetail + ", grade=" + grade
				+ ", userProfileImgPath=" + userProfileImgPath + ", status=" + status + ", createAt=" + createAt
				+ ", score=" + score + ", totalScore=" + totalScore + ", totalScoreCnt=" + totalScoreCnt + "]";
	}
}
