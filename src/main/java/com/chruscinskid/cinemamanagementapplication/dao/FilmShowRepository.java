package com.chruscinskid.cinemamanagementapplication.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chruscinskid.cinemamanagementapplication.entity.FilmShow;

public interface FilmShowRepository extends JpaRepository<FilmShow, Integer> {

	// sorting by film show id ascending method
	public List<FilmShow> findAllByOrderByIdAsc();
	
}
