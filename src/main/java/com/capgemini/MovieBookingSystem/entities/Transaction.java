package com.capgemini.MovieBookingSystem.entities;

import java.time.LocalDateTime;

import com.capgemini.MovieBookingSystem.beans.CardDetails;

public class Transaction {
	String transactionId;
	LocalDateTime transactionDate;
	double amount;
	Booking bookingReference;
	CardDetails paymentDetails;
}
