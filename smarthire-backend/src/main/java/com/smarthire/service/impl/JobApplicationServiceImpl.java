package com.smarthire.service.impl;

import org.springframework.stereotype.Service;

import com.smarthire.dto.JobApplicationRequest;
import com.smarthire.dto.JobApplicationResponse;
import com.smarthire.entity.JobApplication;
import com.smarthire.exception.CandidateNotFoundException;
import com.smarthire.exception.JobApplicationAlreadyExistsException;
import com.smarthire.exception.JobNotFoundException;
import com.smarthire.repository.CandidateRepository;
import com.smarthire.repository.JobApplicationRepository;
import com.smarthire.repository.JobRepository;
import com.smarthire.service.JobApplicationService;

@Service
public class JobApplicationServiceImpl implements JobApplicationService {

	private final JobApplicationRepository jobApplicationRepository;
	private final CandidateRepository candidateRepository;
	private final JobRepository jobRepository;

	public JobApplicationServiceImpl(JobApplicationRepository jobApplicationRepository,
			CandidateRepository candidateRepository, JobRepository jobRepository) {

		this.jobApplicationRepository = jobApplicationRepository;
		this.candidateRepository = candidateRepository;
		this.jobRepository = jobRepository;
	}

	@Override
	public JobApplicationResponse applyForJob(JobApplicationRequest request) {

		candidateRepository.findById(request.getCandidateId()).orElseThrow(
				() -> new CandidateNotFoundException("Candidate not found with id: " + request.getCandidateId()));

		jobRepository.findById(request.getJobId())
				.orElseThrow(() -> new JobNotFoundException("Job not found with id: " + request.getJobId()));

		boolean alreadyApplied = jobApplicationRepository.existsByCandidateIdAndJobId(request.getCandidateId(),
				request.getJobId());

		if (alreadyApplied) {
			throw new JobApplicationAlreadyExistsException("Candidate has already applied for this job");
		}

		JobApplication application = new JobApplication();

		application.setCandidateId(request.getCandidateId());
		application.setJobId(request.getJobId());

		JobApplication savedApplication = jobApplicationRepository.save(application);

		return mapToResponse(savedApplication);
	}

	private JobApplicationResponse mapToResponse(JobApplication application) {

		JobApplicationResponse response = new JobApplicationResponse();

		response.setId(application.getId());
		response.setCandidateId(application.getCandidateId());
		response.setJobId(application.getJobId());
		response.setStatus(application.getStatus());
		response.setAppliedAt(application.getAppliedAt());

		return response;
	}
}