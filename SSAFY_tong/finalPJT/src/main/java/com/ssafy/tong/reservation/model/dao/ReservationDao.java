package com.ssafy.tong.reservation.model.dao;

import java.util.Map;

import com.ssafy.tong.reservation.model.Reservation;

public interface ReservationDao {

	Reservation getReservation(int reservationId);
	void updateStatus(Map<String, Object> params);

}
