package com.chruscinskid.cinemamanagementapplication.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "film_show")
public class FilmShow {

	/*
	 * ____________________________________________
	 * field definition
	 */
		
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
		
	@Column(name = "show_start_time")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private LocalDateTime showStartTime;
	
	@Column(name = "free_seats")
	private int freeSeats;
	
	/*
	 * ____________________________________________
	 * OneToMany / ManyToOne relations
	 */
		
	@OneToMany(mappedBy = "filmShow",
			cascade = {CascadeType.PERSIST, CascadeType.MERGE,
					CascadeType.DETACH, CascadeType.REFRESH
					})
	private List<Reservation> reservations;
	
	//___________________________________________________________
		
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
				CascadeType.DETACH, CascadeType.REFRESH
				})
	@JoinColumn(name = "film_id")
	private Film film;
	
	//___________________________________________________________
		
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
				CascadeType.DETACH, CascadeType.REFRESH
				})
	@JoinColumn(name = "screening_room_id")
	private ScreeningRoom screeningRoom;

	/*
	 * ____________________________________________
	 * empty constructor and generated constructors
	 */
	
	public FilmShow() {
			
	}
		
	public FilmShow(int id, LocalDateTime showStartTime, List<Reservation> reservations, Film film,
			ScreeningRoom screeningRoom) {
		this.id = id;
		this.showStartTime = showStartTime;
		this.reservations = reservations;
		this.film = film;
		this.screeningRoom = screeningRoom;
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

	public LocalDateTime getShowStartTime() {
		return showStartTime;
	}

	public void setShowStartTime(LocalDateTime showStartTime) {
		this.showStartTime = showStartTime;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public ScreeningRoom getScreeningRoom() {
		return screeningRoom;
	}

	public void setScreeningRoom(ScreeningRoom screeningRoom) {
		this.screeningRoom = screeningRoom;
	}
		
}
