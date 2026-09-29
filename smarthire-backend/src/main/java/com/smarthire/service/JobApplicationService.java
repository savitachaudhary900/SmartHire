package com.smarthire.service;

import com.smarthire.dto.JobApplicationRequest;
import com.smarthire.dto.JobApplicationResponse;

public interface JobApplicationService {
	JobApplicationResponse applyForJob(JobApplicationRequest request);

}
