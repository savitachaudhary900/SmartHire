package com.smarthire.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobApplicationStatusRequest {
	@NotBlank(message = "Status is required")
	@Pattern(regexp = "APPLIED|SHORTLISTED|REJECTED|HIRED",
	message = "Invalid status. Allowed values: APPLIED, SHORTLISTED, REJECTED, HIRED")
	private String status;

}
