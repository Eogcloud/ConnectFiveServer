package com.genesys.c5_back.state;

import java.util.HashSet;
import java.util.List;
import com.genesys.c5_back.entities.GameBoard;
import com.genesys.c5_back.entities.Player;
import com.genesys.c5_back.entities.PlayerType;
import com.genesys.c5_back.entities.Tile;

public class GameState {
	
	private static GameState state = null;
	private GameBoard board;
	private HashSet<Player> players;
	private Player playerTurn;
	
	private GameState() {
		
	}
	
	public static GameState getInstance() {
        if (state == null) 
        	state = new GameState(); 
        return state; 
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
