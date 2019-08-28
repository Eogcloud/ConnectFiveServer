package com.genesys.c5_back.controllerTests;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class PlayerControllerTests {

	final String emptyBoard = "[{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"}]";

	@LocalServerPort
	private int port;

	@Test
	public void boardShouldInitiateAsEmpty() throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		String response = restTemplate.postForObject("http://localhost:" + port + "/board/init", null, String.class);
		assertThat(response).contains(emptyBoard);
	}
}
