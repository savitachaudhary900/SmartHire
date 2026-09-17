package com.smarthire.service;

import java.util.List;

import com.smarthire.dto.JobRequest;
import com.smarthire.dto.JobResponse;

public interface JobService {

	JobResponse saveJob(JobRequest request);

	List<JobResponse> getAllJobs();

	JobResponse getJobById(Long id);

	JobResponse updateJob(Long id, JobRequest request);

	void deleteJob(Long id);
}
