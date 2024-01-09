package com.live.todo.todo.entites;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.live.todo.todo.exceptions.NoDataFoundException;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {
	
	// une méthode par exception
	@ExceptionHandler(NoDataFoundException.class)
	public ResponseEntity<Object> handleNoDataFoundException(NoDataFoundException exception, WebRequest request){
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}

}
