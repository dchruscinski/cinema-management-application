package com.chruscinskid.cinemamanagementapplication.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="film")
public class Film {

	// define fields
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="film_name")
	private String filmName;
	
	@Column
	private String genre;
	
	@Column
	private String description;
	
	@Column(name = "production_time")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate productionTime;
	
	@Column(name = "film_length")
	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	private LocalTime filmLength;
	
	@OneToMany(mappedBy = "film")
	@JoinColumn
	private FilmShow filmShow;
	
}
