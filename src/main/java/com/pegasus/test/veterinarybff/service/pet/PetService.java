package com.pegasus.test.veterinarybff.service.pet;

import java.util.List;
import java.util.UUID;

import com.pegasus.test.veterinarybff.dto.pet.PetDto;


public interface PetService {
	
	List<PetDto> findByPersonId(UUID personId);
}
