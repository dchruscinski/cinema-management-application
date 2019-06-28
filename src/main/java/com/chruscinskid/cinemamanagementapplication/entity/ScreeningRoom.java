package com.chruscinskid.cinemamanagementapplication.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="screening_room")
public class ScreeningRoom {

	// define fields
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "room_number")
	private int roomNumber;
	
	@Column(name = "seat_number")
	private int seatNumber;
	
	@OneToMany(mappedBy = "screeningRoom")
	@JoinColumn(name = "film_show_id")
	private FilmShow filmShow;
	
	

}











