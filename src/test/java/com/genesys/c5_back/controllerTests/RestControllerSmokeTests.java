package com.genesys.c5_back.controllerTests;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.genesys.c5_back.controllers.GameController;
import com.genesys.c5_back.controllers.PlayerController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestControllerSmokeTests {

	@Autowired
	private PlayerController playerController;

	@Autowired
	private GameController gameController;

	@Test
	public void contexLoads() throws Exception {
		assertThat(playerController).isNotNull();
		assertThat(gameController).isNotNull();
	}
}