package com.genesys.c5_back.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameBoard {

	private List<Tile> board;
	private boolean gameIsActive;
	private int BOARD_ROWS;
	private int BOARD_COLUMNS;

	public GameBoard(int rows, int columns) {
		if (rows > 0 && columns > 0) {
			this.BOARD_ROWS = rows;
			this.BOARD_COLUMNS = columns;
			this.board = initiateBoard(this.board, TileType.EMPTY, BOARD_ROWS, BOARD_COLUMNS);
		} else {
			throw new IllegalArgumentException();
		}

	}
	
	public List<Tile> getBoard(){
		return this.board;
	}

	private List<Tile> initiateBoard(List<Tile> board, TileType value, int rows, int columns) {
		return new ArrayList<Tile>(Collections.nCopies((rows * columns), new Tile(value)));
	}

	private Tile getNewTile(PlayerType player) {
		if (player == player.ONE) {
			return new Tile(TileType.PLAYERONE);
		} else {
			return new Tile(TileType.PLAYERTWO);
		}
	}

	private int getLowestEmptyRow(List<Tile> vector) {
		List<Tile> columnVector = vector;
		for (int i = 0; i < columnVector.size(); i++) {
			if (columnVector.get(i).getValue() == TileType.EMPTY) {
				return i;
			}
		}
		return -1;
	}

	private List<Tile> getColumnVector(List<Tile> board, int column, int rows, int columns) {
		List<Tile> columnVector = new ArrayList<>();
		int highestColumnIndex = (rows - 1) * (column - 1);

		for (int i = (highestColumnIndex + column); i < column; i -= BOARD_ROWS) {
			columnVector.add(board.get(i));
		}

		return columnVector;
	}

	public boolean playerMove(PlayerType player, int column) {
		if (gameIsActive && (column < BOARD_COLUMNS)) {

			List<Tile> columnVector = getColumnVector(this.board, column, BOARD_ROWS, BOARD_COLUMNS);
			Tile moveTile = getNewTile(player);
			int row = getLowestEmptyRow(columnVector);

			if (row != -1) {
				this.board.set((column * row), moveTile);
				return true;
			}
		}

		return false;
	}
}