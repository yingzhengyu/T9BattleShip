package view;

import java.awt.*;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.concurrent.*;
import javax.swing.*;
import controller.Message;
import model.Board;
import model.Tile;
import model.TileState;
/**
 * 
 * @author Team 9
 * This class displays the game board, 8 x 8 grid board for each player
 */
public class View extends JFrame implements Window {
	// Stores a grid of integers to represent the game board
	int row = 8;
	int column = 8;
	Tile[][] leftGrid = new Tile[row][column];
	Tile[][] rightGrid = new Tile[row][column];
	JPanel outerPanel = new JPanel(new GridLayout(1,2,60,5));
	JPanel leftPanel = new JPanel();
	//JPanel middlePanel = new JPanel();
	JPanel rightPanel = new JPanel();
	BlockingQueue<Message> queue;
	/**
	 * View constructor
	 * @param queue BlockingQueue Interface queue
	 * @param currentPlayer Int value for either player 1 or 2
	 * @param player1 Array of tile for player 1
	 * @param player2 Array of tile for player 2
	 */
	public View(BlockingQueue<Message> queue, int currentPlayer, Tile[][] player1, Tile[][] player2) {
		this.queue = queue;
		
		leftGrid = player1;
		rightGrid = player2;
		

		this.setSize(1600,1000);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		buildGrids();
		// player 1 is active player on turn one 
		this.hideGrid(currentPlayer);
		this.revealGrid(currentPlayer);
		this.setVisible(true);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	    this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
	}

//	public void viewVisible(boolean on) {
//		this.setVisible(());
//	}
	/**
	 * This method is for hiding the tiles when player switches turn to prevent cheating.
	 * @param currentPlayer Int value for either player 1 or 2
	 */
	public void hideGrid(int currentPlayer) {
		if (currentPlayer == 1 ) {
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < column; j++) {
					rightGrid[i][j].hide();
				}
			}
		}
		else if (currentPlayer == 2) {
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < column; j++) {
					leftGrid[i][j].hide();
				}
			}
		}
	}
	/**
	 * This method works like hideGrid but opposite
	 * @param currentPlayer Int value for either player 1 or 2
	 */
	public void revealGrid(int currentPlayer) {
		if (currentPlayer == 1) {
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < column; j++) {
					leftGrid[i][j].reveal();
				}
			}
		}
		else if (currentPlayer == 2) {
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < column; j++) {
					rightGrid[i][j].reveal();
				}
			}
		}
	}

	
	// general method, builds empty tiles
//	private void buildGrids() {
//
//		this.leftPanel.setLayout(new GridLayout(8,8,5,5));
//
//		for (int i = 0; i <= 7; i++) {
//			for (int j = 0; j <= 7; j++) {
//				leftGrid[i][j] = new Tile(this.queue);
//				leftPanel.add(leftGrid[i][j]);
//			}
//		}
//		this.outerPanel.add(leftPanel);
//
//		this.rightPanel.setLayout(new GridLayout(8,8,5,5));
//
//		for (int i = 0; i <= 7; i++) {
//			for (int j = 0; j <= 7; j++) {
//				rightGrid[i][j] = new Tile(this.queue);
//				rightPanel.add(rightGrid[i][j]);
//			}
//		}
//		this.outerPanel.add(rightPanel);
//
//		this.add(this.outerPanel);
//	}

	// temp method to build the pre-set grids
	
	/**
	 * This method is for regenerating the grids cause of the constant changes
	 */
	private void buildGrids() {

		this.leftPanel.setLayout(new GridLayout(8,8,5,5));
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				leftPanel.add(leftGrid[i][j]);
			}
		}
		this.outerPanel.add(leftPanel);
		

		this.rightPanel.setLayout(new GridLayout(8,8,5,5));

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				rightPanel.add(rightGrid[i][j]);
			}
		}
		this.outerPanel.add(rightPanel);
		
		this.add(this.outerPanel);
	}
}