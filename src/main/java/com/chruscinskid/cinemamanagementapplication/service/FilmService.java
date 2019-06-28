package com.chruscinskid.cinemamanagementapplication.service;

import java.util.List;

import com.chruscinskid.cinemamanagementapplication.entity.Film;

public interface FilmService {
	
	public List<Film> findAll();
	
	public Film findById(int theId);
	
	public void save(Film theFilm);
	
	public void deleteById(int theId);

}
