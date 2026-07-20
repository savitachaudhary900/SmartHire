package com.smarthire.controller;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smarthire.entity.Candidate;
import com.smarthire.service.CandidateService;

@RestController
@RequestMapping("/api/candidates")
public class CandidateController {

	private final CandidateService candidateService;

	public CandidateController(CandidateService candidateService) {
		this.candidateService = candidateService;
	}

	@PostMapping
	public Candidate saveCandidate(@RequestBody Candidate candidate) {
		return candidateService.saveCandidate(candidate);
	}

	@GetMapping
	public List<Candidate> getAllCandidates() {
		return candidateService.getAllCandidates();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Candidate>> getCandidateById(@PathVariable Long id) {
		Optional<Candidate> candidate = candidateService.getCandidateById(id);

		return ResponseEntity.ok(candidate);
	}

}