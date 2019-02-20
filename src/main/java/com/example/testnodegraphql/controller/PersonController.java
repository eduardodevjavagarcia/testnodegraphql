package com.example.testnodegraphql.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.testnodegraphql.domain.Person;
import com.example.testnodegraphql.service.PersonService;

@RestController
public class PersonController {

	private PersonService personService;

	public PersonController(PersonService personService) {
		this.personService = personService;
	}

	@GetMapping(path = "/persons")
	public ResponseEntity<List<Person>> findAll() {
		return ResponseEntity.ok(this.personService.findAll());
	}

	@GetMapping(path = "/persons/{id}")
	public ResponseEntity<Person> findById(@PathVariable Long id) {
		return new ResponseEntity<>(this.personService.findById(id), HttpStatus.OK);
	}

	@PostMapping(path = "/persons")
	public ResponseEntity<Person> create(@RequestBody Person person) {
		return new ResponseEntity<>(this.personService.save(person), HttpStatus.CREATED);
	}

	@PatchMapping(path = "/persons/{id}")
	public ResponseEntity<?> partialUpdate(@RequestBody Person person) {
		return new ResponseEntity<>(this.personService.save(person), HttpStatus.NO_CONTENT);
	}

	@PutMapping(path = "/persons/{id}")
	public ResponseEntity<Person> update(@PathVariable Long id) {
		return new ResponseEntity<>(this.personService.update(id), HttpStatus.OK);
	}

	@DeleteMapping(path = "/persons/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		this.personService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
