package model;

import view.View;

public class Board {
	
	private Tile[][] grid = new Tile[8][8];
	
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

	public Tile[][] getGrid() {
		return this.grid;
	}
}
