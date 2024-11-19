package com.ssafy.tong.reservation.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.tong.reservation.model.service.ReservationService;

@RestController
@RequestMapping("/api/expert/reservations")
@CrossOrigin
public class ReservationController {
    private final ReservationService reservationService;
    
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }
    
    // (전문가용) 예약 수락/거절
    @PatchMapping("/{reservationId}")
    public ResponseEntity<Void> updateReservationStatus(
            @PathVariable int reservationId,
            @RequestParam String status) {
        reservationService.updateStatus(reservationId, status);
        return ResponseEntity.ok().build();
    }
}