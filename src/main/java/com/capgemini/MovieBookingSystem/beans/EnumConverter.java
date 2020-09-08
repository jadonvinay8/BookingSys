package com.capgemini.MovieBookingSystem.beans;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;
import com.capgemini.MovieBookingSystem.enums.SeatType;

public class EnumConverter implements DynamoDBTypeConverter<String, SeatType> {

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