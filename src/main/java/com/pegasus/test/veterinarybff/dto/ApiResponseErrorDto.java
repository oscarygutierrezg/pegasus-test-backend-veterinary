package com.pegasus.test.veterinarybff.dto;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ApiResponseErrorDto {
	
	private int code;
	private String message;
	private List<String> errors;

}

