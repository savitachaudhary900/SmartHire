package com.smarthire.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.smarthire.entity.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {

}
