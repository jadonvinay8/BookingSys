package com.capgemini.MovieBookingSystem.ResponseClasses;

import java.util.List;

import com.capgemini.MovieBookingSystem.enums.BookingStatus;

public class CustomBooking {
	private String bookingId;
	private String theaterDetails;
	private String dateOfShow;
	private String showTiming;
	private String screenName;
	private String movieName;
	private double amount;
	private List<String> bookedSeats;
	private String transactionId;
	private String seatPlanId;
	private BookingStatus bookingStatus;

	public CustomBooking() {
		super();
	}

	public CustomBooking(String bookingId, String theaterDetails, String dateOfShow, String showTiming,
			String screenName, String movieName, double amount, List<String> bookedSeats, String transactionId,
			String seatPlanId, BookingStatus bookingStatus) {
		super();
		this.bookingId = bookingId;
		this.theaterDetails = theaterDetails;
		this.dateOfShow = dateOfShow;
		this.showTiming = showTiming;
		this.screenName = screenName;
		this.movieName = movieName;
		this.amount = amount;
		this.bookedSeats = bookedSeats;
		this.transactionId = transactionId;
		this.seatPlanId = seatPlanId;
		this.bookingStatus = bookingStatus;
	}

	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public String getTheaterDetails() {
		return theaterDetails;
	}

	public void setTheaterDetails(String theaterDetails) {
		this.theaterDetails = theaterDetails;
	}

	public String getDateOfShow() {
		return dateOfShow;
	}

	public void setDateOfShow(String dateOfShow) {
		this.dateOfShow = dateOfShow;
	}

	public String getShowTiming() {
		return showTiming;
	}

	public void setShowTiming(String showTiming) {
		this.showTiming = showTiming;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public List<String> getBookedSeats() {
		return bookedSeats;
	}

	public void setBookedSeats(List<String> bookedSeats) {
		this.bookedSeats = bookedSeats;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getSeatPlanId() {
		return seatPlanId;
	}

	public void setSeatPlanId(String seatPlanId) {
		this.seatPlanId = seatPlanId;
	}

	public BookingStatus getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(BookingStatus bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

}
