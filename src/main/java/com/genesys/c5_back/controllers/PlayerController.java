package com.genesys.c5_back.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.genesys.c5_back.entities.Player;
import com.genesys.c5_back.entities.PlayerType;
import com.genesys.c5_back.state.GameState;

@RestController
@RequestMapping(value = "/player")
public class PlayerController {

	private GameState state = GameState.getInstance();

	@RequestMapping(value = "/turn")
	public ResponseEntity<Object> getPlayerTurn() {
		if (state.getPlayerTurn() != null)
			return new ResponseEntity<Object>(state.getPlayerTurn(), HttpStatus.OK);

		return new ResponseEntity<Object>("No active Turn", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@RequestMapping(value = "/register/{PlayerNumber}", method = RequestMethod.POST)
	public ResponseEntity<Object> registerPlayer(@PathVariable("PlayerNumber") PlayerType type) {
		if (state.registerPlayer(new Player(type)))
			return new ResponseEntity<Object>(type + " has been registered", HttpStatus.OK);

		return new ResponseEntity<Object>("Player already registered!", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@RequestMapping(value = "/start", method = RequestMethod.POST)
	public ResponseEntity<Object> startGame() {
		if (state.isGameActive())
			return new ResponseEntity<Object>("The Game has already begun", HttpStatus.INTERNAL_SERVER_ERROR);

		if (state.startGame())
			return new ResponseEntity<Object>("Game has begun", HttpStatus.OK);

		return new ResponseEntity<Object>("Game failed to start", HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
