package com.ssafy.tong.expert.model;

public class Expert {
	private int expertId;
	private String userId; // 전문가 아이디
	private String location; // 회사 위치 ex) 대전시 유성구 싸피동
	private String introduction; // 전문가 소개
	private int price; // 가격
	private String priceDetail; // 가격 상세
	private String grade; // 직급 ex) 점장, 프로
	private int totalScore; // INSERT 시에 update. 회원들이 매긴 점수 전체
	private int totalScoreCnt; // INSERT 시에 update. 회원들이 매긴 갯수 
	private String companyName; // 회사명
	private double latitude; // 위도
	private double longitude; // 경도
	
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getPriceDetail() {
		return priceDetail;
	}
	public void setPriceDetail(String priceDetail) {
		this.priceDetail = priceDetail;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public int getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}
	public int getTotalScoreCnt() {
		return totalScoreCnt;
	}
	public void setTotalScoreCnt(int totalScoreCnt) {
		this.totalScoreCnt = totalScoreCnt;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	@Override
	public String toString() {
		return "Expert [expertId=" + expertId + ", userId=" + userId + ", location=" + location + ", introduction="
				+ introduction + ", price=" + price + ", priceDetail=" + priceDetail + ", grade=" + grade
				+ ", totalScore=" + totalScore + ", totalScoreCnt=" + totalScoreCnt + ", companyName=" + companyName
				+ ", latitude=" + latitude + ", longitude=" + longitude + "]";
	}
}
