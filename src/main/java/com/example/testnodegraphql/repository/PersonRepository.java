package com.example.testnodegraphql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.testnodegraphql.domain.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
