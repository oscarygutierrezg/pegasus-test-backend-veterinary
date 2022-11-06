package com.pegasus.test.veterinarybff.handler;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pegasus.test.veterinarybff.dto.ApiResponseErrorDto;
import com.pegasus.test.veterinarybff.exception.VeterinaryException;

import feign.FeignException;

@ControllerAdvice
public class RestControllerExceptionHandler {
	
	@Autowired
	private ObjectMapper objectMapper;
	


	
	@ExceptionHandler(VeterinaryException.class)
	@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
	public ResponseEntity<ApiResponseErrorDto> handlePetException(VeterinaryException exception){
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
				.body(
						createApiResponseErrorDto(HttpStatus.UNPROCESSABLE_ENTITY, Arrays.asList(exception.getMessage()))
						);
		
	}


	@ExceptionHandler(FeignException.class)
	public ResponseEntity<Object> handleException(FeignException exception) throws JsonMappingException, JsonProcessingException{
		try {
			ApiResponseErrorDto responseErrorDto = objectMapper.readValue(exception.contentUTF8(), ApiResponseErrorDto.class);
			if(responseErrorDto.getErrors() != null)
				return ResponseEntity.status(HttpStatus.valueOf(exception.status()))
					.body(responseErrorDto);
			return ResponseEntity.status(HttpStatus.valueOf(exception.status()))
					.body(exception.contentUTF8());	
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.valueOf(exception.status()))
					.body(exception.contentUTF8());	
		}
	

	}

	private ApiResponseErrorDto createApiResponseErrorDto(HttpStatus httpStatus,List<String> errors) {
		return ApiResponseErrorDto.builder()
				.code(httpStatus.value())
				.message(httpStatus.getReasonPhrase())
				.errors(errors)
				.build();
	}
}
