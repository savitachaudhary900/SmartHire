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
public class RecruiterRequest {
	
	@NotBlank(message = "Full Name is required")
	@Size(max = 100,message = "full name cannot exceed 100 charactors" )
	private String fullName;
	
	  @NotBlank(message = "Email is required")
	    @Email(message = "Please enter a valid email")
	    @Size(max = 150, message = "Email cannot exceed 150 characters")
	    private String email;

	    @NotBlank(message = "Phone is required")
	    @Pattern(
	        regexp = "^[0-9]{10}$",
	        message = "Phone must contain exactly 10 digits"
	    )
	    private String phone;

	    @NotBlank(message = "Company name is required")
	    @Size(max = 150, message = "Company name cannot exceed 150 characters")
	    private String companyName;

	    @Size(max = 100, message = "Designation cannot exceed 100 characters")
	    private String designation;

	    @Size(max = 100, message = "Location cannot exceed 100 characters")
	    private String location;

}
