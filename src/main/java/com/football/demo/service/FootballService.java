package com.football.demo.service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.football.demo.exceptions.AppExceptionCodes;
import com.football.demo.exceptions.FootballBaseException;
import com.football.demo.exceptions.ResourceNotFoundException;
import com.football.demo.model.Competition;
import com.football.demo.model.Country;
import com.football.demo.model.FootballStandings;
import com.football.demo.model.Standing;
import com.football.demo.model.Team;
import com.football.demo.service.api.impl.FootballServiceClient;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FootballService {

	@Autowired
	FootballServiceClient footballServiceClient;

	public FootballStandings getAllTeamStandings(String countryName,String leagueName,String teamName) throws Exception{
		FootballStandings standing = new FootballStandings();
		try {
			List<Country> countryList = footballServiceClient.getCountryList();

			List<String> countryIdFilteredList = countryList.stream().filter(c->c.getCountryName().equals(countryName)).map(Country::getCountryId).collect(Collectors.toList());
			if(countryIdFilteredList.size()>0) {
				List<Competition> competitionList = footballServiceClient.getCompetitionList(countryIdFilteredList.get(0));

				List<String> filteredLegueIdList = competitionList.stream().filter(co -> co.getLeagueName().equals(leagueName)).map(Competition::getLeagueId).collect(Collectors.toList());
				if(Objects.nonNull(filteredLegueIdList) && filteredLegueIdList.size()>0) {
					List<Team> teamList = footballServiceClient.getTeamList(filteredLegueIdList.get(0));

					List<Team> filteredTeamList = teamList.stream().filter(t -> t.getTeamName().equals(teamName)).collect(Collectors.toList());
					if(Objects.nonNull(filteredTeamList) && filteredTeamList.size()>0) {
						List<Standing> standingsList = footballServiceClient.getStandingsList(filteredLegueIdList.get(0));
						if(Objects.nonNull(standingsList) && standingsList.size()>0) {
							List<Standing> filteredStanding = standingsList.stream().filter(s -> s.getCountryName().equals(countryName) && s.getLeagueName().equals(leagueName) && s.getTeamName().equals(teamName)).collect(Collectors.toList());
							if(Objects.nonNull(filteredStanding) && filteredStanding.size()>0) {
								standing.setCountryDetail(countryIdFilteredList.get(0) + "-" + filteredStanding.get(0).getCountryName());
								standing.setLeagueDetail(filteredStanding.get(0).getLeagueId() + "-" + filteredStanding.get(0).getLeagueName());
								standing.setTeamDetail(filteredStanding.get(0).getTeamId() + "-" + filteredStanding.get(0).getTeamName());
								standing.setOveralLeaugePosition(filteredStanding.get(0).getOverallLeaguePosition());
							}
						}else {
							log.info("No Standing found !!");
							throw new ResourceNotFoundException(HttpStatus.NOT_FOUND,AppExceptionCodes.STANDINGS_NOTFOUND,"No Standing Record Found");
						}
					}else {
						log.info("No Team Found for the league !!");
						throw new ResourceNotFoundException(HttpStatus.NOT_FOUND,AppExceptionCodes.TEAM_NOTFOUND,"No Team Found for the league");
					}
				}else {
					log.info("No League found!!");
					throw new ResourceNotFoundException(HttpStatus.NOT_FOUND,AppExceptionCodes.LEAGUE_NOTFOUND,"No League Record Found");
				}
			}else {
				log.info("No country found!!");
				throw new ResourceNotFoundException(HttpStatus.NOT_FOUND,AppExceptionCodes.COUNTRY_NOTFOUND,"No Country Record Found");
			}
		}catch(FootballBaseException fbe){
			log.info("FootballService::getAllTeamStandings:: FootballBaseException");
			throw fbe;
		}catch (Exception e) {
			throw e;
		}
		return standing;

	}
}
