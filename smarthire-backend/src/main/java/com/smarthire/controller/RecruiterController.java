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

import com.smarthire.dto.RecruiterRequest;
import com.smarthire.dto.RecruiterResponse;
import com.smarthire.service.RecruiterService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/recruiters")
public class RecruiterController {

	private final RecruiterService recruiterService;

	public RecruiterController(RecruiterService recruiterService) {
		this.recruiterService = recruiterService;
	}

	@PostMapping
	public ResponseEntity<RecruiterResponse> saveRecruiter(@Valid @RequestBody RecruiterRequest request) {

		RecruiterResponse response = recruiterService.saveRecruiter(request);

		return ResponseEntity.created(URI.create("/api/recruiters/" + response.getId())).body(response);
	}

	@GetMapping
	public List<RecruiterResponse> getAllRecruiters() {

		return recruiterService.getAllRecruiters();
	}

	@GetMapping("/{id}")
	public ResponseEntity<RecruiterResponse> getRecruiterById(@PathVariable Long id) {

		RecruiterResponse response = recruiterService.getRecruiterById(id);

		return ResponseEntity.ok(response);
	}

	@PutMapping("/{id}")
	public ResponseEntity<RecruiterResponse> updateRecruiter(@PathVariable Long id,
			@Valid @RequestBody RecruiterRequest request) {

		RecruiterResponse response = recruiterService.updateRecruiter(id, request);

		return ResponseEntity.ok(response);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteRecruiter(@PathVariable Long id) {

		recruiterService.deleteRecruiter(id);

		return ResponseEntity.noContent().build();
	}
}