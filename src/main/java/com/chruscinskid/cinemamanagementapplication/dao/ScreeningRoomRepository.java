package com.chruscinskid.cinemamanagementapplication.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chruscinskid.cinemamanagementapplication.entity.ScreeningRoom;

public interface ScreeningRoomRepository extends JpaRepository<ScreeningRoom, Integer> {
	
	// sorting by screening room id ascending method
	public List<ScreeningRoom> findAllByOrderByIdAsc();

}
