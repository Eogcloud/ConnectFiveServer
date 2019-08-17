package com.genesys.c5_back.entities;

public class Tile {
	private TileType value;

	public Tile(TileType type) {
		this.value = type;
	}

	public TileType getValue() {
		return value;
	}

	public void setValue(TileType type) {
		this.value = type;
	}

}