package com.chruscinskid.cinemamanagementapplication.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

public class Reservation {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "seat_reservation_number")
	private int seatReservationNumber;
	
	@OneToMany(mappedBy = "reservation")
	@JoinColumn(name = "film_show_id")
	private FilmShow filmShow;
	
}
