package com.ssafy.tong.expert.model;

public class ExpertCareer {
	private int expertCareerId;
	private int expertId;
	private String careerDetail;
	private String startDate;
	private String endDate;

	public int getExpertCareerId() {
		return expertCareerId;
	}
	public void setExpertCareerId(int expertCareerId) {
		this.expertCareerId = expertCareerId;
	}
	public int getExpertId() {
		return expertId;
	}
	public void setExpertId(int expertId) {
		this.expertId = expertId;
	}
	public String getCareerDetail() {
		return careerDetail;
	}
	public void setCareerDetail(String careerDetail) {
		this.careerDetail = careerDetail;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	@Override
	public String toString() {
		return "ExpertCareer [expertCareerId=" + expertCareerId + ", expertId=" + expertId + ", careerDetail="
				+ careerDetail + ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}
}
