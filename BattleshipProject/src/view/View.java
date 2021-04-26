package view;
 
import model.Board;
public class View {
	// Stores a grid of integers to represent the game board
	int[][] grid = new int[8][8];
	
	public static void printGrid(int[][] grid) {
		// iterates over every element of the array and prints with proper formatting 
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println("");
		}
		System.out.println("");
	}
	
	
	public static void main (String[] args) {
		printGrid(new int[8][8]);
	}

}