package com.smarthire.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smarthire.entity.Job;

public interface JobRepository extends JpaRepository<Job,Long> {

}
