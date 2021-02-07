package com.football.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class FootballStandings {
	
	private String countryDetail;
	private String leagueDetail;
	private String teamDetail;
	private String overalLeaugePosition;

}
