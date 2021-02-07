package com.football.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.football.demo.exceptions.FootballBaseException;
import com.football.demo.exceptions.ResourceNotFoundException;
import com.football.demo.model.FootballStandings;
import com.football.demo.model.GenericResponse;
import com.football.demo.model.ResponseWrapper;
import com.football.demo.service.FootballService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("v1/football")
@Slf4j
@SuppressWarnings("rawtypes")
public class FootballController {

	@Autowired
	FootballService footballService;

	@GetMapping("/countries/{countryName}/leagues/{leaugeName}/teams/{teamName}")
	public ResponseEntity<GenericResponse> getAllTeamStandings(
			@PathVariable("countryName") String countryName,
			@PathVariable("leaugeName") String leagueName,
			@PathVariable("teamName") String teamName){
		FootballStandings standings = new FootballStandings();
		try {
			standings = footballService.getAllTeamStandings(countryName,leagueName,teamName);
		}catch (FootballBaseException xe) {
			log.error("FootballController::getAllTeamStandings:: FootballBaseException {}", xe);
			return ResponseWrapper.constructResponse(xe.getHttpErrorCode().value(),
					"Football Standings Fetch Failed", xe.getMessage(),xe.getAppErrorCode());
		}catch(ResourceNotFoundException re) {
			log.error("FootballController::getAllTeamStandings:: ResourceNotFoundException {}", re);
			return ResponseWrapper.constructResponse(re.getHttpErrorCode().value(),
					"Football Standings Fetch Failed", re.getMessage(),re.getAppErrorCode());
		}catch(Exception e) {
			log.error("FootballController::getAllTeamStandings:: Exception {}", e);
			return ResponseWrapper.constructResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),
					"Football Standings Fetch Failed", e.getMessage());
		}
		return ResponseWrapper.constructResponse(HttpStatus.OK.value(),standings);
	}
}
