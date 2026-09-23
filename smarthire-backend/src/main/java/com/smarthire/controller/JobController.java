package com.smarthire.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smarthire.dto.JobRequest;
import com.smarthire.dto.JobResponse;
import com.smarthire.service.JobService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

@RestController
@RequestMapping("/api/jobs")
@Validated
public class JobController {

	private final JobService jobService;

	// @Autowired
	public JobController(JobService jobService) {
		this.jobService = jobService;
	}

	@PostMapping
	public ResponseEntity<JobResponse> saveJob(@Valid @RequestBody JobRequest request) {

		JobResponse response = jobService.saveJob(request);

		return ResponseEntity.created(URI.create("/api/jobs/" + response.getId())).body(response);
	}

	@GetMapping
	public List<JobResponse> getAllJobs() {

		return jobService.getAllJobs();
	}

	@GetMapping("/search")
	public List<JobResponse> searchJobsByTitle(
			@RequestParam @NotBlank(message = "Search title is required") String title) {
		return jobService.searchJobsByTitle(title);
	}

	@GetMapping("/search/location")
	public List<JobResponse> searchJobsByLocation(
			@RequestParam @NotBlank(message = "Search location is required") String location) {

		return jobService.searchJobsByLocation(location);
	}

	@GetMapping("/{id}")
	public ResponseEntity<JobResponse> getJobById(@PathVariable Long id) {

		JobResponse response = jobService.getJobById(id);

		return ResponseEntity.ok(response);
	}

	@PutMapping("/{id}")
	public ResponseEntity<JobResponse> updateJob(@PathVariable Long id, @Valid @RequestBody JobRequest request) {

		JobResponse response = jobService.updateJob(id, request);

		return ResponseEntity.ok(response);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteJob(@PathVariable Long id) {

		jobService.deleteJob(id);

		return ResponseEntity.noContent().build();
	}
}
