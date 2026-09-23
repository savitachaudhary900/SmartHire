package com.smarthire.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.smarthire.dto.JobRequest;
import com.smarthire.dto.JobResponse;
import com.smarthire.entity.Job;
import com.smarthire.exception.JobNotFoundException;
import com.smarthire.repository.JobRepository;
import com.smarthire.service.JobService;

@Service
public class JobServiceImpl implements JobService {

	private final JobRepository jobRepository;

	// @Autowired
	public JobServiceImpl(JobRepository jobRepository) {
		this.jobRepository = jobRepository;
	}

	@Override
	public JobResponse saveJob(JobRequest request) {

		Job job = new Job();
		mapRequestToEntity(request, job);

		Job savedJob = jobRepository.save(job);
		return mapToResponse(savedJob);
	}

	private void mapRequestToEntity(JobRequest request, Job job) {

		job.setTitle(request.getTitle());
		job.setDescription(request.getDescription());
		job.setCompanyName(request.getCompanyName());
		job.setLocation(request.getLocation());
		job.setSalary(request.getSalary());
		job.setExperienceRequired(request.getExperienceRequired());
		job.setSkills(request.getSkills());
	}

	private JobResponse mapToResponse(Job job) {

		JobResponse response = new JobResponse();

		response.setId(job.getId());
		response.setTitle(job.getTitle());
		response.setDescription(job.getDescription());
		response.setCompanyName(job.getCompanyName());
		response.setLocation(job.getLocation());
		response.setSalary(job.getSalary());
		response.setExperienceRequired(job.getExperienceRequired());
		response.setSkills(job.getSkills());
		response.setCreatedAt(job.getCreatedAt());

		return response;
	}

	@Override
	public List<JobResponse> getAllJobs() {
		return jobRepository.findAll().stream().map(this::mapToResponse).toList();
	}

	@Override
	public JobResponse getJobById(Long id) {
		Job job = jobRepository.findById(id)
				.orElseThrow(() -> new JobNotFoundException("Job not found with id: " + id));
		return mapToResponse(job);
	}

	@Override
	public List<JobResponse> searchJobsByTitle(String title) {
		return jobRepository.findByTitleContainingIgnoreCase(title).stream().map(this::mapToResponse).toList();
	}

	@Override
	public List<JobResponse> searchJobsByLocation(String location) {

		return jobRepository.findByLocationContainingIgnoreCase(location).stream().map(this::mapToResponse).toList();
	}

	@Override
	public JobResponse updateJob(Long id, JobRequest request) {
		Job existingJob = jobRepository.findById(id)
				.orElseThrow(() -> new JobNotFoundException("Job not found with id: " + id));

		mapRequestToEntity(request, existingJob);

		Job updatedJob = jobRepository.save(existingJob);

		return mapToResponse(updatedJob);
	}

	@Override
	public void deleteJob(Long id) {
		Job existingJob = jobRepository.findById(id)
				.orElseThrow(() -> new JobNotFoundException("Job not found with id: " + id));
		jobRepository.delete(existingJob);
	}

}