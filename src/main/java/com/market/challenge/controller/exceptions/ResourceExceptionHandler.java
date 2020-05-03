package com.market.challenge.controller.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.market.challenge.services.exceptions.DatabaseException;
import com.market.challenge.services.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resouceNotFound(ResourceNotFoundException ex, 
			HttpServletRequest request){		
		
		var error = "Resource not found";
		var status = HttpStatus.NOT_FOUND;
		var path = request.getRequestURI();
		var err = new StandardError(Instant.now(), status.value(), error, ex.getMessage(), path);
		
		return ResponseEntity.status(status).body(err);	
	}
	
	@ExceptionHandler(DatabaseException.class)
	public ResponseEntity<StandardError> database(DatabaseException ex, 
			HttpServletRequest request) {		
		
		var error = "Database error";
		var status = HttpStatus.BAD_REQUEST;
		var path = request.getRequestURI();
		var err = new StandardError(Instant.now(), status.value(), error, ex.getMessage(), path);
		
		return ResponseEntity.status(status).body(err);	
	}
	
	
	
}
