package com.chruscinskid.cinemamanagementapplication.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="screening_room")
public class ScreeningRoom {

	/*
	 * ____________________________________________
	 * field definition
	 */
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "room_number")
	private int roomNumber;
	
	@Column(name = "seats_number")
	private int seatsNumber;
	
	@Column(name = "free_seats_number")
	private int freeSeatsNumber;
	
	/*
	 * __________________
	 * OneToMany relation
	 */
	
	@OneToMany(mappedBy = "screeningRoom",
			cascade = {CascadeType.PERSIST, CascadeType.MERGE,
					CascadeType.DETACH, CascadeType.REFRESH
					})
	private List<FilmShow> filmShows;
	
	/*
	 * ____________________________________________
	 * empty constructor and generated constructors
	 */
	
	public ScreeningRoom() {
		
	}

	public ScreeningRoom(int id, int roomNumber, int seatsNumber, List<FilmShow> filmShows) {
		this.id = id;
		this.roomNumber = roomNumber;
		this.seatsNumber = seatsNumber;
		this.filmShows = filmShows;
	}
	
	/*
	 * _____________________________
	 * generated getters and setters
	 */

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public int getSeatsNumber() {
		return seatsNumber;
	}

	public void setSeatsNumber(int seatsNumber) {
		this.seatsNumber = seatsNumber;
	}

	public List<FilmShow> getFilmShows() {
		return filmShows;
	}

	public void setFilmShows(List<FilmShow> filmShows) {
		this.filmShows = filmShows;
	}

}











