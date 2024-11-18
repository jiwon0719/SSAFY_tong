package com.ssafy.tong.reservation.model.service;

public interface ReservationService {
	// (전문가용) 수락/거절
	void updateStatus(int reservationId, String status);

}
