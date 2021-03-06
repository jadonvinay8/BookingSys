package com.capgemini.MovieBookingSystem.beans;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

@DynamoDBDocument
public class Address {
	
	private	String city;
	private	String state;
	private	String addressLine1;
	private	String pincode;
	
	public Address() {
		// TODO Auto-generated constructor stub
	}

	public Address(String city, String state, String addressLine1, String pincode) {
		super();
		this.city = city;
		this.state = state;
		this.addressLine1 = addressLine1;
		this.pincode = pincode;
	}
	@DynamoDBAttribute
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	@DynamoDBAttribute
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	@DynamoDBAttribute
	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	@DynamoDBAttribute
	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	
	
	
}
