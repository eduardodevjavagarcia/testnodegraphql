package com.example.testnodegraphql.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import com.example.testnodegraphql.domain.Person;
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
		log.info("findAll");

		return Optional.ofNullable(this.personRepository.findAll()).filter(persons -> !ObjectUtils.isEmpty(persons))
				.map(ArrayList::new).orElseThrow(() -> new PersonNotFoundException("testando"));
	}

	public Person save(Person person) {
		log.info("save");
		person.setDateBirth(LocalDate.now());
		return this.personRepository.save(person);
	}

	public Person update(Long id) {
		log.info("update");
		Optional<Person> person = this.personRepository.findById(id);
		return this.personRepository.save(person.get());
	}

	public void remove(Long id) {
		log.info("remove");
		this.personRepository.delete(this.personRepository.findById(id).get());
	}

}
