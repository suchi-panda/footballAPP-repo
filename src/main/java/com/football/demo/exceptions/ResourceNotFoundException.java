package com.football.demo.exceptions;

import org.springframework.http.HttpStatus;

import lombok.Data;


@Data
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 7371378958415106390L;

	protected HttpStatus httpErrorCode;
	protected Integer appErrorCode;
	protected String message;

	public ResourceNotFoundException() {
	}

	public ResourceNotFoundException(HttpStatus httpErrorCode) {
		this.httpErrorCode = httpErrorCode;
	}

	public ResourceNotFoundException(HttpStatus httpErrorCode, Integer appErrorCode) {
		this.httpErrorCode = httpErrorCode;
		this.appErrorCode = appErrorCode;
	}

	public ResourceNotFoundException(HttpStatus httpErrorCode, Integer appErrorCode, String message) {
		super();
		this.httpErrorCode = httpErrorCode;
		this.appErrorCode = appErrorCode;
		this.message = message;
	}

}
