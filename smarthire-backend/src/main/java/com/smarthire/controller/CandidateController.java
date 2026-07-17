package com.smarthire.controller;

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
}