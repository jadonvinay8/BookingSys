package com.capgemini.MovieBookingSystem.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.MovieBookingSystem.beans.ShortMovie;
import com.capgemini.MovieBookingSystem.beans.ShortTheater;
import com.capgemini.MovieBookingSystem.dao.TheaterDAO;
import com.capgemini.MovieBookingSystem.entities.City;
import com.capgemini.MovieBookingSystem.entities.Theater;
import com.capgemini.MovieBookingSystem.exception.ResourceNotFoundException;

@Service
public class TheaterService {

	@Autowired
	private TheaterDAO theaterDAO;
	
	@Autowired
	private LocationService locationService;
	
	public List<ShortMovie> getMovies(String id) {
		Theater theater = theaterDAO.findById(id).orElseThrow(ResourceNotFoundException::new);
		return theater.getMovies();
	}
	
	public Theater addTheater(String cityId, Theater theater) {
		Theater savedTheater = theaterDAO.save(theater);
		updateAttachedCity(cityId, savedTheater, true);
		return savedTheater;
	}
	
	public Theater removeTheater(String cityId, String theaterId) {
		Theater theater = theaterDAO.findById(theaterId).orElseThrow(ResourceNotFoundException::new);
		updateAttachedCity(cityId, theater, false);
		return theater;
	}
	
	private void updateAttachedCity(String cityId, Theater theater, boolean add) {
		City city = locationService.findById(cityId);
		List<ShortTheater> theaters = city.getTheaters();
		
		if (add) {
			theaters.add(new ShortTheater(theater.getTheatreId(), theater.getTheatreName()));
		}
		else {
			theaters = theaters.stream().filter(theater1 -> !(theater1.getId().equals(theater.getTheatreId())))
										.collect(Collectors.toList());
		}
			
		city.setTheaters(theaters);
		locationService.updateCity(city);
	}
	
}
