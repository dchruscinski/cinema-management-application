package com.chruscinskid.cinemamanagementapplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chruscinskid.cinemamanagementapplication.dao.ScreeningRoomRepository;
import com.chruscinskid.cinemamanagementapplication.entity.ScreeningRoom;

@Service
public class ScreeningRoomServiceImpl implements ScreeningRoomService {

	private ScreeningRoomRepository screeningRoomRepository;
	
	@Autowired
	public ScreeningRoomServiceImpl(ScreeningRoomRepository theScreeningRoomRepository) {
		screeningRoomRepository = theScreeningRoomRepository;
	}
	
	@Override
	public List<ScreeningRoom> findAll() {
		return screeningRoomRepository.findAll();
	}

	@Override
	public ScreeningRoom findById(int theId) {
		
		Optional <ScreeningRoom> result = screeningRoomRepository.findById(theId);
		
		ScreeningRoom theScreeningRoom = null;
		
		if (result.isPresent()) {
			theScreeningRoom = result.get();
		}
		else {
			throw new RuntimeException("Did not find screening room ID - " + theId);
		}
		
		return theScreeningRoom;
	}

	@Override
	public void save(ScreeningRoom theScreeningRoom) {
		screeningRoomRepository.save(theScreeningRoom);
	}

	@Override
	public void deleteById(int theId) {
		screeningRoomRepository.deleteById(theId);
	}

}
