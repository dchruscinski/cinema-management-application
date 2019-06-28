package com.chruscinskid.cinemamanagementapplication.service;

import java.util.List;

import com.chruscinskid.cinemamanagementapplication.entity.FilmShow;

public interface FilmShowService {
	
	public List<FilmShow> findAll();
	
	public FilmShow findById(int theId);
	
	public void save(FilmShow theFilmShow);
	
	public void deleteById(int theId);

}
