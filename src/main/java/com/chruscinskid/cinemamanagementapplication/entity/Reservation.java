package com.chruscinskid.cinemamanagementapplication.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reservation")
public class Reservation {

	/*
	 * ____________________________________________
	 * field definition
	 */
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name = "reserved_seats_number")
	private int reservedSeatsNumber;
	
	/*
	 * ____________________________________________
	 * ManyToOne relation
	 */
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH
			})
	@JoinColumn(name = "film_show_id")
	private FilmShow filmShow;
	
	/*
	 * ____________________________________________
	 * empty constructor and generated constructors
	 */
	
	public Reservation() {
		
	}

	public Reservation(int id, String firstName, String lastName, String email, String phoneNumber,
			int reservedSeatsNumber, FilmShow filmShow) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.reservedSeatsNumber = reservedSeatsNumber;
		this.filmShow = filmShow;
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getReservedSeatsNumber() {
		return reservedSeatsNumber;
	}

	public void setReservedSeatsNumber(int reservedSeatsNumber) {
		this.reservedSeatsNumber = reservedSeatsNumber;
	}

	public FilmShow getFilmShow() {
		return filmShow;
	}

	public void setFilmShow(FilmShow filmShow) {
		this.filmShow = filmShow;
	}
	
}
