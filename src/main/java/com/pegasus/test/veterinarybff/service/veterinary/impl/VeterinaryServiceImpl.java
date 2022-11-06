package com.pegasus.test.veterinarybff.service.veterinary.impl;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.pegasus.test.veterinarybff.service.person.PersonService;
import com.pegasus.test.veterinarybff.service.pet.PetService;
import com.pegasus.test.veterinarybff.service.veterinary.VeterinaryService;
import com.pegasus.test.veterinarybff.dto.person.PersonDto;
import com.pegasus.test.veterinarybff.dto.pet.PetDto;
import com.pegasus.test.veterinarybff.exception.VeterinaryException;

@Service
public class VeterinaryServiceImpl implements VeterinaryService {

	@Autowired
	private PersonService personService;
	@Autowired
	private PetService petService;

	@Override
	public PersonDto findPersonById(UUID uuid) {
		PersonDto personDto = null;
		CompletableFuture<List<PetDto>> pets = getPets(uuid);
		CompletableFuture<PersonDto> person = getPerson(uuid);
		try {
			person.get().setPets(pets.get());
			personDto = person.get();
		} catch (InterruptedException e) {
			throw new VeterinaryException(e.getMessage(),e);
		} catch (ExecutionException e) {
			throw new VeterinaryException(e.getMessage(),e);
		}
		return personDto;
	}


	@Async
	private CompletableFuture<List<PetDto>> getPets(UUID uuid) {
		return CompletableFuture.completedFuture(petService.findByPersonId(uuid));
	}

	@Async
	private CompletableFuture<PersonDto> getPerson(UUID uuid) {
		return CompletableFuture.completedFuture(personService.show(uuid));
	}
}
