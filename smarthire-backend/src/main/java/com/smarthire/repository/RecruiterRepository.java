package com.smarthire.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smarthire.entity.Recruiter;

public interface RecruiterRepository extends JpaRepository<Recruiter, Long> {

	List<Recruiter> findByCompanyNameContainingIgnoreCase(String companyName);
}
