package com.genesys.c5_back.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.genesys.c5_back.state.GameState;

@RestController
public class GameController {
	
	private GameState state = GameState.getInstance();
	
	@RequestMapping(value = "/board/init")
    public ResponseEntity<Object> initBoard() {
		if(state.getBoardState() == null) {
			state.initBoardState(6, 9);
		}
		
		return new ResponseEntity<Object>(state.getBoardState(), HttpStatus.OK);
    }
	
	@RequestMapping(value = "/board/get")
    public ResponseEntity<Object> getBoard() {
		return new ResponseEntity<Object> (state.getBoardState(), HttpStatus.OK);
    }
	
}
