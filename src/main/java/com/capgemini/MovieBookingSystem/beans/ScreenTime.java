package com.capgemini.MovieBookingSystem.beans;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.capgemini.MovieBookingSystem.entities.Movie;
import com.capgemini.MovieBookingSystem.entities.SeatPlan;
@DynamoDBDocument
public class ScreenTime {
	private String timeOfShow;
	private Movie movie;
	private SeatPlan seatPlan;
	
	public ScreenTime() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ScreenTime(String timeOfShow, Movie movie, SeatPlan seatPlan) {
		super();
		this.timeOfShow = timeOfShow;
		this.movie = movie;
		this.seatPlan = seatPlan;
	}

	@DynamoDBAttribute
	public String getTimeOfShow() {
		return timeOfShow;
	}

	public void setTimeOfShow(String timeOfShow) {
		this.timeOfShow = timeOfShow;
	}
	@DynamoDBAttribute
	public SeatPlan getSeatPlan() {
		return seatPlan;
	}

	public void setSeatPlan(SeatPlan seatPlan) {
		this.seatPlan = seatPlan;
	}
	@DynamoDBAttribute
	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}
}
