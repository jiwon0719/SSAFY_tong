package com.ssafy.tong.calendar.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.tong.calendar.model.Calendar;
import com.ssafy.tong.calendar.model.DailyScheduleDTO;
import com.ssafy.tong.calendar.model.service.CalendarService;
import com.ssafy.tong.quest.model.Quest;
import com.ssafy.tong.reservation.model.Reservation;

@RestController
@RequestMapping("/api/calendar")
@CrossOrigin
public class CalendarController {
	private final CalendarService calendarService;
	public CalendarController(CalendarService calendarService) {
		this.calendarService = calendarService;
	}
	
    // (유저용) 특정 날짜의 일정 조회
    @GetMapping("/{userId}/{date}")
    public ResponseEntity<DailyScheduleDTO> getCalendarByDate(
            @PathVariable String userId,
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
    	
        LocalDate adjustedDate = date.plusDays(1);
        System.out.println("Request received - userId: " + userId + ", date: " + adjustedDate);
        
        DailyScheduleDTO result = calendarService.getCalendarByDate(userId, adjustedDate);
        
        System.out.println("Response data: " + result);
        return ResponseEntity.ok(result);
    }

    // (전문가용) 예약 조회
    @GetMapping("/expert/reservations")
    public ResponseEntity<List<Reservation>> getExpertReservations(
        @RequestParam String expertId,
        @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        
        List<Reservation> reservations = calendarService.getExpertReservations(expertId, date);
        return ResponseEntity.ok(reservations);
    }    
    
    
    
    // 퀘스트 생성 (전문가용)
    @PostMapping("/quest")
    public ResponseEntity<Void> createQuest(@RequestBody Quest quest) {
        calendarService.createQuest(quest);
        return ResponseEntity.ok().build();
    }

    // 예약 신청 (일반회원용)
    @PostMapping("/reservation")
    public ResponseEntity<Void> createReservation(@RequestBody Reservation reservation) {
        calendarService.createReservation(reservation);
        return ResponseEntity.ok().build();
    }
			
}
