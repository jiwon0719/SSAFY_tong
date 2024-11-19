package com.ssafy.tong.calendar.model.service;

import java.time.LocalDate;
import java.util.List;

import com.ssafy.tong.calendar.model.Calendar;
import com.ssafy.tong.calendar.model.DailyScheduleDTO;
import com.ssafy.tong.quest.model.Quest;
import com.ssafy.tong.reservation.model.Reservation;

public interface CalendarService {
	// 일정 조회
	DailyScheduleDTO getCalendarByDate(String userId, LocalDate date);
	// (전문가용) 예약 조회
	List<Reservation> getExpertReservations(String expertId, LocalDate date);
	// 퀘스트 생성
	void createQuest(Quest questDTO);
	// 예약 신청
	void createReservation(Reservation reservationDTO);
	// 퀘스트 상태 업데이트 
	void updateQuestStatus(int questId, String status);
	// 퀘스트 조회
	List<Quest> getExpertQuests(String expertId, LocalDate date);

}
