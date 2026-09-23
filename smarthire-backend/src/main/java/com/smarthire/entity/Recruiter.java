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
@Table(name = "Recruiters")

@NoArgsConstructor
@AllArgsConstructor
public class Recruiter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(nullable = false, length = 100)
	private String fullName;
	@Column(nullable = false, unique = true, length = 150)
	private String email;

	@Column(nullable = false, length = 15)
	private String phone;

	@Column(nullable = false, length = 150)
	private String companyName;

	@Column(length = 100)
	private String designation;

	@Column(length = 100)
	private String location;

	@Column(nullable = false, updatable = false)
	private LocalDateTime createdAt;

	@PrePersist
	public void setCreatedAt() {
		createdAt = LocalDateTime.now();
	}
}
