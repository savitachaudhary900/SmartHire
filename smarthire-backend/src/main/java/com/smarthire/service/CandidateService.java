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

	public Candidate getCandidateById(Long id) {
		return candidateRepository.findById(id)
				.orElseThrow(() -> new CandidateNotFoundException("Candidate not found with id: " + id));
	}

	public Candidate saveCandidate(Candidate candidate) {
		return candidateRepository.save(candidate);

	}

	public List<Candidate> getAllCandidates() {
		return candidateRepository.findAll();

	}

	public Candidate updateCandidate(Long id, Candidate updatedCandidate) {

		Candidate existingCandidate = candidateRepository.findById(id)
				.orElseThrow(() -> new CandidateNotFoundException("Candidate not found with id: " + id));

		existingCandidate.setFullName(updatedCandidate.getFullName());
		existingCandidate.setEmail(updatedCandidate.getEmail());
		existingCandidate.setPhone(updatedCandidate.getPhone());
		existingCandidate.setSkills(updatedCandidate.getSkills());
		existingCandidate.setExperience(updatedCandidate.getExperience());
		existingCandidate.setLocation(updatedCandidate.getLocation());

		return candidateRepository.save(existingCandidate);
	}

	public void deleteCandidate(Long id) {

		Candidate candidate = candidateRepository.findById(id)
				.orElseThrow(() -> new CandidateNotFoundException("Candidate not found with id: " + id));

		candidateRepository.delete(candidate);
	}

}