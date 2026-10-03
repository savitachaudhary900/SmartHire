package com.smarthire.exception;

public class JobApplicationNotFoundException extends RuntimeException {
	public JobApplicationNotFoundException(String message) {
		super(message);
	}
}
