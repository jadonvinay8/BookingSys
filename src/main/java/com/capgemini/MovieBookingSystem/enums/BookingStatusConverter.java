package com.capgemini.MovieBookingSystem.enums;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;

public class BookingStatusConverter implements DynamoDBTypeConverter<String, BookingStatus> {

	@Override
	public String convert(BookingStatus object) {
		String result = new String();
	    if (object != null) {
	    	result= object.name();
	    }
	    return result;
	}

	@Override
	public BookingStatus unconvert(String object) {
		BookingStatus result = null;
	    if (object != null) {
	    	result = BookingStatus.valueOf(object);
	    }
	    return result;
	}

}