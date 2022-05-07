package com.bridgelab.personInfo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelab.personInfo.dto.PersonRegisterDTO;
import com.bridgelab.personInfo.entity.Person;
@Service
public class PersonService implements IpersonService {
	List<Person> personDetails = new ArrayList<>();

	@Autowired
	ModelMapper modelMapper;
	@Override
	public String registerPerson(PersonRegisterDTO personRegisterDTO) {
		Person person = modelMapper.map(personRegisterDTO, Person.class);
		person.setRegisterDate(new Date());
		personDetails.add(person);
		return person.toString();
	}
	
	@Override
	public List<Person> editPerson(PersonRegisterDTO personRegisterDTO) {
		Optional<Person> person = personDetails.stream()
				.filter(personInfo -> personInfo.getEmailId().equals(personRegisterDTO.getEmailId()))
				.findFirst();
		
		if(person.isPresent()) {
			personDetails.remove(person.get());
			modelMapper.map(personRegisterDTO, person.get());
		}
		personDetails.add(person.get());
		return personDetails;
	}

	@Override
	public List<Person> deletePerson(String emailId) {
		Person person = personDetails.stream()
		.filter(personInfo -> personInfo.getEmailId().equals(emailId))
		.findFirst().get();
		personDetails.remove(person);
		return personDetails;
	}

	@Override
	public Person getPerson(int id) {
		Person person = personDetails.stream()
				.filter(personInfo -> personInfo.getId() == (id))
				.findFirst().get();
				personDetails.remove(person);
				return person;
	}

}
