package model;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;

import controller.Message;
import view.View;

public class Board {
	
	private int currentPlayer = 1;
	private int row = 8;
	private int column = 8;
	private Tile[][] player1Grid = new Tile[row][column];
	private Tile[][] player2Grid = new Tile[row][column];
	private ArrayList<Boat> player1Boats = new ArrayList<>();
	private ArrayList<Boat> player2Boats = new ArrayList<>();
	private BlockingQueue<Message> queue;
	
	public void updateGrid(char x, int y) {
		// converting char ascii into integer 1-8
		int charAscii = x;
		charAscii -= 97;
		y--; 	// incrementing y to correct position on grid
		
		// 0 = empty, not hit
		// 1 = empty, hit
		// 2 = occupied, not hit
		// 3 = occupied, hit

//		// if the tile has not been hit, we change the status to hit by adding one
//		if (this.grid[charAscii][y] == 0 || this.grid[charAscii][y] == 2) {
//			this.grid[charAscii][y]++;
//		}
//		// Observer that notifies the view whenever changes occur to the model
//		View.printGrid(grid);
	}
	
	public Board(BlockingQueue<Message> queue, ArrayList<Boat> p1, ArrayList<Boat> p2) {
		this.queue = queue;
		player1Boats = p1;
		player2Boats = p2;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				player1Grid[i][j] = new Tile(this.queue);
				player2Grid[i][j] = new Tile(this.queue);
			}
		}
		for(int i = 0; i < player1Boats.size(); i++) {
			if (player1Boats.get(i).getVert()) {
				for (int j = 0; j < player1Boats.get(i).getSize(); j++) {
					player1Grid[player1Boats.get(i).getRow() + j][player1Boats.get(i).getColumn()].setTileState(TileState.OCCUPIED_NOT_HIT);	
				}	
			}		
			else {
				for (int j = 0; j < player1Boats.get(i).getSize(); j++) {
					player1Grid[player1Boats.get(i).getRow()][player1Boats.get(i).getColumn() + j].setTileState(TileState.OCCUPIED_NOT_HIT);	
				}	
			}	
		}
		
		for(int i = 0; i < player2Boats.size(); i++) {
			if (player2Boats.get(i).getVert()) {
				for (int j = 0; j < player2Boats.get(i).getSize(); j++) {
					player2Grid[player2Boats.get(i).getRow() + j][player2Boats.get(i).getColumn()].setTileState(TileState.OCCUPIED_NOT_HIT);	
				}	
			}		
			else {
				for (int j = 0; j < player2Boats.get(i).getSize(); j++) {
					player2Grid[player2Boats.get(i).getRow()][player2Boats.get(i).getColumn() + j].setTileState(TileState.OCCUPIED_NOT_HIT);	
				}	
			}	
		}
	}

	public Tile[][] getGrid(int player) {
		if(player == 1) {
			return player1Grid;
		}
		else {
			return player2Grid;
		}
	}
	
	public int getCurrentPlayer() {
		return this.currentPlayer;
	}
	
	// switches the current player from 1 to 2 or 2 to 1 
	public void updateCurrentPlayer() {
		if (this.currentPlayer == 1) {
			this.currentPlayer = 2;
		}
		else if (this.currentPlayer == 2) {
			this.currentPlayer = 1;
		}
	}
	
	public ArrayList<Boat> getBoatList(int player){
		if(player == 1) {
			return player1Boats;
		}
		else {
			return player2Boats;
		}
	}
	
	public void setPlayerBoat(int player, ArrayList<Boat> boat) {
		if(player == 1) {
			player1Boats = boat;
		}
		else {
			player2Boats = boat;
		}
	}
	
	public void updateBoard() {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				player1Grid[i][j] = new Tile(this.queue);
				player2Grid[i][j] = new Tile(this.queue);
			}
		}
		for(int i = 0; i < player1Boats.size(); i++) {
			if (player1Boats.get(i).getVert()) {
				for (int j = 0; j < player1Boats.get(i).getSize(); j++) {
					player1Grid[player1Boats.get(i).getRow() + j][player1Boats.get(i).getColumn()].setTileState(TileState.OCCUPIED_NOT_HIT);	
				}	
			}		
			else {
				for (int j = 0; j < player1Boats.get(i).getSize(); j++) {
					player1Grid[player1Boats.get(i).getRow()][player1Boats.get(i).getColumn() + j].setTileState(TileState.OCCUPIED_NOT_HIT);	
				}	
			}	
		}
		
		for(int i = 0; i < player2Boats.size(); i++) {
			if (player2Boats.get(i).getVert()) {
				for (int j = 0; j < player2Boats.get(i).getSize(); j++) {
					player2Grid[player2Boats.get(i).getRow() + j][player2Boats.get(i).getColumn()].setTileState(TileState.OCCUPIED_NOT_HIT);	
				}	
			}		
			else {
				for (int j = 0; j < player2Boats.get(i).getSize(); j++) {
					player2Grid[player2Boats.get(i).getRow()][player2Boats.get(i).getColumn() + j].setTileState(TileState.OCCUPIED_NOT_HIT);	
				}	
			}	
		}
	}
	
//	public setGrid(int player) {
//		if(player == 1) {
//		
//		}
//		else {
//			
//		}
//	}
	
	public boolean checkVictory() {
		boolean state = true;
		if (currentPlayer == 1) {
			for(int i = 0; i < player2Boats.size(); i++) {
				if (player2Boats.get(i).getVert()) {
					for (int j = 0; j < player2Boats.get(i).getSize(); j++) {
						if (player2Grid[player2Boats.get(i).getRow() + j][player2Boats.get(i).getColumn()].getTileState() == TileState.OCCUPIED_NOT_HIT){
							state = false;
						}
					}	
				}		
				else {
					for (int j = 0; j < player2Boats.get(i).getSize(); j++) {
						if(player2Grid[player2Boats.get(i).getRow()][player2Boats.get(i).getColumn() + j].getTileState() == TileState.OCCUPIED_NOT_HIT)	{
							state = false;
						}
					}	
				}	
			}
			return state;
		}
		else {
			for(int i = 0; i < player1Boats.size(); i++) {
				if (player1Boats.get(i).getVert()) {
					for (int j = 0; j < player1Boats.get(i).getSize(); j++) {
						if (player1Grid[player1Boats.get(i).getRow() + j][player1Boats.get(i).getColumn()].getTileState() == TileState.OCCUPIED_NOT_HIT){
							state = false;
						}
					}	
				}		
				else {
					for (int j = 0; j < player1Boats.get(i).getSize(); j++) {
						if(player1Grid[player1Boats.get(i).getRow()][player1Boats.get(i).getColumn() + j].getTileState() == TileState.OCCUPIED_NOT_HIT)	{
							state = false;
						}
					}	
				}	
			}
			return state;
		}
	}
}
