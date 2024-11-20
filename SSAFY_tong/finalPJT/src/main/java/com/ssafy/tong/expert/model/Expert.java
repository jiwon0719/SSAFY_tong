package com.ssafy.tong.expert.model;

import java.util.List;

public class Expert {
	private int expertId;
	private String userId; // 전문가 아이디
	private String addressZipcode;
	private String address;
	private String addressDetail;
	private String introduction; // 전문가 소개
	private int price; // 가격
	private String priceDetail; // 가격 상세
	private String grade; // 직급 ex) 점장, 프로
	private int totalScore; // INSERT 시에 update. 회원들이 매긴 점수 전체
	private int totalScoreCnt; // INSERT 시에 update. 회원들이 매긴 갯수 
	private String companyName; // 회사명
	private List<ExpertImage> expertImage; // 전문가 상세페이지 - 이미지
	private List<ExpertCareer> expertCareer; // 전문가 경력
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
	public List<ExpertImage> getExpertImage() {
		return expertImage;
	}
	public void setExpertImage(List<ExpertImage> expertImage) {
		this.expertImage = expertImage;
	}
	public List<ExpertCareer> getExpertCareer() {
		return expertCareer;
	}
	public void setExpertCareer(List<ExpertCareer> expertCareer) {
		this.expertCareer = expertCareer;
	}
	@Override
	public String toString() {
		return "Expert [expertId=" + expertId + ", userId=" + userId + ", addressZipcode=" + addressZipcode
				+ ", address=" + address + ", addressDetail=" + addressDetail + ", introduction=" + introduction
				+ ", price=" + price + ", priceDetail=" + priceDetail + ", grade=" + grade + ", totalScore="
				+ totalScore + ", totalScoreCnt=" + totalScoreCnt + ", companyName=" + companyName + ", expertImage="
				+ expertImage + ", expertCareer=" + expertCareer + "]";
	}
}
