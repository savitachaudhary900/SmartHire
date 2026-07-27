package com.smarthire.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.smarthire.entity.Candidate;
import com.smarthire.exception.CandidateNotFoundException;
import com.smarthire.repository.CandidateRepository;

@Service
public class CandidateService {

	private final CandidateRepository candidateRepository;

	public CandidateService(CandidateRepository candidateRepository) {
		this.candidateRepository = candidateRepository;

	}

	public Candidate saveCandidate(Candidate candidate) {
		return candidateRepository.save(candidate);

	}

	public List<Candidate> getAllCandidates() {
		return candidateRepository.findAll();

	}

	public Candidate getCandidateById(Long id) {
		return candidateRepository.findById(id)
				.orElseThrow(() -> new CandidateNotFoundException(
						"Candidate not found with id: " + id));
	}

}