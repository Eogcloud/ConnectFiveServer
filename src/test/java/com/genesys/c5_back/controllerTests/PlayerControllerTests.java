package com.genesys.c5_back.controllerTests;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class PlayerControllerTests {

	final String emptyBoard = "[{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"},{\"value\":\"EMPTY\"}]";

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void boardShouldInitiate() throws Exception {
		assertThat(this.restTemplate.postForEntity("http://localhost:" + port + "/board/init", String.class, null))
				.contains(emptyBoard);
	}
}
