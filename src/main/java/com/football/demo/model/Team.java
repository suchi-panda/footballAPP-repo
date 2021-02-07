package com.football.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Team {
	
	@JsonProperty("team_key")
	private String teamKey;
	
	@JsonProperty("team_name")
	private String teamName;
	
}
