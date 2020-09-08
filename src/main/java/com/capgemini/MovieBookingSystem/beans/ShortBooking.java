package com.capgemini.MovieBookingSystem.beans;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

@DynamoDBDocument
public class ShortBooking {

	private String id;
	private String name;
	
	public ShortBooking() {
		// TODO Auto-generated constructor stub
	}
	
	public ShortBooking(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public ShortBooking(String name) {
		super();
		this.name = name;
	}
	@DynamoDBAttribute
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	@DynamoDBAttribute
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
