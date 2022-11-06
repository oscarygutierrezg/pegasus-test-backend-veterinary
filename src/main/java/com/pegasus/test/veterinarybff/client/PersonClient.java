package com.pegasus.test.veterinarybff.client;

import java.util.UUID;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.pegasus.test.veterinarybff.config.FeignConfig;
import com.pegasus.test.veterinarybff.config.PersonClientConfiguration;
import com.pegasus.test.veterinarybff.dto.person.PersonDto;


@FeignClient(name = "personClient", url = "${app.ms.person.url}", configuration = {FeignConfig.class, PersonClientConfiguration.class})
public interface PersonClient {
	
	@GetMapping(
			value = "/v1/person/{uuid}",
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	public  PersonDto showPerson(
			@PathVariable(value = "uuid") UUID uuid);
	
	

}
