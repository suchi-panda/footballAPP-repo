package com.football.demo.exceptions;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class FootballBaseException extends RuntimeException {

	private static final long serialVersionUID = 7371339558415106390L;

	protected HttpStatus httpErrorCode;
	protected Integer appErrorCode;
	protected String message;

	public FootballBaseException() {
	}

	public FootballBaseException(HttpStatus httpErrorCode) {
		this.httpErrorCode = httpErrorCode;
	}

	public FootballBaseException(HttpStatus httpErrorCode, String message) {
		this.httpErrorCode = httpErrorCode;
		this.message = message;
	}

	public FootballBaseException(HttpStatus httpErrorCode, Integer appErrorCode, String message) {
		this.httpErrorCode = httpErrorCode;
		this.appErrorCode = appErrorCode;
		this.message = message;
	}

	public FootballBaseException(HttpStatus httpErrorCode, Throwable t) {
		super(t);
		this.httpErrorCode = httpErrorCode;
	}

	public FootballBaseException(HttpStatus httpErrorCode, String message, Throwable t) {
		super(t);
		this.httpErrorCode = httpErrorCode;
		this.message = message;
	}

	public FootballBaseException(HttpStatus httpErrorCode, Integer appErrorCode, String message, Throwable t) {
		super(t);
		this.httpErrorCode = httpErrorCode;
		this.appErrorCode = appErrorCode;
		this.message = message;
	}

}
