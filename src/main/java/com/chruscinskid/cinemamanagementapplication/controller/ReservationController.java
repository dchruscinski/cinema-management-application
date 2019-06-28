package com.chruscinskid.cinemamanagementapplication.controller;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chruscinskid.cinemamanagementapplication.entity.Reservation;
import com.chruscinskid.cinemamanagementapplication.service.ReservationService;

public class ReservationController {
	
	private ReservationService reservationService;
	
	public ReservationController(ReservationService theReservationService) {
		reservationService = theReservationService;
	}
	
	// add mapping for "/list"

		@GetMapping("/list")
		public String listReservation(Model theModel) {
			
			// get reservation list from db
			List<Reservation> theReservations = reservationService.findAll();
			
			// add to the spring model
			theModel.addAttribute("reservation", theReservations);
			
			return "reservations/list-reservations";
		}
		
		@GetMapping("/showFormForAdd")
		public String showFormForAdd(Model theModel) {
			
			// create model attribute to bind form data
			Reservation theReservation = new Reservation();
			
			theModel.addAttribute("reservation", theReservation);
			
			return "reservations/reservation-form";
		}

		@GetMapping("/showFormForUpdate")
		public String showFormForUpdate(@RequestParam("reservationId") int theId,
										Model theModel) {
			
			// get the reservation from the service
			Reservation theReservation = reservationService.findById(theId);
			
			// set reservation as a model attribute to pre-populate the form
			theModel.addAttribute("reservation", theReservation);
			
			// send over to our form
			return "reservations/reservation-form";			
		}
		
		
		@PostMapping("/save")
		public String saveReservation(@ModelAttribute("reservation") Reservation theReservation) {
			
			// save new reservation
			reservationService.save(theReservation);
			
			// use a redirect to prevent duplicate submissions
			return "redirect:/reservations/list";
		}
		
		
		@GetMapping("/delete")
		public String delete(@RequestParam("reservationId") int theId) {
			
			// delete the reservation
			reservationService.deleteById(theId);
			
			// redirect to /reservations/list
			return "redirect:/reservations/list";
			
		}

}
