package com.pegasus.test.veterinarybff.service.veterinary;

import java.util.UUID;

import com.pegasus.test.veterinarybff.dto.person.PersonDto;


public interface VeterinaryService {
	
	PersonDto findPersonById(UUID uuid);
}
