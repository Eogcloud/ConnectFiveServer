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
public class GameController {

	private GameState state = GameState.getInstance();

	@RequestMapping(value = "/board/init", method = RequestMethod.POST)
	public ResponseEntity<Object> initBoard() {
		if (state.getBoardState() == null) {
			state.initBoardState(6, 9);
		}
		return new ResponseEntity<Object>(state.getBoardState(), HttpStatus.OK);
	}

	@RequestMapping(value = "/board/get")
	public ResponseEntity<Object> getBoard() {
		if (state.getBoardState() == null) {
			return new ResponseEntity<Object>(new String("Board has not been intiated"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<Object>(state.getBoardState(), HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/board/move/{playerNumber}/{column}", method = RequestMethod.POST)
	public ResponseEntity<Object> playerMove(@PathVariable("PlayerNumber") PlayerType type,
			@PathVariable("column") int column) {

		try {
			state.playerMove(new Player(type), column);
		} catch (IllegalArgumentException e) {
			return new ResponseEntity<Object>("invalid move from" + type + "in" + column, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<Object>(type + "dropped in" + column, HttpStatus.OK);
	}

}
