package com.football.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@ConfigurationProperties("football")
@Data
public class FootballAPIConfig {

	private String baseUrl;
	private String action;
	private String countryAction;
	private String competitionsAction;
	private String competitionsParam;
	private String teamAction;
	private String teamParam;
	private String standingAction;
	private String standingParam;
	private String apiKeyParam;
	private String apiKeyValue;
}
