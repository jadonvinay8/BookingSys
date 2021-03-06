package com.capgemini.MovieBookingSystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Custom Exception to throw in case no theater exist for given id
 * 
 * @author Vinay Pratap Singh
 *
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class TheaterNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public TheaterNotFoundException() {
		
	}

	public TheaterNotFoundException(String arg0) {
		super(arg0);
	}

}
