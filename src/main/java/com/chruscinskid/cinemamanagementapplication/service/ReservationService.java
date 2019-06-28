package com.chruscinskid.cinemamanagementapplication.service;

import java.util.List;

import com.chruscinskid.cinemamanagementapplication.entity.Reservation;

public interface ReservationService {
	
	public List<Reservation> findAll();
	
	public Reservation findById(int theId);
	
	public void save(Reservation theReservation);
	
	public void deleteById(int theId);

}
