package com.smarthire.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class CandidateRequest {

	@NotBlank(message = "Full name is required")
	private String fullName;

	@Email(message = "Please enter a valid email")
	@NotBlank(message = "Email is required")
	private String email;

	@NotBlank(message = "Phone is required")
	private String phone;

	@NotBlank(message = "Skills are required")
	private String skills;

	@Min(value = 0, message = "Experience cannot be negative")
	private Integer experience;

	@NotBlank(message = "Location is required")
	private String location;

	public CandidateRequest() {
		super();
	}

	public CandidateRequest(String fullName, String email, String phone, String skills, Integer experience,
			String location) {
		super();
		this.fullName = fullName;
		this.email = email;
		this.phone = phone;
		this.skills = skills;
		this.experience = experience;
		this.location = location;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public Integer getExperience() {
		return experience;
	}

	public void setExperience(Integer experience) {
		this.experience = experience;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "CandidateRequest [fullName=" + fullName + ", email=" + email + ", phone=" + phone + ", skills=" + skills
				+ ", experience=" + experience + ", location=" + location + "]";
	}

}
