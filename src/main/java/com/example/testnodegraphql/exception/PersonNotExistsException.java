package com.example.testnodegraphql.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PersonNotExistsException extends RuntimeException {

	private static final long serialVersionUID = -1608740512400842790L;

	public PersonNotExistsException(String message) {
		super(message);
	}

}
