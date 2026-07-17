package com.smarthire.service;

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

}