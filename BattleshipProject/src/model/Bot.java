package model;

import model.Board;
import model.Tile;
public class Bot {
	private Tile Health;
	public String playerName = "Computer";
	
	private Board randomTileGenerator() {
		return new Board();
	}
	
	private Tile placeBoat(Boat b) {
		return new Tile();
	}
	
	public String getName() {
		return this.playerName;
	}

}
