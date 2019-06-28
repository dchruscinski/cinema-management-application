package com.chruscinskid.cinemamanagementapplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chruscinskid.cinemamanagementapplication.dao.FilmRepository;
import com.chruscinskid.cinemamanagementapplication.entity.Film;

@Service
public class FilmServiceImpl implements FilmService {
	
	private FilmRepository filmRepository;
	
	@Autowired
	public FilmServiceImpl(FilmRepository theFilmRepository) {
		filmRepository = theFilmRepository;
	}

	@Override
	public List<Film> findAll() {
		return filmRepository.findAllByOrderByFilmNameAsc();
	}

	@Override
	public Film findById(int theId) {
		
		Optional<Film> result = filmRepository.findById(theId);
		
		Film theFilm = null;
		
		if (result.isPresent()) {
			theFilm = result.get();
		}
		else {
			// if film doesn't exist
			throw new RuntimeException("Did not find film ID - " + theId);
		}
		
		return theFilm;
	}

	@Override
	public void save(Film theFilm) {
		filmRepository.save(theFilm);

	}

	@Override
	public void deleteById(int theId) {
		filmRepository.deleteById(theId);

	}

}
