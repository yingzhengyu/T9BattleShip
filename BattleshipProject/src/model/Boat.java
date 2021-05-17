package model;

import java.util.ArrayList;

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
	
	public Boat(int size, int row, int column , boolean vert) {
		Size = size;
		this.row = row;
		this.column = column;
		this.vertical = vert;
	}
	
	public int getSize() {
		return this.Size;
	}
	
	public int getRow() {
		return row;
	}
	
	public int getColumn() {
		return column;
	}
	
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
