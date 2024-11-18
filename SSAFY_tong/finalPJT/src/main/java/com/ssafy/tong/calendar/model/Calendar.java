package com.ssafy.tong.calendar.model;

public class Calendar {
	private int calendarId;
	private String userId;
	private int year;
	private int month; 
	private int date;
	
	public int getCalendarId() {
		return calendarId;
	}
	public void setCalendarId(int calendarId) {
		this.calendarId = calendarId;
	}
	public String getUserId() {
		return userId;
	}           
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Calendar [calendarId=" + calendarId + ", userId=" + userId + ", year=" + year + ", month=" + month
				+ ", date=" + date + "]";
	}
}
