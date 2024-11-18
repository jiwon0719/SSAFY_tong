package com.ssafy.tong.calendar.model.dao;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssafy.tong.calendar.model.Calendar;
import com.ssafy.tong.quest.model.Quest;
import com.ssafy.tong.reservation.model.Reservation;

public interface CalendarDao {
	// 일정 조회
	List<Calendar> selectCalendarByDate(
	        @Param("userId") String userId, 
	        @Param("year") int year, 
	        @Param("month") int month, 
	        @Param("date") int date
	);
	// 캘린더 생성
	int insertCalendar(Calendar calendar);
	// 퀘스트 생성
	void insertQuest(Quest quest);
	// 예약 신청
	void insertReservation(Reservation reservation);
	
	
	List<Quest> selectQuestsByDate(
		    @Param("userId") String userId,
		    @Param("year") int year,
		    @Param("month") int month,
		    @Param("dayOfMonth") int dayOfMonth
		);
	
	List<Reservation> selectReservationsByDate(
		    @Param("userId") String userId,
		    @Param("year") int year,
		    @Param("month") int month,
		    @Param("dayOfMonth") int dayOfMonth
		);
	
	// (전문가용) 예약 조회
	List<Reservation> selectExpertReservations(@Param("expertId") String expertId, 
											   @Param("date") LocalDate date);
}