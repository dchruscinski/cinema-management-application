package com.chruscinskid.cinemamanagementapplication.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="film_show")
public class FilmShow {

		// define fields
		
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="id")
		private int id;
		
		@Column(name="show_start_time")
		@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
		private LocalDateTime showStartTime;
		
		@ManyToOne
		@JoinColumn
		private Film film;
		
		@ManyToOne
		@JoinColumn(name = "screening_room_id")
		private ScreeningRoom screeningRoom;
	
}
