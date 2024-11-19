package com.ssafy.tong.reservation.model.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ssafy.tong.reservation.model.dao.ReservationDao;

@Service
public class ReservationServiceImpl implements ReservationService {
    private final ReservationDao reservationDao;
    public ReservationServiceImpl(ReservationDao reservationDao) {
        this.reservationDao = reservationDao;
    }
	// (전문가용) 수락/거절
	@Override
	public void updateStatus(int reservationId, String status) {
        // 상태값 검증
        if (!isValidStatus(status)) {
            throw new IllegalArgumentException("Invalid status value");
        }
        
        // 예약 존재 여부 확인
        if (reservationDao.getReservation(reservationId) == null) {
            throw new RuntimeException("Reservation not found");
        }
        
        // 상태 업데이트
        Map<String, Object> params = new HashMap<>();
        params.put("reservationId", reservationId);
        params.put("status", status);
        
        reservationDao.updateStatus(params);
    }
    
    private boolean isValidStatus(String status) {
        return status != null && status.length() == 1 && 
               Arrays.asList('O', 'R').contains(status.charAt(0));
    }

}
