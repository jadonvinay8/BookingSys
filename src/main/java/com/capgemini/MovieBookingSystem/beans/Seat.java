package com.capgemini.MovieBookingSystem.beans;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverted;
import com.capgemini.MovieBookingSystem.enums.SeatType;
import com.capgemini.MovieBookingSystem.enums.SeatTypeConverter;

@DynamoDBDocument
public class Seat {
	private double price;
	private SeatType seatType;
//	private SeatState[][] seatState;

	@DynamoDBAttribute
	public double getPrice() {
		return price;
	}

	public Seat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Seat(double price, SeatType seatType) {
		super();
		this.price = price;
		this.seatType = seatType;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@DynamoDBTypeConverted(converter = SeatTypeConverter.class)
	public SeatType getSeatType() {
		return seatType;
	}

	public void setSeatType(SeatType seatType) {
		this.seatType = seatType;
	}
}
