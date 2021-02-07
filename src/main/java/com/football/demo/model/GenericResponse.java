package com.football.demo.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class GenericResponse<T> implements Serializable {

	private static final long serialVersionUID = 7026770663600153442L;

	private Integer httpStatusCode;
	private String message;
	private T data;
	private Integer appErrorCode;

	public GenericResponse() {
	}

	public GenericResponse(Integer httpStatusCode) {
		this.httpStatusCode = httpStatusCode;
	}

	public GenericResponse(Integer httpStatusCode, String message, T data) {
		this.httpStatusCode = httpStatusCode;
		this.message = message;
		this.data = data;
	}

	public GenericResponse(Integer httpStatusCode, String message, Integer appErrorCode) {
		this.httpStatusCode = httpStatusCode;
		this.appErrorCode = appErrorCode;
		this.message = message;
	}

	public GenericResponse(Integer httpStatusCode, String message, T data, Integer appErrorCode) {
		this.httpStatusCode = httpStatusCode;
		this.appErrorCode = appErrorCode;
		this.message = message;
		this.data = data;
	}

}
