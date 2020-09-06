package com.capgemini.MovieBookingSystem.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.MovieBookingSystem.beans.ShortMovie;
import com.capgemini.MovieBookingSystem.dao.MovieDAO;
import com.capgemini.MovieBookingSystem.entities.Movie;
import com.capgemini.MovieBookingSystem.entities.Theater;
import com.capgemini.MovieBookingSystem.exception.ResourceNotFoundException;

/**
 * Service class having functionality to interact with Movies
 * 
 * @author Vinay Pratap Singh
 *
 */
@Service
public class MovieService {

	@Autowired
	private MovieDAO movieDAO;
	
	@Autowired
	private TheaterService theaterService;
	
	public Movie findById(String id) {
		return movieDAO.findById(id).orElseThrow(ResourceNotFoundException::new);
	}
	
	public Movie addMovie(String theaterId, Movie movie) {
		Movie savedMovie = movieDAO.save(movie);
		updateAttachedTheater(theaterId, savedMovie, true);
		return savedMovie;
	}
	
	public Movie removeMovie(String theaterId, String movieId) {
		Movie movie = findById(movieId);
		updateAttachedTheater(theaterId, movie, false);
		movieDAO.delete(movie);
		return movie;
	}
	
	private void updateAttachedTheater(String theaterId, Movie movie, boolean add) {
		Theater theater = theaterService.findTheaterById(theaterId);
		List<ShortMovie> movies = theater.getMovies();
		
		if (add) {
			movies.add(new ShortMovie(movie.getMovieId(), movie.getName()));
		} else {
			movies = movies.stream().filter(shortMovie -> !shortMovie.getId().equals(movie.getMovieId()))
									.collect(Collectors.toList());
		}
		theater.setMovies(movies);
		theaterService.updateTheater(theater);
	}
	
//	public Movie updateMovie(Movie movie) {
//		String theaterId = 
//	}
	
}
