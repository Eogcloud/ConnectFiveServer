package com.genesys.c5_back.state;

import java.util.ArrayList;
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
		if (this.isGameActive()) {
			this.isGameActive = false;
			this.players = new HashSet<Player>();
			this.board = null;
		}
	}

	private boolean playersRegistered() {
		Player p1 = new Player(PlayerType.ONE);
		Player p2 = new Player(PlayerType.TWO);

		if (this.players.contains(p1) && this.players.contains(p2))
			return true;
		return false;
	}

	public boolean registerPlayer(Player player) {
		if (!players.contains(player)) {
			return players.add(player);
		}
		return false;
	}

	public Player getPlayerTurn() {
		if (this.playersRegistered()) {
			return this.playerTurn;
		}
		return null;
	}

	private boolean setPlayerTurn(Player player) {
		if (this.playersRegistered() && this.playerTurn == null) {
			this.playerTurn = player;
			return true;
		} else if (this.playersRegistered() && this.getPlayerTurn().getType() != player.getType()) {
			this.playerTurn = player;
			return true;
		}
		return false;
	}

	public boolean startGame() {
		if (!this.isGameActive) {
			List<Player> players = new ArrayList<>(this.players);
			this.isGameActive = true;
			return this.setPlayerTurn(players.get(0));
		}

		return false;
	}

	public List<Tile> initBoardState(int row, int column) {
		this.board = new GameBoard(row, column);
		return this.getBoardState();
	}

	public List<Tile> getBoardState() {
		if (board != null) {
			return board.getBoard();
		}
		return null;
	}

	public void playerMove(Player player, Integer column) {
		board.playerMove(column, 0, player);
	}
}
