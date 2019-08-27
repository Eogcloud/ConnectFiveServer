package com.genesys.c5_back.entities;

public class Player {

	private PlayerType type;

	public Player(PlayerType type) {
		this.type = type;
	}

	public PlayerType getType() {
		return this.type;
	}

	@Override
	public boolean equals(Object o) {
		if (this.hashCode() == o.hashCode()) {
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		byte[] arr = this.getType().toString().getBytes();

		for (int i = 0; i < arr.length; i++) {
			hash += Byte.toUnsignedInt(arr[i]);
		}

		return hash;
	}
}
