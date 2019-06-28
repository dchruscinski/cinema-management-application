package com.chruscinskid.cinemamanagementapplication.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chruscinskid.cinemamanagementapplication.entity.FilmShow;
import com.chruscinskid.cinemamanagementapplication.service.FilmShowService;

@Controller
@RequestMapping("/film_show")
public class FilmShowController {
	
	private FilmShowService filmShowService;
	
	public FilmShowController(FilmShowService theFilmShowService) {
		filmShowService = theFilmShowService;
	}
	
	// add mapping for "/list"

		@GetMapping("/list")
		public String listFilmShow(Model theModel) {
			
			// get film show list from db
			List<FilmShow> theFilmShows = filmShowService.findAll();
			
			// add to the spring model
			theModel.addAttribute("film_show", theFilmShows);
			
			return "film_shows/list-film_shows";
		}
		
		@GetMapping("/showFormForAdd")
		public String showFormForAdd(Model theModel) {
			
			// create model attribute to bind form data
			FilmShow theFilmShow = new FilmShow();
			
			theModel.addAttribute("film_show", theFilmShow);
			
			return "film_shows/film_show-form";
		}

		@GetMapping("/showFormForUpdate")
		public String showFormForUpdate(@RequestParam("filmShowId") int theId,
										Model theModel) {
			
			// get the film show from the service
			FilmShow theFilmShow = filmShowService.findById(theId);
			
			// set film show as a model attribute to pre-populate the form
			theModel.addAttribute("film_show", theFilmShow);
			
			// send over to our form
			return "film_shows/film_show-form";			
		}
		
		
		@PostMapping("/save")
		public String saveFilmShow(@ModelAttribute("film_show") FilmShow theFilmShow) {
			
			// save new film show
			filmShowService.save(theFilmShow);
			
			// use a redirect to prevent duplicate submissions
			return "redirect:/film_shows/list";
		}
		
		
		@GetMapping("/delete")
		public String delete(@RequestParam("filmShowId") int theId) {
			
			// delete the film
			filmShowService.deleteById(theId);
			
			// redirect to /films/list
			return "redirect:/filmshows/list";
			
		}

}
