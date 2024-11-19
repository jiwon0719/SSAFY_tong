package com.ssafy.tong.reservation.model;

import java.time.LocalDate;

public class Reservation {
	private int reservationId;
	private int calendarId;
	private String userId;
	private String expertUserId;
	private String time;
	private char status;
	private LocalDate pickDate; // 프론트에서 날짜 선택용
	
	
	public LocalDate getPickDate() {
		return pickDate;
	}
	public void setPickDate(LocalDate pickDate) {
		this.pickDate = pickDate;
	}
	public int getReservationId() {
		return reservationId;
	}
	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}
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
	public String getExpertUserId() {
		return expertUserId;
	}
	public void setExpertUserId(String expertUserId) {
		this.expertUserId = expertUserId;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Reservation [reservationId=" + reservationId + ", calendarId=" + calendarId + ", userId=" + userId
				+ ", expertUserId=" + expertUserId + ", time=" + time + ", status=" + status + "]";
	}
}
