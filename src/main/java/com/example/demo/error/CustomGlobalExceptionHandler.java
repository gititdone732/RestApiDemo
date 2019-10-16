package com.example.demo.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(CustomException.class)
	public ResponseEntity<CustomExceptionRespose> handleCustomException(CustomException ex){
		
		CustomExceptionRespose response =
				new CustomExceptionRespose(ex.getMessage());
		
		return new ResponseEntity(response,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
