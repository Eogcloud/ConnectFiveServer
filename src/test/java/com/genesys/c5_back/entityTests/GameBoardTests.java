package com.genesys.c5_back.entityTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.genesys.c5_back.entities.GameBoard;
import com.genesys.c5_back.entities.Player;
import com.genesys.c5_back.entities.PlayerType;

public class GameBoardTests {

	@Test
	public void GameBoardCreatesCorrectSize() {
		int rows = 7;
		int columns = 7;
		GameBoard gb = new GameBoard(rows, columns);
		assertEquals(gb.getBoard().size(), rows * columns);
	}

	@Test
	public void ValidMoveUpdatesBoard() {
		int rows = 8;
		int columns = 8;
		GameBoard gb = new GameBoard(rows, columns);
		Player testPlayer = new Player(PlayerType.ONE);
		gb.playerMove(5, 5, testPlayer);
		assertEquals(gb.getBoard().get(5 * 5).getType().toString(), testPlayer.getType().toString());
	}

	@Test(expected = IllegalArgumentException.class)
	public void invalidMoveThrowsException() {
		int rows = 8;
		int columns = 8;
		GameBoard gb = new GameBoard(rows, columns);
		Player testPlayer = new Player(PlayerType.ONE);
		gb.playerMove(0, -1, testPlayer);
	}

	@Test
	public void winCheckHorizonal() {
		int rows = 7;
		int columns = 7;
		GameBoard gb = new GameBoard(rows, columns);
		fail("TODO: EMPTY TEST");
	}

	@Test
	public void winCheckVertical() {
		fail("TODO: EMPTY TEST");
	}

	@Test
	public void winCheckDiagnol() {
		fail("TODO: EMPTY TEST");
	}
}
