package com.football.demo.model;

import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.football.demo.exceptions.FootballBaseException;

@Component
@SuppressWarnings("unchecked")
public class ResponseParser<T> {

    private static ObjectMapper objectMapper = new ObjectMapper();


	public List<T> retrieveListOf(ResponseEntity<String> response, Class<?> type) {
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		if (null == response.getBody() || response.getBody().isEmpty()) {
			throw new FootballBaseException(HttpStatus.INTERNAL_SERVER_ERROR,
					"failed to retrieve response as body is empty");
		}
		try {
			return (List<T>) objectMapper.readValue(response.getBody(),
					TypeFactory.defaultInstance().constructCollectionType(List.class, Class.forName(type.getName())));
		} catch (IOException | ClassNotFoundException e) {
			throw new FootballBaseException(HttpStatus.INTERNAL_SERVER_ERROR, e);
		}
	}
}
