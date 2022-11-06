package com.pegasus.test.veterinarybff.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pegasus.test.veterinarybff.service.veterinary.VeterinaryService;
import com.pegasus.test.veterinarybff.dto.person.PersonDto;

import io.swagger.v3.oas.annotations.tags.Tag;


@Tag(name = "veterinary")
@RestController
@RequestMapping(value = "/v1/veterinary")
@CrossOrigin
@Validated
public class VeterinaryController {

	@Autowired
	private VeterinaryService veterinaryService;



	@GetMapping(
			value = "/person/{uuid}",
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	public  ResponseEntity<PersonDto>  showPet(
			@PathVariable(value = "uuid") UUID uuid) {
		return  ResponseEntity.ok().body(veterinaryService.findPersonById(uuid));
	}

	

}
