package com.smarthire.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.smarthire.dto.CandidateRequest;
import com.smarthire.dto.CandidateResponse;
import com.smarthire.entity.Candidate;
import com.smarthire.exception.CandidateNotFoundException;
import com.smarthire.repository.CandidateRepository;

@Service
public class CandidateService {

	private final CandidateRepository candidateRepository;

	public CandidateService(CandidateRepository candidateRepository) {
		this.candidateRepository = candidateRepository;

	}

	public CandidateResponse getCandidateById(Long id) {

		Candidate candidate = candidateRepository.findById(id)
				.orElseThrow(() -> new CandidateNotFoundException("Candidate not found with id: " + id));

		return mapToResponse(candidate);
	}

	public CandidateResponse saveCandidate(CandidateRequest request) {

		Candidate candidate = new Candidate();
	
		mapRequestToEntity(request, candidate);
		
		Candidate savedCandidate = candidateRepository.save(candidate);

		return mapToResponse(savedCandidate);
	}

	public List<CandidateResponse> getAllCandidates() {

		return candidateRepository.findAll().stream().map(this::mapToResponse).toList();
	}

	public CandidateResponse updateCandidate(Long id, CandidateRequest request) {
		Candidate existingCandidate = candidateRepository.findById(id)
				.orElseThrow(() -> new CandidateNotFoundException("Candidate not found with id: " + id));

		mapRequestToEntity(request, existingCandidate);

		Candidate savedCandidate = candidateRepository.save(existingCandidate);

		return mapToResponse(savedCandidate);
	}

	public void deleteCandidate(Long id) {

		Candidate candidate = candidateRepository.findById(id)
				.orElseThrow(() -> new CandidateNotFoundException("Candidate not found with id: " + id));

		candidateRepository.delete(candidate);
	}

	private CandidateResponse mapToResponse(Candidate candidate) {

		CandidateResponse response = new CandidateResponse();

		response.setId(candidate.getId());
		response.setFullName(candidate.getFullName());
		response.setEmail(candidate.getEmail());
		response.setPhone(candidate.getPhone());
		response.setSkills(candidate.getSkills());
		response.setExperience(candidate.getExperience());
		response.setLocation(candidate.getLocation());

		return response;

	}

	private void mapRequestToEntity(CandidateRequest request, Candidate candidate) {
		candidate.setFullName(request.getFullName());
		candidate.setEmail(request.getEmail());
		candidate.setPhone(request.getPhone());
		candidate.setSkills(request.getSkills());
		candidate.setExperience(request.getExperience());
		candidate.setLocation(request.getLocation());
	}

}