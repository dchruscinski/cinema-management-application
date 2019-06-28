package com.chruscinskid.cinemamanagementapplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chruscinskid.cinemamanagementapplication.dao.ReservationRepository;
import com.chruscinskid.cinemamanagementapplication.entity.Reservation;

@Service
public class ReservationServiceImpl implements ReservationService {
	
	private ReservationRepository reservationRepository;
	
	@Autowired
	public ReservationServiceImpl (ReservationRepository theReservationRepository) {
		reservationRepository = theReservationRepository;
	}

	@Override
	public List<Reservation> findAll() {
		return reservationRepository.findAllByOrderByIdAsc();
	}

	@Override
	public Reservation findById(int theId) {
		
		Optional <Reservation> result = reservationRepository.findById(theId);
		
		Reservation theReservation = null;
		
		if (result.isPresent()) {
			theReservation = result.get();
		}
		else {
			throw new RuntimeException("Did not find reservation ID - " + theId);
		}
		
		return theReservation;
	}

	@Override
	public void save(Reservation theReservation) {
		reservationRepository.save(theReservation);
	}

	@Override
	public void deleteById(int theId) {
		reservationRepository.deleteById(theId);
	}

}
