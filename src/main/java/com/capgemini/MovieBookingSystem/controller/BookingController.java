package com.capgemini.MovieBookingSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.MovieBookingSystem.ResponseClasses.CustomBooking;
import com.capgemini.MovieBookingSystem.beans.ShortUser;
import com.capgemini.MovieBookingSystem.service.BookingService;

@RestController
@RequestMapping("/bookings")
//This method will return value only for a user
//Can have the functionality of having booking details for all the users in case of admin
public class BookingController {

	@Autowired
	private BookingService bookingService;

//	
//	private DynamoDBMapper dynamoDBMapper;
//  
//	@Autowired
//	private AmazonDynamoDB amazonDynamoDB;
//
//	@PostConstruct
//	public void setup() {
//		dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);
//      CreateTableRequest tableRequest = dynamoDBMapper.generateCreateTableRequest(Booking.class);
//      tableRequest.setProvisionedThroughput(new ProvisionedThroughput(1L, 1L)); 
//      amazonDynamoDB.createTable(tableRequest);
//	}
//	

	// For a Particular User
	@GetMapping
	public ResponseEntity<List<CustomBooking>> getAllBookings() {
		ShortUser user = new ShortUser("1","Shreesh");
		return new ResponseEntity<List<CustomBooking>>(bookingService.findAllBookingsForUser(user), HttpStatus.OK);
	}

	@PostMapping // Add a verification layer to check if the user exists or not,
	// verify using Principal Spring Security
	public ResponseEntity<CustomBooking> addBooking(@RequestBody CustomBooking customBooking) {
		ShortUser user = new ShortUser("1","Shreesh");
		CustomBooking newCustomBooking = bookingService.addBooking(customBooking, user);
		//Make changes in the seatPlan that seats have been booked.
		//new RestTemplate().exchange(url, httpMethod, [data if present])
		return new ResponseEntity<CustomBooking>(newCustomBooking, HttpStatus.CREATED);
	}

	// For changing the status of booking, Canceling a booking
	// user can cancel a booking, or the theater can cancel the booking if some
	// problem arises
	@PutMapping
	public ResponseEntity<CustomBooking> updateBooking(@RequestBody CustomBooking customBooking) {
		ShortUser user = new ShortUser("1","Shreesh");
		return new ResponseEntity<CustomBooking>(bookingService.updateBooking(customBooking,user), HttpStatus.OK);
	}

// Can have admin use this method if we want the functionality
//	@GetMapping("/{userId}")
//	public ResponseEntity<List<Booking>> getAllBookingsForAUser(@PathVariable("userId") String id) {
//		return new ResponseEntity<List<Booking>>(bookingService.findAllForUserId(id), HttpStatus.OK);
//	}

}
