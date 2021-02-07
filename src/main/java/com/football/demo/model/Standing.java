package com.football.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Standing {
	
	@JsonProperty("country_name")
	private String countryName;
	
	@JsonProperty("league_id")
	private String leagueId;
	
	@JsonProperty("league_name")
	private String leagueName;
	
	@JsonProperty("team_id")
	private String teamId;
	
	@JsonProperty("team_name")
	private String teamName;
	
	@JsonProperty("overall_league_position")
	private String overallLeaguePosition;
	
}
