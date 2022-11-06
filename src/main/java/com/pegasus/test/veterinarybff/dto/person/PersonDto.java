package com.pegasus.test.veterinarybff.dto.person;

import java.util.List;
import java.util.UUID;

import com.pegasus.test.veterinarybff.dto.pet.PetDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonDto {
	
	private UUID id;
	private String name;
	private String lastName;
	private String docNumber;
	private String address;
	private String phone;
	private List<PetDto> pets;
}
