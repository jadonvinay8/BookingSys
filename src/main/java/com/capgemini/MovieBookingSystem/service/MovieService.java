package com.capgemini.MovieBookingSystem.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.MovieBookingSystem.beans.ShortMovie;
import com.capgemini.MovieBookingSystem.beans.ShortTheater;
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

	private final boolean ADD_MOVIE = true;
	private final boolean REMOVE_MOVIE = false;

	@Autowired
	private MovieDAO movieDAO;

	@Autowired
	private TheaterService theaterService;

	public Movie findById(String id) {
		return movieDAO.findById(id).orElseThrow(ResourceNotFoundException::new);
	}

	public List<Movie> findAll() {
		return StreamSupport.stream(movieDAO.findAll().spliterator(), false).collect(Collectors.toList());
	}

	public Movie addMovie(Movie movie) {
		Movie savedMovie = movieDAO.save(movie);
		if (!movie.getTheatres().isEmpty()) {
			movie.getTheatres().stream()
					.forEach(theater -> updateAttachedTheater(theater.getId(), savedMovie, ADD_MOVIE));
		}
		return savedMovie;
	}

	public Movie deleteMovie(String id) {
		Movie movie = findById(id);
		if (!movie.getTheatres().isEmpty()) {
			movie.getTheatres().stream()
					.forEach(theater -> updateAttachedTheater(theater.getId(), movie, REMOVE_MOVIE));
		}
		movieDAO.delete(movie);
		return movie;
	}

	public Movie attachMovieToATheater(String theaterId, String movieId) {
		Movie movie = findById(movieId);
		updateMovie(movie, theaterId, ADD_MOVIE);
		updateAttachedTheater(theaterId, movie, ADD_MOVIE);
		return movie;
	}

	public Movie removeMovieFromATheater(String theaterId, String movieId) {
		Movie movie = findById(movieId);
		updateMovie(movie, theaterId, REMOVE_MOVIE);
		updateAttachedTheater(theaterId, movie, REMOVE_MOVIE);
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

	private Movie updateMovie(Movie movie, String theaterId, boolean add) {
		movieDAO.delete(movie);
		Theater theater = theaterService.findTheaterById(theaterId);
		List<ShortTheater> theaters = movie.getTheatres();
		if (add) {
			theaters.add(new ShortTheater(theaterId, theater.getTheatreName()));
		} else {
			theaters = theaters.stream().filter(shortTheater -> !shortTheater.getId().equals(theaterId))
					.collect(Collectors.toList());
		}
		movie.setTheatres(theaters);
		return movieDAO.save(movie);
	}
	
	public Movie updateMovie(Movie movie) {
		movieDAO.delete(findById(movie.getMovieId()));
		return movieDAO.save(movie);
	}

}
