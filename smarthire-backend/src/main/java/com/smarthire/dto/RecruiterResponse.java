package com.smarthire.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class RecruiterResponse {

	private Long id;
	private String fullName;
	private String email;
	private String phone;
	private String companyName;
	private String designation;
	private String location;
	private LocalDateTime createdAt;
}
