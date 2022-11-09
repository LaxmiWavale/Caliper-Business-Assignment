package com.hydroponic.exception;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(NotFound.class)
	public ResponseEntity<String> myExpHandler(NotFound ie) {
		return new ResponseEntity<String>(ie.getMessage(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<ErrorDetails> mynotFoundHandler(NoHandlerFoundException nfe, WebRequest req) {
		ErrorDetails errDetais = new ErrorDetails(LocalDate.now(), nfe.getMessage(), req.getDescription(false));
		return new ResponseEntity<>(errDetais, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> myExpHandler(Exception ie) {
		System.out.println("inside myHandler method...");
		return new ResponseEntity<String>(ie.getMessage(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorDetails> mynotFoundHandler(MethodArgumentNotValidException nfe, WebRequest req) {
		ErrorDetails errDetais = new ErrorDetails(LocalDate.now(), nfe.getMessage(), req.getDescription(false));
		return new ResponseEntity<>(errDetais, HttpStatus.BAD_REQUEST);
	}

}
