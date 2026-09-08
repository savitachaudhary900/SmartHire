package com.smarthire.exception;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(CandidateNotFoundException.class)
	public ResponseEntity<String> handleCandidateNotFound(CandidateNotFoundException exception) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());

	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleValidationException(MethodArgumentNotValidException exception) {

		Map<String, String> errors = new HashMap<>();

		exception.getBindingResult().getFieldErrors().forEach(error -> {
			errors.put(error.getField(), error.getDefaultMessage());
		});

		return ResponseEntity.badRequest().body(errors);
	}

		@ExceptionHandler(DataIntegrityViolationException.class)
		public ResponseEntity<String> handleDataIntegrityViolation(
		        DataIntegrityViolationException exception) {

		    Throwable cause = exception.getRootCause();

		    if (cause instanceof SQLException
		            && cause.getMessage().contains("Duplicate")) {

		        return ResponseEntity
		                .badRequest()
		                .body("Email already exists");
		    }

		    return ResponseEntity
		            .status(HttpStatus.INTERNAL_SERVER_ERROR)
		            .body("Database constraint violation");
		}
	}

