package com.smarthire.service;

import java.util.List;

import com.smarthire.dto.JobApplicationRequest;
import com.smarthire.dto.JobApplicationResponse;
import com.smarthire.dto.JobApplicationStatusRequest;

public interface JobApplicationService {
	JobApplicationResponse applyForJob(JobApplicationRequest request);

	List<JobApplicationResponse> getAllApplications();

	JobApplicationResponse getApplicationById(Long id);

	JobApplicationResponse updateApplicationStatus(Long id, JobApplicationStatusRequest request);

	void deleteApplication(Long id);
}
