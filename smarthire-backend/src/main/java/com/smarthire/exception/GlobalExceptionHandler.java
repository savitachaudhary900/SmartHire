package com.smarthire.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(CandidateNotFoundException.class)
	public ResponseEntity<String> handleCandidateNotFound
	(CandidateNotFoundException exception) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(exception.getMessage());

	}
}
