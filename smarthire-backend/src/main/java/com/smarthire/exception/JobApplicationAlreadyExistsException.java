package com.smarthire.exception;

public class JobApplicationAlreadyExistsException extends RuntimeException {
	public JobApplicationAlreadyExistsException(String message) {
		super(message);
	}

}
