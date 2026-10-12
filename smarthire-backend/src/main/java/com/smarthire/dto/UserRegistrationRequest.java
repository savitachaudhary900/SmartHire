package com.smarthire.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRegistrationRequest {

	@NotBlank(message = "Email is required")
	@Email(message = "Please enter a valid email")
	private String email;

	@NotBlank(message = "Password is required")
	@Size(min = 6, max = 100, message = "Password must be between 6 and 100 characters")
	private String password;

	@NotBlank(message = "Role is required")
	@Pattern(regexp = "CANDIDATE|RECRUITER|ADMIN", message = "Role must be CANDIDATE, RECRUITER, or ADMIN")
	private String role;
}