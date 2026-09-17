package com.smarthire.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "jobs")
@NoArgsConstructor
@AllArgsConstructor

public class Job {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(nullable = false, length = 150)
	private String title;

	@Column(length = 1000)
	private String description;

	@Column(nullable = false, length = 150)
	private String companyName;

	@Column(nullable = false, length = 100)
	private String location;

	@Column(nullable = false)
	private Double salary;

	@Column(nullable = false)
	private Integer experienceRequired;

	@Column(nullable = false, length = 500)
	private String skills;

	@Column(nullable = false, updatable = false)
	private LocalDateTime createdAt;

	@PrePersist
	public void setCreatedAt() {
		createdAt = LocalDateTime.now();
	}

}
