package com.ssafy.tong.calendar.model.service;

import java.time.LocalDate;
import java.util.List;

import com.ssafy.tong.calendar.model.Calendar;
import com.ssafy.tong.quest.model.Quest;
import com.ssafy.tong.reservation.model.Reservation;

public interface CalendarService {
	// 일정 조회
	List<Calendar> getCalendarByDate(String userId, LocalDate date);
	// 퀘스트 생성
	void createQuest(Quest questDTO);
	// 예약 신청
	void createReservation(Reservation reservationDTO);

}
