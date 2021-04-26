package controller;

public class TileMessage {
	char x;
	int y;
	public TileMessage(char x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public char getXCoordinate() {
		return this.x;
	}
	
	public int getYCoordinate() {
		return this.y;
	}

	
}
