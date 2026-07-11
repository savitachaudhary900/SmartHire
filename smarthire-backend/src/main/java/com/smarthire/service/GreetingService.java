package com.smarthire.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {

	public String getMessage() {
		return "welcome to SmartHire API";
	}
}
