package com.ssafy.tong.calendar.model;

import java.util.List;

import com.ssafy.tong.quest.model.Quest;
import com.ssafy.tong.reservation.model.Reservation;

public class DailyScheduleDTO {
	
    private List<Quest> quests;
    private List<Reservation> reservations;
    public DailyScheduleDTO(List<Quest> quests, List<Reservation> reservations) {
		this.quests = quests;
		this.reservations = reservations;
	}
	public List<Quest> getQuests() {
		return quests;
	}
	public void setQuests(List<Quest> quests) {
		this.quests = quests;
	}
	public List<Reservation> getReservations() {
		return reservations;
	}
	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
	@Override
	public String toString() {
		return "DailyScheduleDTO [quests=" + quests + ", reservations=" + reservations + "]";
	}	
}
