package com.example.testnodegraphql.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import com.example.testnodegraphql.domain.Person;
import com.example.testnodegraphql.exception.PersonExistsException;
import com.example.testnodegraphql.exception.PersonNotExistsException;
import com.example.testnodegraphql.exception.PersonNotFoundException;
import com.example.testnodegraphql.repository.PersonRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class PersonService {

	private PersonRepository personRepository;

	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	@Transactional(readOnly = true)
	public List<Person> findAll() {
		log.info("Find all persons");
		return this.personRepository.findAll();
	}

	public Person save(Person personRequest) {
		log.info("Save person");
		
		Optional.ofNullable(personRequest)
				.filter(personReq -> !ObjectUtils.isEmpty(personReq.getId()))
		        .flatMap(personReq -> this.personRepository.findById(personReq.getId()))
		        .ifPresent(personReq -> new PersonExistsException(personReq.getName() + " already exist in the system"));
		
		personRequest.setDateBirth(LocalDate.now());
		return this.personRepository.save(personRequest);
	}

	public Person updatePartial(Long id, Person personRequest) {
		log.info("update");
		
		return Optional.ofNullable(id)
                       .map(this.personRepository::findById)
                       .filter(Optional::isPresent)
                       .map(Optional::get)
                       .map(person -> this.personRepository.save(Person.valueOf(person, personRequest.getName(), personRequest.getAge())))
                       .orElseThrow(() -> new PersonNotExistsException("Person not exist in the system"));
	}

	public Person delete(Long id) {
		log.info("delete");
		return Optional.ofNullable(id)
				.map(this.personRepository::findById)
				.filter(Optional::isPresent)
                .map(Optional::get)
		        .map(this::delete)
		        .orElse(null);
	}
	
	public Person delete(Person person) {
		this.personRepository.delete(person);
		return person;
	}

	public Person findById(Long id) {
		return Optional.ofNullable(this.personRepository.findById(id))
				.filter(Optional::isPresent)
				.map(Optional::get)
				.orElseThrow(PersonNotFoundException::new);
	}
	
	public Person update(Long id, Person personRequest) {
		log.info("Save person");
		
		Optional.ofNullable(id)
				.flatMap(idPerson -> this.personRepository.findById(idPerson))
		        .ifPresent(personReq -> new PersonExistsException(personReq.getName() + " already exist in the system"));
		
		return this.personRepository.save(Person.valueOf(id, personRequest));
	}

}
