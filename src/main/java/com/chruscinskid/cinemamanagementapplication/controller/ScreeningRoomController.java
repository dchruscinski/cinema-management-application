package com.chruscinskid.cinemamanagementapplication.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chruscinskid.cinemamanagementapplication.entity.ScreeningRoom;
import com.chruscinskid.cinemamanagementapplication.service.ScreeningRoomService;

@Controller
@RequestMapping("/screening_room")
public class ScreeningRoomController {
	
	private ScreeningRoomService screeningRoomService;
	
	public ScreeningRoomController(ScreeningRoomService theScreeningRoomService) {
		screeningRoomService = theScreeningRoomService;
	}

	// add mapping for "/list"

	@GetMapping("/list")
	public String listScreeningRoom(Model theModel) {
		
		// get screening room list from db
		List<ScreeningRoom> theScreeningRooms = screeningRoomService.findAll();
		
		// add to the spring model
		theModel.addAttribute("screening_room", theScreeningRooms);
		
		return "screening_rooms/list-screening_rooms";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		ScreeningRoom theScreeningRoom = new ScreeningRoom();
		
		theModel.addAttribute("screening_room", theScreeningRoom);
		
		return "screening_rooms/screening_room-form";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("screeningRoomId") int theId,
									Model theModel) {
		
		// get the screening room from the service
		ScreeningRoom theScreeningRoom = screeningRoomService.findById(theId);
		
		// set screening room as a model attribute to pre-populate the form
		theModel.addAttribute("screening_room", theScreeningRoom);
		
		// send over to our form
		return "screening_rooms/screening_room-form";			
	}
	
	@PostMapping("/save")
	public String saveScreeningRoom(@ModelAttribute("screening_room") ScreeningRoom theScreeningRoom) {
		
		// save new screening room
		screeningRoomService.save(theScreeningRoom);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/screening_rooms/list";
	}
	
	
	@GetMapping("/delete")
	public String delete(@RequestParam("screeningRoomId") int theId) {
		
		// delete the screening room
		screeningRoomService.deleteById(theId);
		
		// redirect to /screening_room/list
		return "redirect:/screening_room/list";
		
	}
}
