package com.example.testnodegraphql.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class PersonExistsException extends RuntimeException {

	private static final long serialVersionUID = 5906991489000153045L;

	public PersonExistsException(String message) {
		super(message);
	}

}
