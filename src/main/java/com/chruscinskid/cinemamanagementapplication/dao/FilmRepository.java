package com.chruscinskid.cinemamanagementapplication.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chruscinskid.cinemamanagementapplication.entity.Film;

public interface FilmRepository extends JpaRepository<Film, Integer> {
	
	// sorting by film name ascending method
	public List<Film> findAllByOrderByFilmNameAsc();
	
}
