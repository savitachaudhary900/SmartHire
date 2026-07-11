package com.smarthire.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smarthire.service.GreetingService;

@RestController
public class TestController {
	private GreetingService greetingService;

	public TestController(GreetingService greetingService) {
		this.greetingService = greetingService;
	}

	@GetMapping("/api/test")
	public String test() {
		return "welcome to SmartHire API";
	}

}
