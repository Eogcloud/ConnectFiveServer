package com.genesys.c5_back.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class GameBoard {

	private List<Tile> board;
	private int BOARD_ROWS;
	private int BOARD_COLUMNS;

	public GameBoard(int rows, int columns) {
		if (rows > 0 && columns > 0) {
			this.BOARD_ROWS = rows;
			this.BOARD_COLUMNS = columns;
			this.board = initBoard(this.board, TileType.EMPTY, BOARD_ROWS, BOARD_COLUMNS);
		} else {
			throw new IllegalArgumentException();
		}

	}
	
	public List<Tile> getBoard(){
		return this.board;
	}

	private List<Tile> initBoard(List<Tile> board, TileType value, int rows, int columns) {
		return new ArrayList<Tile>(Collections.nCopies((rows * columns), new Tile(value)));
	}

	private Tile getNewTile(Player player) {
		if(player.getType().toString() == TileType.ONE.toString())
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

	private List<Tile> getColumnVector(List<Tile> board, int column, int rows, int columns) {
		List<Tile> columnVector = new ArrayList<>();
		int highestColumnIndex = (rows - 1) * (column - 1);

		for (int i = (highestColumnIndex + column); i < column; i -= BOARD_ROWS) {
			columnVector.add(board.get(i));
		}

		return columnVector;
	}

	public boolean playerMove(Player player, int column, List<Tile> board) {
		if (column < BOARD_COLUMNS && column > 0) {
			List<Tile> columnVector = getColumnVector(board, column, BOARD_ROWS, BOARD_COLUMNS);
			int row = getLowestEmptyRow(columnVector);
			
			if (row != -1) {
				Tile moveTile = getNewTile(player);
				board.set((column * row), moveTile);
				return true;
			}
		}

		return false;
	}
	
	public boolean isGameWon(Player player, List<Tile> board, int rows, int columns) {
		boolean gameIsWon = false;
		
		if(horizontalWinCheck(player, board)) return !gameIsWon;
		if(verticalWinCheck(player, board, rows, columns)) return !gameIsWon;
		if(diagnolWinCheck(player, board, rows, columns)) return !gameIsWon;
		
		return gameIsWon;
	}
	
	private boolean diagnolWinCheck(Player player, List<Tile> board, int rows, int columns) {
		
		//TODO
		
		return false;
	}

	private boolean verticalWinCheck(Player player, List<Tile> board, int rows, int columns) {
		int verticalCounter = 0;
		
		for(int i=0; i<columns; i++) {
			
			verticalCounter = 0;
			
			for(int j=0; j<rows; j++) {
				int boardIndex;
				
				if(i == 0 && j == 0) boardIndex = j;
				else boardIndex = i*j;
				
				if(verticalCounter == 5) return true;
				
				if(board.get(boardIndex).getValue().toString() == player.toString()) {
					verticalCounter++;
				}
			}
		}
		
		return false;
	}

	private boolean horizontalWinCheck(Player player, List<Tile> board) {
		int horizontalCounter = 0;	
		for( Tile tile : board ) {
			if(horizontalCounter == 5) return true;
			if(tile.getValue().toString() == player.getType().toString()) horizontalCounter++;
		}
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}