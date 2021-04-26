package model;

public class Board {
	
	int[][] grid = new int[8][8];
	
	public static void updateGrid(char x, int y) {
		// converting char ascii into integer 1-8
		int charAscii = x;
		charAscii -= 96;
		System.out.println(charAscii);
		
	}

	public int[][] getGrid() {
		return this.grid;
	}
	
	public static void main (String[] args) {
	}
}
