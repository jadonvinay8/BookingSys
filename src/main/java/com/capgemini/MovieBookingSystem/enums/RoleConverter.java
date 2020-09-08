package com.capgemini.MovieBookingSystem.enums;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;

public class RoleConverter implements DynamoDBTypeConverter<String, Role> {

	@Override
	public String convert(Role object) {
		String result = new String();
	    if (object != null) {
	    	result= object.name();
	    }
	    return result;
	}

	@Override
	public Role unconvert(String object) {
		Role result = null;
	    if (object != null) {
	    	result = Role.valueOf(object);
	    }
	    return result;
	}

}