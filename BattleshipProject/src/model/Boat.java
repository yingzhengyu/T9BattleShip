package model;

import java.util.ArrayList;
/**
 *  Boat class that represents the model of the boat on the game board.
 * @author Group 9
 *
 */
public class Boat {
	private int Size;
	private int row;
	private int column;
	private boolean vertical;
	private String Name;
	private boolean boatDamaged;
	private TileState[][] boatCoordinate;
	
	/**
	 * Constructs a new boat with given size and position
	 * @param size Number of tiles that the boat takes up.
	 * @param row The row that the boat will be placed into.
	 * @param column The column that the boat will be place into. 
	 * @param vert If true, places the boat in a vertical orientation. If false, places the boat in a horizontal orientation. 
	 */
	public Boat(int size, int row, int column , boolean vert) {
		Size = size;
		this.row = row;
		this.column = column;
		this.vertical = vert;
	}
	/**
	 *  Gets the size of the boat.
	 * @return Number of tiles that the boat takes up. 
	 */
	public int getSize() {
		return this.Size;
	}
	/**
	 * Gets the row the boat was initially placed on.
	 * @return The row coordinate of the head of the boat. 
	 */
	public int getRow() {
		return row;
	}
	/**
	 * Gets the column the boat was initially placed on.
	 * @return The column coordinate of the head of the boat. 
	 */
	public int getColumn() {
		return column;
	}
	/**
	 * Gets the orientation of the boat.
	 * @return Returns true if the boat has vertical orientation, false if the boat has horizontal orientation.
	 */
	public boolean getVert() {
		return vertical;
	}
}
