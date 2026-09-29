package com.smarthire.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smarthire.dto.JobApplicationRequest;
import com.smarthire.dto.JobApplicationResponse;
import com.smarthire.service.JobApplicationService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/applications")
public class JobApplicationController {

	private final JobApplicationService jobApplicationService;

	public JobApplicationController(JobApplicationService jobApplicationService) {

		this.jobApplicationService = jobApplicationService;
	}

	@PostMapping
	public ResponseEntity<JobApplicationResponse> applyForJob(@Valid @RequestBody JobApplicationRequest request) {

		JobApplicationResponse response = jobApplicationService.applyForJob(request);

		return ResponseEntity.created(URI.create("/api/applications/" + response.getId())).body(response);
	}
}