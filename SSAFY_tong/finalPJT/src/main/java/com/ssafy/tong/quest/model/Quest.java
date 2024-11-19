package com.ssafy.tong.quest.model;

import java.time.LocalDate;

public class Quest {
	private int questId;
	private int calendarId;
	private String expertUserId;
	private String userId;
	private String questTitle;
	private String questDetail;
	private char completionStatus;
	private LocalDate pickDate;

	public String getExpertUserId() {
		return expertUserId;
	}
	public void setExpertUserId(String expertUserId) {
		this.expertUserId = expertUserId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public LocalDate getPickDate() {
		return pickDate;
	}
	public void setPickDate(LocalDate pickDate) {
		this.pickDate = pickDate;
	}
	public int getQuestId() {
		return questId;
	}
	public void setQuestId(int questId) {
		this.questId = questId;
	}
	public int getCalendarId() {
		return calendarId;
	}
	public void setCalendarId(int calendarId) {
		this.calendarId = calendarId;
	}

	public String getQuestTitle() {
		return questTitle;
	}
	public void setQuestTitle(String questTitle) {
		this.questTitle = questTitle;
	}
	public String getQuestDetail() {
		return questDetail;
	}
	public void setQuestDetail(String questDetail) {
		this.questDetail = questDetail;
	}
	public char getCompletionStatus() {
		return completionStatus;
	}
	public void setCompletionStatus(char completionStatus) {
		this.completionStatus = completionStatus;
	}
	@Override
	public String toString() {
		return "Quest [questId=" + questId + ", calendarId=" + calendarId + ", expertUserId=" + expertUserId + ", userId="
				+ userId + ", questTitle=" + questTitle + ", questDetail=" + questDetail + ", completionStatus="
				+ completionStatus + "]";
	} 
}
