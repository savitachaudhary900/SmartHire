package com.smarthire.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smarthire.entity.JobApplication;

public interface JobApplicationRepository extends JpaRepository<JobApplication, Long> {

}