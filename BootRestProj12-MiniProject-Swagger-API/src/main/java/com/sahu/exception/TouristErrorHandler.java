package com.sahu.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//@ControllerAdvice
@RestControllerAdvice
public class TouristErrorHandler {
	
	//@ExceptionHandler(Exception.class)
	@ExceptionHandler(TouristNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleTouristNotFound(TouristNotFoundException notFoundException){
		System.out.println("TouristErrorHandler.handleTouristNotFound()");
		ErrorDetails details = new ErrorDetails(LocalDateTime.now(), notFoundException.getMessage(), "404-Tourist not found");
		return new ResponseEntity<ErrorDetails>(details, HttpStatus.NOT_FOUND);
	} 

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handleAllProblems(Exception e){
		System.out.println("TouristErrorHandler.handleAllProblems()");
		ErrorDetails details = new ErrorDetails(LocalDateTime.now(), e.getMessage(), "Problem in execution");
		return new ResponseEntity<ErrorDetails>(details, HttpStatus.INTERNAL_SERVER_ERROR);
	} 
	
}
