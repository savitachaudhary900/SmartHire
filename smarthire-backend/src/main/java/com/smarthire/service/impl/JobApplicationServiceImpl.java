package com.smarthire.service.impl;

import org.springframework.stereotype.Service;

import com.smarthire.dto.JobApplicationRequest;
import com.smarthire.dto.JobApplicationResponse;
import com.smarthire.entity.JobApplication;
import com.smarthire.repository.JobApplicationRepository;
import com.smarthire.service.JobApplicationService;

@Service
public class JobApplicationServiceImpl implements JobApplicationService {

	private final JobApplicationRepository jobApplicationRepository;

	public JobApplicationServiceImpl(JobApplicationRepository jobApplicationRepository) {

		this.jobApplicationRepository = jobApplicationRepository;
	}

	@Override
	public JobApplicationResponse applyForJob(JobApplicationRequest request) {

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