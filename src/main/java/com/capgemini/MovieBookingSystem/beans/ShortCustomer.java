package com.capgemini.MovieBookingSystem.beans;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

@DynamoDBDocument
public class ShortCustomer {

	private String id;
	private String name;
	
	public ShortCustomer() {
		// TODO Auto-generated constructor stub
	}
	
	public ShortCustomer(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public ShortCustomer(String name) {
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
