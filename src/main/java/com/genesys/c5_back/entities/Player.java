package com.genesys.c5_back.entities;

public class Player {
	
	private PlayerType type;
	
	public Player(PlayerType type) {
		this.type = type;
	}
	
	public PlayerType getType() {
		return this.type;
	}
}
