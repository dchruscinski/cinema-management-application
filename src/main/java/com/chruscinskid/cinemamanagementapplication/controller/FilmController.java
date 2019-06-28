package com.chruscinskid.cinemamanagementapplication.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chruscinskid.cinemamanagementapplication.entity.Film;
import com.chruscinskid.cinemamanagementapplication.service.FilmService;

@Controller
@RequestMapping("/films")
public class FilmController {
	
	private FilmService filmService;
	
	public FilmController(FilmService theFilmService) {
		filmService = theFilmService;
	}
	
	// add mapping for "/list"

	@GetMapping("/list")
	public String listFilms(Model theModel) {
		
		// get film list from db
		List<Film> theFilms = filmService.findAll();
		
		// add to the spring model
		theModel.addAttribute("films", theFilms);
		
		return "films/list-films";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Film theFilm = new Film();
		
		theModel.addAttribute("film", theFilm);
		
		return "films/film-form";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("filmId") int theId,
									Model theModel) {
		
		// get the film from the service
		Film theFilm = filmService.findById(theId);
		
		// set film as a model attribute to pre-populate the form
		theModel.addAttribute("film", theFilm);
		
		// send over to our form
		return "films/film-form";			
	}
	
	
	@PostMapping("/save")
	public String saveFilm(@ModelAttribute("film") Film theFilm) {
		
		// save new film
		filmService.save(theFilm);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/films/list";
	}
	
	
	@GetMapping("/delete")
	public String delete(@RequestParam("filmId") int theId) {
		
		// delete the film
		filmService.deleteById(theId);
		
		// redirect to /films/list
		return "redirect:/films/list";
		
	}

}
