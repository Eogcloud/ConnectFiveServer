package com.genesys.c5_back.entities;

public class Tile {
	private TileType type;

	public Tile(TileType type) {
		this.type = type;
	}

	public TileType getType() {
		return type;
	}

	public void setValue(TileType type) {
		this.type = type;
	}

}