package com.genesys.c5_back.entities;

import java.util.ArrayList;
import java.util.List;

public class GameBoard {

	private Board board;

	public GameBoard(int rows, int columns) {
		this.board = new Board(rows, columns);
	}

	public List<Tile> getBoard() {
		return this.board.getBoard();
	}

	private Tile getNewTile(Player player) {
		if (player.getType().toString() == TileType.ONE.toString())
			return new Tile(TileType.ONE);
		else {
			return new Tile(TileType.TWO);
		}
	}

	private int getLowestEmptyRow(List<Tile> columnVector) {
		int lowestEmtpyTileIndex = -1;

		for (int i = 0; i < columnVector.size(); i++) {
			if (columnVector.get(i).getValue() == TileType.EMPTY) {
				lowestEmtpyTileIndex = i;
			}
		}
		return lowestEmtpyTileIndex;
	}

	private List<Tile> getColumnVector(int columnRequested) {
		List<Tile> columnVector = new ArrayList<>();
		int highestColumnIndex = (this.board.size() - (this.board.getBoardColumns() - columnRequested));

		for (int i = highestColumnIndex; i < columnRequested; i -= this.board.getBoardRows()) {
			columnVector.add(this.board.getTile(i, null));
		}

		return columnVector;
	}

	public boolean playerMove(Player player, Integer move) {
		List<Tile> columnVector = getColumnVector(move);
		int row = getLowestEmptyRow(columnVector);

		if (row != -1) {
			Tile moveTile = getNewTile(player);
			return this.board.setBoardTile(row, move, moveTile);
		}

		return false;
	}

	public boolean isGameWon(Player player) {
		boolean gameIsWon = false;

		if (horizontalWinCheck(player, this.board) || verticalWinCheck(player, this.board)
				|| diagnolWinCheck(player, this.board))
			return !gameIsWon;

		return gameIsWon;
	}

	private boolean diagnolWinCheck(Player player, Board board) {

		// TODO

		return false;
	}

	private boolean verticalWinCheck(Player player, Board board) {
		int verticalCounter = 0;

		for (int i = 0; i < board.getBoardColumns(); i++) {

			verticalCounter = 0;

			for (int j = 0; j < board.getBoardRows(); j++) {
				int boardIndex;

				if (i == 0 && j == 0)
					boardIndex = j;
				else
					boardIndex = i * j;

				if (verticalCounter == 5)
					return true;

				if (board.getTile(boardIndex, null).getValue().toString() == player.toString()) {
					verticalCounter++;
				}
			}
		}

		return false;
	}

	private boolean horizontalWinCheck(Player player, Board board) {
		int horizontalCounter = 0;
		for (Tile tile : board.getBoard()) {
			if (horizontalCounter == 5)
				return true;
			if (tile.getValue().toString() == player.getType().toString())
				horizontalCounter++;
		}
		return false;
	}

}