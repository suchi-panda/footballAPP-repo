package com.football.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.football.demo.config.FootballAPIConfig;
import com.football.demo.model.Competition;
import com.football.demo.model.Country;
import com.football.demo.model.FootballStandings;
import com.football.demo.model.Standing;
import com.football.demo.model.Team;
import com.football.demo.service.api.impl.FootballServiceClient;

@RunWith(MockitoJUnitRunner.class)
public class FootballServiceTest {

	@InjectMocks
	private FootballService footballService;
	
	@Mock
	private FootballServiceClient footballServiceClient;
	
	@Mock
	FootballAPIConfig footballAPIConfig;

	@Mock
	RestTemplate restTemplate;
	

	@Test
	public void testgetAllTeamStandingsSuccessCase() throws Exception {
		
		List<Country> countryList = getCountry();
		List<Competition> competitionList = getCompetition();
		List<Team> teamList = getTeam();
		List<Standing> standingList = getStandings();
		
		Mockito.when(footballServiceClient.getCountryList()).thenReturn(countryList);
		Mockito.when(footballServiceClient.getCompetitionList("conutryId")).thenReturn(competitionList);
		Mockito.when(footballServiceClient.getTeamList("leaugeId")).thenReturn(teamList);
		Mockito.when(footballServiceClient.getStandingsList("leaugeId")).thenReturn(standingList);
		
		FootballStandings allTeamStandings = footballService.getAllTeamStandings("England", "EPL", "Manchester");
		Assert.assertNotNull(allTeamStandings);
		
	}
	
	private List<Country> getCountry() {
		List countryList = new ArrayList<Country>();
		Country country = new Country();
		country.setCountryId("conutryId");
		country.setCountryName("England");
		countryList.add(country);
		return countryList;
	}

	private List<Competition> getCompetition() {
		List competitionList = new ArrayList<Competition>();
		Competition competition = new Competition();
		competition.setCountryId("conutryId");
		competition.setCountryName("England");
		competition.setLeagueId("leaugeId");
		competition.setLeagueName("EPL");
		competitionList.add(competition);
		return competitionList;
	}
	
	private List<Team> getTeam() {
		List teamList = new ArrayList<Team>();
		Team team = new Team();
		team.setTeamKey("key");
		team.setTeamName("Manchester");
		teamList.add(team);
		return teamList;
	}
	
	private List<Standing> getStandings() {
		List standingList = new ArrayList<Standing>();
		Standing standing = new Standing();
		standing.setCountryName("England");
		standing.setLeagueId("leaugeId");
		standing.setLeagueName("EPL");
		standing.setOverallLeaguePosition("2");
		standing.setTeamId("teamId");
		standing.setTeamName("Manchester");
		standingList.add(standing);
		return standingList;
	}
	

}