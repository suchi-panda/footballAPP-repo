package com.football.demo.model;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@SuppressWarnings({ "unchecked", "rawtypes" })
public class ResponseWrapper {

	private static final String DEFAULT = "Default";

	private ResponseWrapper() {
	}

	public static ResponseEntity<GenericResponse> constructResponse(Integer httpStatusCode, String message,
			Object responseData) {
		GenericResponse response = new GenericResponse(httpStatusCode, message, responseData);
		return new ResponseEntity<GenericResponse>(response, HttpStatus.valueOf(httpStatusCode));
	}
	
	public static ResponseEntity<GenericResponse> constructResponse(Integer httpStatusCode, String message,
			Object responseData, Integer appErrorCode) {
		GenericResponse response = new GenericResponse(httpStatusCode, message, responseData, appErrorCode);
		return new ResponseEntity<GenericResponse>(response, HttpStatus.valueOf(httpStatusCode));
	}

	public static ResponseEntity<GenericResponse> constructResponse(Integer httpStatusCode, Object responseData) {
		GenericResponse response = new GenericResponse(httpStatusCode, DEFAULT, responseData);
		return new ResponseEntity<GenericResponse>(response, HttpStatus.valueOf(httpStatusCode));

	}

	public static ResponseEntity<GenericResponse> constructResponse(Integer httpStatusCode, String message) {
		GenericResponse response = new GenericResponse(httpStatusCode, message, null);
		return new ResponseEntity<GenericResponse>(response, HttpStatus.valueOf(httpStatusCode));
	}

	public static ResponseEntity<GenericResponse> constructResponse(Integer httpStatusCode) {
		GenericResponse response = new GenericResponse(httpStatusCode, DEFAULT, null);
		return new ResponseEntity<GenericResponse>(response, HttpStatus.valueOf(httpStatusCode));
	}

	public static ResponseEntity<GenericResponse> constructResponse(Integer httpStatusCode, Integer appErrorCode,
			String message) {
		GenericResponse response = new GenericResponse(httpStatusCode, message, appErrorCode);
		return new ResponseEntity<GenericResponse>(response, HttpStatus.valueOf(httpStatusCode));
	}

}
