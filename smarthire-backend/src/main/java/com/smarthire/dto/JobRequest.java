package com.smarthire.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobRequest {
	
	@NotBlank(message = "job title is require")
	private String title;

	@NotBlank(message = "Job description is required")
	@Size(max = 1000, message = "Job description cannot exceed 1000 characters")
	private String description;

	@NotBlank(message = "Company name is required")
	@Size(max = 150, message = "Company name cannot exceed 150 characters")
	private String companyName;
	
	@NotBlank(message = "Location is required")
	@Size(max = 100, message = "Location cannot exceed 100 characters")
	private String location;
	
	@NotNull(message = "Salary is required")
	@Min(value = 0, message = "Salary cannot be negative")
	private Double salary;
	
	@NotNull(message = "Experience is required")
	@Min(value = 0, message = "Experience cannot be negative")
	private Integer experienceRequired;
	
	@NotBlank(message = "Skills are required")
	@Size(max = 500, message = "Skills cannot exceed 500 characters")
	private String skills;
	
	
	
	
	
	
	
	
}
