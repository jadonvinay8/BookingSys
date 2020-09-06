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

/** 
 * Service class to perform CRUD operations related to Theater functionality
 * 
 * @author Vinay Pratap Singh
 *
 */
@Service
public class TheaterService {

	@Autowired
	private TheaterDAO theaterDAO;
	
	@Autowired
	private LocationService locationService;
	
	
	public Theater findTheaterById(String id) {
		return theaterDAO.findById(id).orElseThrow(ResourceNotFoundException::new);
	}
	
	public List<ShortMovie> getMovies(String id) {
		return findTheaterById(id).getMovies();
	}
	
	public Theater addTheater(String cityId, Theater theater) {
		Theater savedTheater = theaterDAO.save(theater);
		updateAttachedCity(cityId, savedTheater, true);
		return savedTheater;
	}
	
	public Theater removeTheater(String cityId, String theaterId) {
		Theater theater = findTheaterById(theaterId);
		updateAttachedCity(cityId, theater, false);
		theaterDAO.delete(theater);
		return theater;
	}
	
	private void updateAttachedCity(String cityId, Theater theater, boolean add) {
		City city = locationService.findById(cityId);
		List<ShortTheater> theaters = city.getTheaters();
		
		if (add) {
			theaters.add(new ShortTheater(theater.getTheatreId(), theater.getTheatreName()));
		} else {
			theaters = theaters.stream().filter(shortTheater -> !shortTheater.getId().equals(theater.getTheatreId()))
										.collect(Collectors.toList());
		}	
		city.setTheaters(theaters);
		locationService.updateCity(city);
	}
	
	public Theater updateTheater(Theater theater) {
		String cityId = theater.getCity().getId();
		removeTheater(cityId, theater.getTheatreId());
		return addTheater(cityId, theater);
	}
	
}
