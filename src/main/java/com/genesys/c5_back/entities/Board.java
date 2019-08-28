package com.genesys.c5_back.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Board {

	private List<Tile> board;
	private Integer BOARD_ROWS;
	private Integer BOARDS_COLUMNS;

	public Board(Integer rows, Integer columns) {
		if (rows.intValue() > 0 && columns.intValue() > 0) {
			this.BOARD_ROWS = rows;
			this.BOARDS_COLUMNS = columns;
			this.board = new ArrayList<Tile>(
					Collections.nCopies((this.BOARD_ROWS * this.BOARDS_COLUMNS), new Tile(TileType.EMPTY)));
		} else
			throw new IllegalArgumentException("Invalid Board Size");
	}

	public void setBoardTile(Integer row, Integer column, Tile tile) {
		if (this.checkValidBoardIndex(row, column)) {

			int index = 0;

			if (column.intValue() == 0)
				index = row;
			else
				index = column.intValue() * row.intValue();
			this.board.set(index, tile);

		} else
			throw new IllegalArgumentException("Column and row indices are out of bounds of the board.");
	}

	public Integer getBoardRows() {
		return this.BOARD_ROWS;
	}

	public int size() {
		return this.board.size();
	}

	public Integer getBoardColumns() {
		return this.BOARDS_COLUMNS;
	}

	public Tile getTile(Integer row, Integer column) {
		if (this.checkValidBoardIndex(row, column))
			return this.board.get(row * column);
		else
			throw new IllegalArgumentException("Column and row indices are out of bounds of the board.");
	}

	public List<Tile> getBoard() {
		return this.board;
	}

	private boolean checkValidBoardIndex(Integer row, Integer column) {
		if ((row < 0 || row > this.BOARD_ROWS) || (column < 0 || column > this.BOARDS_COLUMNS)) {
			return false;
		}
		return true;
	}
}
