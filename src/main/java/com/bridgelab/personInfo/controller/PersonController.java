package com.bridgelab.personInfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelab.personInfo.dto.PersonRegisterDTO;
import com.bridgelab.personInfo.entity.Person;
import com.bridgelab.personInfo.service.IpersonService;

@RestController
public class PersonController {
	@Autowired
	IpersonService personService;
	
	@GetMapping("/hello")
	public String getHelloWorld() {
		return "Hello World";
	}
	
	@PostMapping
	public ResponseEntity<String> regsiterPerson(@RequestBody PersonRegisterDTO personRegisterDTO){
		String response = personService.registerPerson(personRegisterDTO);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<List<Person>> editPerson(@RequestBody PersonRegisterDTO personRegisterDTO){
		List<Person> response = personService.editPerson(personRegisterDTO);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@DeleteMapping("/{email}")
	public ResponseEntity<List<Person>> editPerson(@PathVariable("email") String emailId){
		List<Person> response = personService.deletePerson(emailId);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping()
	public ResponseEntity<Person> getPerson(@RequestParam int id){
		Person response = personService.getPerson(id);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
