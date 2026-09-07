package com.smarthire.controller;

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

import com.smarthire.config.AppConfig;
import com.smarthire.config.AppProperties;
import com.smarthire.dto.CandidateRequest;
import com.smarthire.dto.CandidateResponse;
import com.smarthire.entity.Candidate;
import com.smarthire.service.CandidateService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/candidates")
public class CandidateController {

	private final CandidateService candidateService;
	private final AppConfig appConfig;
	private final AppProperties appProperties;

	public CandidateController(CandidateService candidateService, AppConfig appConfig, AppProperties appProperties) {
		this.candidateService = candidateService;
		this.appConfig = appConfig;
		this.appProperties = appProperties;
	}

	@PostMapping
	public CandidateResponse saveCandidate(
	        @Valid @RequestBody CandidateRequest request) {

	    return candidateService.saveCandidate(request);
	}

//	@GetMapping("/config")
//	public String getConfig() {
//		return appProperties.getAppName() + " | Max Candidates: " + appProperties.getMaxCandidates() + " | Max Jobs: "
//				+ appProperties.getMaxJobs();
//	}

	@GetMapping
	public List<CandidateResponse> getAllCandidates() {
		return candidateService.getAllCandidates();
	}

//	@GetMapping("/app-name")
//	public String getAppName() {
//		return appConfig.getAppName();
//
//	}

	@GetMapping("/{id}")
	
	public ResponseEntity<CandidateResponse> getCandidateById(@PathVariable Long id) {

	    CandidateResponse response = candidateService.getCandidateById(id);

	    return ResponseEntity.ok(response);
	}

	@PutMapping("/{id}")
	public ResponseEntity<CandidateResponse> updateCandidate(
	        @PathVariable Long id,
	        @Valid @RequestBody CandidateRequest request) {

	    CandidateResponse response = candidateService.updateCandidate(id, request);

	    return ResponseEntity.ok(response);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCandidate(@PathVariable Long id) {

		candidateService.deleteCandidate(id);

		return ResponseEntity.noContent().build();
	}

}
