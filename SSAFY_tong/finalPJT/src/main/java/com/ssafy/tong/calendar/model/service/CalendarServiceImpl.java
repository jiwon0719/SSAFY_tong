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
	    // 1. 해당 날짜의 Calendar가 이미 존재하는지 확인
	    LocalDate pickedDate = quest.getPickDate();
	    Calendar existingCalendar = calendarDao.selectCalendarByDateAndUser(
	            quest.getUserId(),
	            pickedDate.getYear(),
	            pickedDate.getMonthValue(),
	            pickedDate.getDayOfMonth()
	    );

	    int calendarId;

	    if (existingCalendar != null) {
	        // 이미 존재하는 Calendar 사용
	        calendarId = existingCalendar.getCalendarId();
	    } else {
	        // 새로운 Calendar 생성
	        Calendar newCalendar = new Calendar();
	        newCalendar.setUserId(quest.getUserId());
	        newCalendar.setYear(pickedDate.getYear());
	        newCalendar.setMonth(pickedDate.getMonthValue());
	        newCalendar.setDate(pickedDate.getDayOfMonth());

	        calendarId = calendarDao.insertCalendar(newCalendar);
	    }

	    // 2. Quest 생성
	    quest.setCalendarId(calendarId);
	    calendarDao.insertQuest(quest);
	}
	
	
	// 예약 신청
	@Override
	public void createReservation(Reservation reservation) {
		Calendar newCalendar = createCalendarIfNotExists(reservation);
		if (newCalendar.getCalendarId() <= 0) {
		   throw new RuntimeException("Calendar creation failed"); // calendar_id 생성 실패시 예외처리
		}
		reservation.setCalendarId(newCalendar.getCalendarId()); // 생성된 calendar_id를 예약정보에 설정
		calendarDao.insertReservation(reservation); // 예약 정보 저장
	}

	// Calendar 존재 여부 확인 및 생성 로직
	private Calendar createCalendarIfNotExists(Reservation reservation) {
	   // 해당 날짜에 Calendar가 이미 존재하는지 확인
	   LocalDate pickedDate = reservation.getPickDate();
	   Calendar existingCalendar = calendarDao.selectCalendarByDateAndUser(
	       reservation.getUserId(),
	       pickedDate.getYear(),
	       pickedDate.getMonthValue(), 
	       pickedDate.getDayOfMonth()
	   );

	   if (existingCalendar != null) {
	       return existingCalendar; // 존재하면 기존 Calendar 반환
	   }

	   // 없으면 새로운 Calendar 생성
	   Calendar newCalendar = new Calendar();
	   newCalendar.setUserId(reservation.getUserId());
	   newCalendar.setYear(pickedDate.getYear());
	   newCalendar.setMonth(pickedDate.getMonthValue());
	   newCalendar.setDate(pickedDate.getDayOfMonth());

	   calendarDao.insertCalendar(newCalendar);
	   return newCalendar;
	}

	
	
	
	// (전문가용) 예약 조회
	@Override
	public List<Reservation> getExpertReservations(String expertId, LocalDate date) {
		return calendarDao.selectExpertReservations(expertId, date);
	}
	
	
	// 퀘스트 업데이트 
	@Override
	public void updateQuestStatus(int questId, String status) {
		calendarDao.updateQuestStatus(questId, status);
	}

	// 퀘스트 조회
	@Override
	public List<Quest> getExpertQuests(String expertId, LocalDate date) {
		return calendarDao.selectExpertQuests(expertId, date);
	}

}
