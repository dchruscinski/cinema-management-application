package com.chruscinskid.cinemamanagementapplication.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chruscinskid.cinemamanagementapplication.entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
	
	// sorting by reservation id ascending method
	public List<Reservation> findAllByOrderByIdAsc();

}
