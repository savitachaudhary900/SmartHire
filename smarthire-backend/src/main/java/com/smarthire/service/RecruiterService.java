package com.smarthire.service;

import java.util.List;

import com.smarthire.dto.RecruiterRequest;
import com.smarthire.dto.RecruiterResponse;

public interface RecruiterService {
	RecruiterResponse saveRecruiter(RecruiterRequest request);

	List<RecruiterResponse> getAllRecruiters();

	RecruiterResponse getRecruiterById(Long id);

	RecruiterResponse updateRecruiter(Long id, RecruiterRequest request);

	List<RecruiterResponse> searchRecruitersByCompanyName(String companyName);

	void deleteRecruiter(Long id);
}
