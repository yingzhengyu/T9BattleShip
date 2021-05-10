package controller;

import model.Tile;

public class AttackMessage implements Message{
	Tile tile;
	
	public AttackMessage(Tile tile) {
		this.tile = tile;
	}
	
	public Tile getTile() {
		return this.tile;
	}
	
}
