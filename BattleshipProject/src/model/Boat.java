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
	

//	public Boat(String name, int size) {
//		this.boats = new ArrayList<>();
//		Size = size;
//		Name = name;
//		this.boats.add(Name);
//		this.boatDamaged = false;
//	}
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
	

//	public void setBoat(Boat b, int x, int y) {
//		int coordinate = boatCoordinate[x][y];
//		if (coordinate == TileState.EMPTY_NOT_HIT.getAction()) {
//			boatCoordinate[x][y] = TileState.EMPTY_HIT.getAction();
//		} else if (coordinate == TileState.OCCUPIED_NOT_HIT.getAction()) {
//			boatCoordinate[x][y] = TileState.OCCUPIED_HIT.getAction();
//			this.Size--;
//			this.boatDamaged = true;
//		} else if (coordinate == TileState.EMPTY_HIT.getAction() || coordinate == TileState.OCCUPIED_HIT.getAction()) {
//			System.out.println("DISCOVERED!");
//		}
//	}
//
//	// The user specifies where the boat should be placed and where the boat ends
//	public void setBoatCoordinate(int start_x, int start_y, int end_x, int end_y) {
//		if (start_x == end_x) {
//			for (int i = start_y; i < end_y; i++) {
//				boatCoordinate[start_x][i] = TileState.OCCUPIED_NOT_HIT.getAction();
//			}
//		} else if (start_y == end_y) {
//			for (int i = start_x; i < end_x; i++) {
//				boatCoordinate[i][start_y] = TileState.OCCUPIED_NOT_HIT.getAction();
//			}
//		}
//
//	}
//
//	public int getBoatHealth() {
//		return this.Size;
//	}
//
//	public boolean boatAlive() {
//		return Size == 0;
//	}
//	
//	public boolean getBoatDamaged(){
//		return this.boatDamaged;
//	}
}
