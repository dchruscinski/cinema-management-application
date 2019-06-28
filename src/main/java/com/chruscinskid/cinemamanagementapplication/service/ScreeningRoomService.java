package com.chruscinskid.cinemamanagementapplication.service;

import java.util.List;

import com.chruscinskid.cinemamanagementapplication.entity.ScreeningRoom;

public interface ScreeningRoomService {
	
	public List<ScreeningRoom> findAll();
	
	public ScreeningRoom findById(int theId);
	
	public void save(ScreeningRoom theScreeningRoom);
	
	public void deleteById(int theId);

}
