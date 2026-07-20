package com.smarthire.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.smarthire.entity.Candidate;
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

	public Optional<Candidate> getCandidateById(Long id) {
		return candidateRepository.findById(id);
	}

}