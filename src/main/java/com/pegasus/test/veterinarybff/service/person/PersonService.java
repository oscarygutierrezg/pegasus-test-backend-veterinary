package com.pegasus.test.veterinarybff.service.person;

import java.util.UUID;

import com.pegasus.test.veterinarybff.dto.person.PersonDto;

public interface PersonService {
	PersonDto show(UUID uuid);
}
