package com.genesys.c5_back.state;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.genesys.c5_back.entities.GameBoard;
import com.genesys.c5_back.entities.Player;
import com.genesys.c5_back.entities.PlayerType;
import com.genesys.c5_back.entities.Tile;

public class GameState {
	
	private static GameState state;
	
	private GameBoard board;
	private Set<Player> players;
	private Player playerTurn;
	private boolean isGameActive;
	
	
	private GameState() {
		players = new HashSet<Player>();
		isGameActive = false;
	}
	
	public static GameState getInstance() {
        if (state == null) 
        	state = new GameState(); 
        return state; 
	}
	
	public boolean isGameActive() {
		return this.isGameActive;
	}
	
	public void endGame() {
		if(this.isGameActive()) {
			this.isGameActive = false;
		}
	}
	
	public void startGame() {
		if(this.playersRegistered()) {
			this.isGameActive = true;
		}
	}
	
	private boolean playersRegistered() {
		if( players.contains(new Player(PlayerType.ONE)) && players.contains(new Player(PlayerType.TWO)))
			return true;
		return false;
	}
	
	public boolean registerPlayer(Player player) {
		return players.add(player);
	}
	
	public Player getPlayerTurn() {
		if(this.playersRegistered()) {
			return this.playerTurn;
		}
		return null;
	}
	
	public boolean setPlayerTurn(Player player) {
		if(this.playersRegistered() && this.playerTurn.getType() != player.getType()) {
			this.playerTurn = player;
			return true;
		}
		return false;
	}
	
	public List<Tile> initBoardState(int row, int column){
		board = new GameBoard(row, column);
		return this.getBoardState();	
	}
	
	public List<Tile> getBoardState(){
		if(board != null) {
			return board.getBoard();
		}
		return null;	
	}
}
