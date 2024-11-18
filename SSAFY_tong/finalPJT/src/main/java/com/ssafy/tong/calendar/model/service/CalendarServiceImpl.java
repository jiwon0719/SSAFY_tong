package com.ssafy.tong.calendar.model.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.tong.calendar.model.Calendar;
import com.ssafy.tong.calendar.model.DailyScheduleDTO;
import com.ssafy.tong.calendar.model.dao.CalendarDao;
import com.ssafy.tong.quest.model.Quest;
import com.ssafy.tong.reservation.model.Reservation;

@Service
public class CalendarServiceImpl implements CalendarService {
	private final CalendarDao calendarDao;
	public CalendarServiceImpl(CalendarDao calendarDao) {
		this.calendarDao = calendarDao;
	}
	
	// 일정 조회
	@Override
	public DailyScheduleDTO getCalendarByDate(String userId, LocalDate date) {
        int year = date.getYear();
        int month = date.getMonthValue();
        int dayOfMonth = date.getDayOfMonth();
        
        List<Quest> quests = calendarDao.selectQuestsByDate(userId, year, month, dayOfMonth);
        List<Reservation> reservations = calendarDao.selectReservationsByDate(userId, year, month, dayOfMonth);
        
        return new DailyScheduleDTO(quests, reservations);
	}
	

	// 퀘스트 생성
	@Override
	public void createQuest(Quest quest) {
        // 1. Calendar 엔트리 생성
        LocalDate pickedDate = quest.getPickDate();
        Calendar calendar = new Calendar();
        calendar.setUserId(quest.getUserId());
        calendar.setYear(pickedDate.getYear());
        calendar.setMonth(pickedDate.getMonthValue());
        calendar.setDate(pickedDate.getDayOfMonth());
        
        // 1. 캘린더 생성
        int calendarId = calendarDao.insertCalendar(calendar);
        
        // 2. Quest 생성
        quest.setCalendarId(calendarId);
        calendarDao.insertQuest(quest);
	}
	
	
	// 예약 신청
	@Override
	public void createReservation(Reservation reservation) {
        // 1. Calendar 엔트리 생성
        LocalDate pickedDate = reservation.getPickDate();
        Calendar calendar = new Calendar();
        calendar.setUserId(reservation.getUserId());
        calendar.setYear(pickedDate.getYear());  // 전체 연도 사용
        calendar.setMonth(pickedDate.getMonthValue());
        calendar.setDate(pickedDate.getDayOfMonth());
        
        int calendarId = calendarDao.insertCalendar(calendar);
        
        // 2. Reservation 생성
        reservation.setCalendarId(calendarId);
        calendarDao.insertReservation(reservation);
    }

	// (전문가용) 예약 조회
	@Override
	public List<Reservation> getExpertReservations(String expertId, LocalDate date) {
		return calendarDao.selectExpertReservations(expertId, date);
	}

}
