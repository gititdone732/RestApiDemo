package com.example.demo.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
 * @author Venkatesh
 *
 */
public class CustomExceptionRespose {
	
	public String message;
	
	/**
	 * @param message
	 */
	public CustomExceptionRespose(String message) {
		super();
		this.message=message;
	}

}
