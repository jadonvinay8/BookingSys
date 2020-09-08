package com.capgemini.MovieBookingSystem.enums;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;

public class SeatTypeConverter implements DynamoDBTypeConverter<String, SeatType> {

	@Override
	public String convert(SeatType object) {
		String result = new String();
	    if (object != null) {
	    	result= object.name();
	    }
	    return result;
	}

	@Override
	public SeatType unconvert(String object) {
		SeatType result = null;
	    if (object != null) {
	    	result = SeatType.valueOf(object);
	    }
	    return result;
	}

}