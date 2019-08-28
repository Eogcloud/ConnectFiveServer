package com.genesys.c5_back.entityTests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.genesys.c5_back.entities.Board;
import com.genesys.c5_back.entities.Tile;
import com.genesys.c5_back.entities.TileType;

public class BoardTests {

	@Test
	public void boardShouldCreateSpecifiedSize() {
		Integer rows = 10;
		Integer columns = 10;

		Board board = new Board(rows, columns);

		assertEquals(board.getBoardColumns(), columns);
		assertEquals(board.getBoardRows(), rows);
		assertEquals(board.size(), (rows * columns));
	}

	@Test(expected = IllegalArgumentException.class)
	public void invalidBoardShouldFail() {
		Integer rows = -2;
		Integer columns = -1;
		new Board(rows, columns);
	}

	@Test(expected = IllegalArgumentException.class)
	public void emptyBoardShouldFail() {
		Integer rows = 0;
		Integer columns = 0;
		new Board(rows, columns);
	}

	@Test
	public void validBoardChangeShouldSucceed() {
		Integer rows = 10;
		Integer columns = 10;
		Board board = new Board(rows, columns);
		Tile testTile = new Tile(TileType.ONE);
		board.setBoardTile(5, 5, testTile);
		assertEquals(board.getTile(5, 5).getValue(), testTile.getValue());
	}

	@Test(expected = IllegalArgumentException.class)
	public void invalidBoardChangeShouldfail() {
		Integer rows = 10;
		Integer columns = 10;
		Board board = new Board(rows, columns);
		Tile testTile = new Tile(TileType.ONE);

		board.setBoardTile(-1, 7, testTile);
	}
}
