package model;

public class Board {
	
	int[][] grid = new int[8][8];
	
	public void updateGrid(char x, int y) {
		// converting char ascii into integer 1-8
		int charAscii = x;
		charAscii -= 96;
		System.out.println(charAscii);
		
		// 0 = empty, not hit
		// 1 = empty, hit
		// 2 = occupied, not hit
		// 3 = occupied, hit

		// if the tile has not been hit, we change the status to hit by adding one
		if (this.grid[charAscii][y] == 0 || this.grid[charAscii][y] == 2) {
			this.grid[charAscii][y]++;
		}
	}

	public int[][] getGrid() {
		return this.grid;
	}
	
	public static void main (String[] args) {
	}
}
