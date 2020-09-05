package com.capgemini.MovieBookingSystem.entities;

import java.util.Date;
import java.util.List;

public class Movie {
	
	private	Integer movieId;
	private	String name;
	private	String genre;
	private	String duration;
	private	String movieDimension;
	private	Date dateReleased;
	private	List<String> casts;
	private	List<Theater> theatres;
	private	List<String> languages;
	
	public Movie() {
		// TODO Auto-generated constructor stub
	}

	public Movie(String name, String genre, String duration, String movieDimension, Date dateReleased,
			List<String> casts, List<Theater> theatres, List<String> languages) {
		super();
		this.name = name;
		this.genre = genre;
		this.duration = duration;
		this.movieDimension = movieDimension;
		this.dateReleased = dateReleased;
		this.casts = casts;
		this.theatres = theatres;
		this.languages = languages;
	}

	public Integer getMovieId() {
		return movieId;
	}

	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getMovieDimension() {
		return movieDimension;
	}

	public void setMovieDimension(String movieDimension) {
		this.movieDimension = movieDimension;
	}

	public Date getDateReleased() {
		return dateReleased;
	}

	public void setDateReleased(Date dateReleased) {
		this.dateReleased = dateReleased;
	}

	public List<String> getCasts() {
		return casts;
	}

	public void setCasts(List<String> casts) {
		this.casts = casts;
	}

	public List<Theater> getTheatres() {
		return theatres;
	}

	public void setTheatres(List<Theater> theatres) {
		this.theatres = theatres;
	}

	public List<String> getLanguages() {
		return languages;
	}

	public void setLanguages(List<String> languages) {
		this.languages = languages;
	}
	
	
}
