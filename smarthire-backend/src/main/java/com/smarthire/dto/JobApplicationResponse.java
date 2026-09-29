package com.smarthire.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobApplicationResponse {

	private Long id;
	private Long candidateId;
	private Long jobId;
	private String status;
	private LocalDateTime appliedAt;

}
