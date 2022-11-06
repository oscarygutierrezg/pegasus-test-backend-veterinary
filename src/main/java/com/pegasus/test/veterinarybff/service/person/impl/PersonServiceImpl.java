package com.pegasus.test.veterinarybff.service.person.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pegasus.test.veterinarybff.client.PersonClient;
import com.pegasus.test.veterinarybff.service.person.PersonService;
import com.pegasus.test.veterinarybff.dto.person.PersonDto;

@Service
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	private PersonClient personClient;


	@Override
	public PersonDto show(UUID uuid) {
		return personClient.showPerson(uuid);
	}

}
