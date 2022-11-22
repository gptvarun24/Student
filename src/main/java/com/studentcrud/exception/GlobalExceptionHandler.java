package com.studentcrud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	public GlobalExceptionHandler() {
		
	}
@ExceptionHandler
public ResponseEntity<ErrorResponse> handleExc(Exception exc)
{
	ErrorResponse e = new ErrorResponse();
	e.setMsg("not found any studet");
	return new ResponseEntity<>(e,HttpStatus.NOT_FOUND);
}
}
