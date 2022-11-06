package com.pegasus.test.veterinarybff.service.pet.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pegasus.test.veterinarybff.client.PetClient;
import com.pegasus.test.veterinarybff.service.pet.PetService;
import com.pegasus.test.veterinarybff.dto.pet.PetDto;

@Service
public class PetServiceImpl implements PetService {
	
	@Autowired
	private PetClient petClient;

	@Override
	public List<PetDto> findByPersonId(UUID personId) {
		return petClient.findByPersonId(personId);
	}
}
