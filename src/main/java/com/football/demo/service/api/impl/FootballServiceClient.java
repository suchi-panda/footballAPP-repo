package com.football.demo.service.api.impl;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.football.demo.config.FootballAPIConfig;
import com.football.demo.model.Competition;
import com.football.demo.model.Country;
import com.football.demo.model.ResponseParser;
import com.football.demo.model.Standing;
import com.football.demo.model.Team;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class FootballServiceClient {

	@Autowired
	FootballAPIConfig footballAPIConfig;

	@Autowired
	RestTemplate restTemplate;

	public List<Country> getCountryList() throws URISyntaxException {

		URI baseURI = new URI(footballAPIConfig.getBaseUrl());
		ResponseEntity<String> result = restTemplate.getForEntity(baseURI, String.class);

		// Query parameters
		UriComponentsBuilder CountryBuilder = UriComponentsBuilder.fromUriString(footballAPIConfig.getBaseUrl())
				// Add query parameter
				.queryParam(footballAPIConfig.getAction(), footballAPIConfig.getCountryAction())
				.queryParam(footballAPIConfig.getApiKeyParam(), footballAPIConfig.getApiKeyValue());

		ResponseEntity<String> exchangeCountry = restTemplate.exchange(CountryBuilder.buildAndExpand().toUri(), HttpMethod.GET,
				result, String.class);

		return new ResponseParser<Country>().retrieveListOf(exchangeCountry, Country.class);

	}

	public List<Competition> getCompetitionList(String paramValue) throws URISyntaxException {

		URI baseURI = new URI(footballAPIConfig.getBaseUrl());
		ResponseEntity<String> result = restTemplate.getForEntity(baseURI, String.class);

		// Query parameters
		UriComponentsBuilder competitionBuilder = UriComponentsBuilder.fromUriString(footballAPIConfig.getBaseUrl())
				// Add query parameter
				.queryParam(footballAPIConfig.getAction(), footballAPIConfig.getCompetitionsAction())
				.queryParam(footballAPIConfig.getCompetitionsParam(), paramValue)
				.queryParam(footballAPIConfig.getApiKeyParam(), footballAPIConfig.getApiKeyValue());

		ResponseEntity<String> exchangeCompetition = restTemplate.exchange(competitionBuilder.buildAndExpand().toUri(), HttpMethod.GET,
				result, String.class);

		return new ResponseParser<Competition>().retrieveListOf(exchangeCompetition, Competition.class);

	}

	public List<Team> getTeamList(String paramValue) throws URISyntaxException {

		URI baseURI = new URI(footballAPIConfig.getBaseUrl());
		ResponseEntity<String> result = restTemplate.getForEntity(baseURI, String.class);

		// Query parameters
		UriComponentsBuilder competitionBuilder = UriComponentsBuilder.fromUriString(footballAPIConfig.getBaseUrl())
				// Add query parameter
				.queryParam(footballAPIConfig.getAction(), footballAPIConfig.getTeamAction())
				.queryParam(footballAPIConfig.getTeamParam(), paramValue)
				.queryParam(footballAPIConfig.getApiKeyParam(), footballAPIConfig.getApiKeyValue());

		ResponseEntity<String> exchangeCompetition = restTemplate.exchange(competitionBuilder.buildAndExpand().toUri(), HttpMethod.GET,
				result, String.class);

		return new ResponseParser<Team>().retrieveListOf(exchangeCompetition, Team.class);
	}

	public List<Standing> getStandingsList(String paramValue) throws URISyntaxException {

		URI baseURI = new URI(footballAPIConfig.getBaseUrl());
		ResponseEntity<String> result = restTemplate.getForEntity(baseURI, String.class);

		// Query parameters
		UriComponentsBuilder competitionBuilder = UriComponentsBuilder.fromUriString(footballAPIConfig.getBaseUrl())
				// Add query parameter
				.queryParam(footballAPIConfig.getAction(), footballAPIConfig.getStandingAction())
				.queryParam(footballAPIConfig.getStandingParam(), paramValue)
				.queryParam(footballAPIConfig.getApiKeyParam(), footballAPIConfig.getApiKeyValue());

		ResponseEntity<String> exchangeCompetition = restTemplate.exchange(competitionBuilder.buildAndExpand().toUri(), HttpMethod.GET,
				result, String.class);

		return new ResponseParser<Standing>().retrieveListOf(exchangeCompetition, Standing.class);
	}
}