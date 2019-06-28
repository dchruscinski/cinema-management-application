package com.chruscinskid.cinemamanagementapplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chruscinskid.cinemamanagementapplication.dao.FilmShowRepository;
import com.chruscinskid.cinemamanagementapplication.entity.FilmShow;

@Service
public class FilmShowServiceImpl implements FilmShowService {
	
	private FilmShowRepository filmShowRepository;
	
	@Autowired
	public FilmShowServiceImpl(FilmShowRepository theFilmShowRepository) {
		filmShowRepository = theFilmShowRepository;
	}

	@Override
	public List<FilmShow> findAll() {
		return filmShowRepository.findAllByOrderByIdAsc();
	}

	@Override
	public FilmShow findById(int theId) {
		
		Optional<FilmShow> result = filmShowRepository.findById(theId);
		
		FilmShow theFilmShow = null;
		
		if (result.isPresent()) {
			theFilmShow = result.get();
		}
		else {
			// if film show doesn't exist
			throw new RuntimeException("Did not find film show ID - " + theId);
		}
		
		return theFilmShow;
	}

	@Override
	public void save(FilmShow theFilmShow) {
		filmShowRepository.save(theFilmShow);
	}

	@Override
	public void deleteById(int theId) {
		filmShowRepository.deleteById(theId);
	}

}
