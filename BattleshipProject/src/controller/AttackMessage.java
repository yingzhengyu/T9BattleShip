package controller;

import model.Tile;

public class AttackMessage implements Message{
	char x;
	int y;
	Tile tile;
	
	public AttackMessage(char x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public AttackMessage(Tile tile) {
		this.tile = tile;
	}
	
	public char getXCoordinate() {
		return this.x;
	}
	
	public int getYCoordinate() {
		return this.y;
	}

}
