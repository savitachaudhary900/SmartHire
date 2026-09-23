package com.smarthire.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.smarthire.dto.RecruiterRequest;
import com.smarthire.dto.RecruiterResponse;
import com.smarthire.entity.Recruiter;
import com.smarthire.exception.RecruiterNotFoundException;
import com.smarthire.repository.RecruiterRepository;
import com.smarthire.service.RecruiterService;

@Service
public class RecruiterServiceImpl implements RecruiterService {

	private final RecruiterRepository recruiterRepository;

	public RecruiterServiceImpl(RecruiterRepository recruiterRepository) {
		this.recruiterRepository = recruiterRepository;
	}

	public RecruiterResponse saveRecruiter(RecruiterRequest request) {

		Recruiter recruiter = new Recruiter();

		mapRequestToEntity(request, recruiter);

		Recruiter savedRecruiter = recruiterRepository.save(recruiter);

		return mapToResponse(savedRecruiter);
	}

	public List<RecruiterResponse> getAllRecruiters() {

		return recruiterRepository.findAll().stream().map(this::mapToResponse).toList();
	}

	public RecruiterResponse getRecruiterById(Long id) {

		Recruiter recruiter = recruiterRepository.findById(id)
				.orElseThrow(() -> new RecruiterNotFoundException("Recruiter not found with id: " + id));

		return mapToResponse(recruiter);
	}

	public RecruiterResponse updateRecruiter(Long id, RecruiterRequest request) {

		Recruiter existingRecruiter = recruiterRepository.findById(id)
				.orElseThrow(() -> new RecruiterNotFoundException("Recruiter not found with id: " + id));

		mapRequestToEntity(request, existingRecruiter);

		Recruiter updatedRecruiter = recruiterRepository.save(existingRecruiter);

		return mapToResponse(updatedRecruiter);
	}

	public void deleteRecruiter(Long id) {

		Recruiter existingRecruiter = recruiterRepository.findById(id)
				.orElseThrow(() -> new RecruiterNotFoundException("Recruiter not found with id: " + id));

		recruiterRepository.delete(existingRecruiter);
	}

	private void mapRequestToEntity(RecruiterRequest request, Recruiter recruiter) {

		recruiter.setFullName(request.getFullName());
		recruiter.setEmail(request.getEmail());
		recruiter.setPhone(request.getPhone());
		recruiter.setCompanyName(request.getCompanyName());
		recruiter.setDesignation(request.getDesignation());
		recruiter.setLocation(request.getLocation());
	}

	private RecruiterResponse mapToResponse(Recruiter recruiter) {

		RecruiterResponse response = new RecruiterResponse();

		response.setId(recruiter.getId());
		response.setFullName(recruiter.getFullName());
		response.setEmail(recruiter.getEmail());
		response.setPhone(recruiter.getPhone());
		response.setCompanyName(recruiter.getCompanyName());
		response.setDesignation(recruiter.getDesignation());
		response.setLocation(recruiter.getLocation());
		response.setCreatedAt(recruiter.getCreatedAt());

		return response;
	}
}