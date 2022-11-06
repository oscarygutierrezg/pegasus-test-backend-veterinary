package com.pegasus.test.veterinarybff.client;

import java.util.List;
import java.util.UUID;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.pegasus.test.veterinarybff.config.FeignConfig;
import com.pegasus.test.veterinarybff.config.PetClientConfiguration;
import com.pegasus.test.veterinarybff.dto.pet.PetDto;

@FeignClient(name = "petClient", url = "${app.ms.pet.url}",configuration = {FeignConfig.class, PetClientConfiguration.class})
public interface PetClient {
	
	@GetMapping(
			value = "/v1/pet/person/{personId}",
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	List<PetDto> findByPersonId(
			@PathVariable(value = "personId") UUID personId);

}
