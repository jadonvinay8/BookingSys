package com.capgemini.MovieBookingSystem.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.MovieBookingSystem.ResponseClasses.CustomBooking;
import com.capgemini.MovieBookingSystem.beans.ShortUser;
import com.capgemini.MovieBookingSystem.dao.BookingDao;
import com.capgemini.MovieBookingSystem.entities.Booking;
import com.capgemini.MovieBookingSystem.enums.BookingStatus;
import com.capgemini.MovieBookingSystem.exception.BookingNotFoundException;

@Service
public class BookingService {

	@Autowired
	private BookingDao bookingDao;

	private Booking converCustomBookingToBooking(CustomBooking customBooking, ShortUser user) {
		return new Booking(customBooking.getBookingId(), user, customBooking.getTheaterDetails(),
				customBooking.getDateOfShow(), customBooking.getShowTiming(), customBooking.getScreenName(),
				customBooking.getMovieName(), customBooking.getAmount(), customBooking.getBookedSeats(),
				customBooking.getTransactionId(), customBooking.getSeatPlanId(), customBooking.getBookingStatus());
	}

	private CustomBooking converBookingToCustomBooking(Booking booking) {
		return new CustomBooking(booking.getBookingId(), booking.getTheaterDetails(), booking.getDateOfShow(),
				booking.getShowTiming(), booking.getScreenName(), booking.getMovieName(), booking.getAmount(),
				booking.getBookedSeats(), booking.getTransactionId(), booking.getSeatPlanId(),
				booking.getBookingStatus());
	}

	public CustomBooking addBooking(CustomBooking customBooking, ShortUser user) {
		Booking booking = converCustomBookingToBooking(customBooking, user);
		booking = bookingDao.save(booking);
		customBooking.setBookingId(booking.getBookingId());
		return customBooking;
	}

	public Booking findById(String id) {
		return bookingDao.findById(id).orElseThrow(BookingNotFoundException::new);
	}

	public List<CustomBooking> findAllBookingsForUser(ShortUser user) {
		return StreamSupport.stream(bookingDao.findByUser(user).spliterator(), false)
				.map(booking -> converBookingToCustomBooking(booking)).collect(Collectors.toList());
	}

	public CustomBooking updateBooking(CustomBooking customBooking, ShortUser user) {
		BookingStatus newBookingStatus = customBooking.getBookingStatus();
		// update can only be done for cancellation
		if (newBookingStatus.equals(BookingStatus.BOOKED)) {
			// throw BAD Request
		}
		// if this booking didn't exist previously, an exception
		// will be thrown
		Booking oldBooking = findById(customBooking.getBookingId());
		oldBooking.setBookingStatus(newBookingStatus);
		// Saving the old booking object as we can't have any changes in the booking
		// other than canceling it
		bookingDao.save(oldBooking);
		return converBookingToCustomBooking(oldBooking);
	}
}
