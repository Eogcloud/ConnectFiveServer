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
			this.board = new ArrayList<Tile>(Collections.nCopies((rows * columns), new Tile(TileType.EMPTY)));
		} else
			throw new IllegalArgumentException("Invalid Board Size");
	}

	public boolean setBoardTile(Tile tile, Integer row, Integer column) {
		if (row.intValue() >= 0 && row.intValue() <= this.BOARD_ROWS && column.intValue() >= 0
				&& column.intValue() <= this.BOARDS_COLUMNS) {

			int index = 0;

			if (column.intValue() == 0)
				index = row;
			else
				index = column.intValue() * row.intValue();
			this.board.set(index, tile);
			return true;
		}
		return false;
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

	public Tile getTile(Integer index) {
		return this.board.get(index);
	}

	public List<Tile> getBoard() {
		return this.board;
	}
}
