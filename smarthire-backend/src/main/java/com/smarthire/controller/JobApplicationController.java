package com.smarthire.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smarthire.dto.JobApplicationRequest;
import com.smarthire.dto.JobApplicationResponse;
import com.smarthire.dto.JobApplicationStatusRequest;
import com.smarthire.entity.JobApplication;
import com.smarthire.exception.JobApplicationNotFoundException;
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

	@GetMapping
	public List<JobApplicationResponse> getAllApplications() {
		return jobApplicationService.getAllApplications();
	}

	@GetMapping("/{id}")
	public ResponseEntity<JobApplicationResponse> getApplicationById(@PathVariable Long id) {

		JobApplicationResponse response = jobApplicationService.getApplicationById(id);

		return ResponseEntity.ok(response);
	}

	@PutMapping("/{id}/status")
	public ResponseEntity<JobApplicationResponse> updateApplicationStatus(@PathVariable Long id,
			@Valid @RequestBody JobApplicationStatusRequest request) {

		JobApplicationResponse response = jobApplicationService.updateApplicationStatus(id, request);

		return ResponseEntity.ok(response);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteApplication(@PathVariable Long id) {

		jobApplicationService.deleteApplication(id);

		return ResponseEntity.noContent().build();
	}
}