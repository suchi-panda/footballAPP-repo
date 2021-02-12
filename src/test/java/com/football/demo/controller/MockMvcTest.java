package com.football.demo.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.football.demo.config.FootballAPIConfig;
import com.football.demo.service.FootballService;
import com.football.demo.service.api.impl.FootballServiceClient;

@RunWith(SpringRunner.class)
@WebMvcTest(value = FootballController.class)
public class MockMvcTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	FootballService footballService;

	@Autowired
	FootballServiceClient footballServiceClient;

	@Autowired
	FootballAPIConfig footballAPIConfig;


	@Test
	public void test() throws Exception {

		Assertions.assertNotNull(mockMvc);
		Assertions.assertNotNull(footballService);
		Assertions.assertNotNull(footballServiceClient);
		Assertions.assertNotNull(footballAPIConfig);

		String uri = "/v1/football/countries/England/leagues/Championship/teams/Brentford";
		MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		assertNotNull(mvcResult);
	}

	@TestConfiguration
	static class MockMvcTestConfiguration {

		@Bean(name = "footballService")
		public FootballService getFootballService() {
			return new FootballService();
		}

		@Bean(name = "footballServiceClient")
		public FootballServiceClient getFootballServiceClient() {
			return new FootballServiceClient();
		}

		@Bean(name = "footballAPIConfig")
		public FootballAPIConfig getFootballAPIConfig() {
			return new FootballAPIConfig();
		}

	}

}


