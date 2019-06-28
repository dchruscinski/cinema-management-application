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
@Table(name = "film")
public class Film {

	/*
	 * ____________________________________________
	 * field definition
	 */
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "film_name")
	private String filmName;
	
	@Column(name = "genre")
	private String genre;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "production_time")
	private String productionTime;
	
	@Column(name = "film_length")
	private String filmLength;
	
	/*
	 * ____________________________________________
	 * OneToMany relation
	 */
	
	@OneToMany(mappedBy = "film",
			cascade = {CascadeType.PERSIST, CascadeType.MERGE,
					CascadeType.DETACH, CascadeType.REFRESH
					})
	private List<FilmShow> filmShows;
	
	/*
	 * ____________________________________________
	 * empty constructor and generated constructors
	 */
	
	public Film() {
		
	}

	public Film(int id, String filmName, String genre, String description, String productionTime,
			String filmLength, List<FilmShow> filmShows) {
		this.id = id;
		this.filmName = filmName;
		this.genre = genre;
		this.description = description;
		this.productionTime = productionTime;
		this.filmLength = filmLength;
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

	public String getFilmName() {
		return filmName;
	}

	public void setFilmName(String filmName) {
		this.filmName = filmName;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProductionTime() {
		return productionTime;
	}

	public void setProductionTime(String productionTime) {
		this.productionTime = productionTime;
	}

	public String getFilmLength() {
		return filmLength;
	}

	public void setFilmLength(String filmLength) {
		this.filmLength = filmLength;
	}

	public List<FilmShow> getFilmShows() {
		return filmShows;
	}

	public void setFilmShows(List<FilmShow> filmShows) {
		this.filmShows = filmShows;
	}
	
}
