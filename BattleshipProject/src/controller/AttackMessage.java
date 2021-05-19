package controller;

import model.Tile;
/**
 * 
 * @author Team 9
 *	AttackMessage using Message interface
 */
public class AttackMessage implements Message{
	Tile tile;
	/**
	 * Class constructor
	 * @param tile Tilt 
	 */
	public AttackMessage(Tile tile) {
		this.tile = tile;
	}
	/**
	 * Getting the tilt
	 * @return tile Tilt
	 */
	public Tile getTile() {
		return this.tile;
	}
	
}
