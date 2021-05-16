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
public class View extends JFrame implements Window {
	// Stores a grid of integers to represent the game board
	//int currentPlayer = 1;
	Tile[][] leftGrid = new Tile[8][8];
	Tile[][] rightGrid = new Tile[8][8];
	JPanel outerPanel = new JPanel(new GridLayout(1,2,60,5));
	JPanel leftPanel = new JPanel();
	//JPanel middlePanel = new JPanel();
	JPanel rightPanel = new JPanel();
	BlockingQueue<Message> queue;

	public View(BlockingQueue<Message> queue, int currentPlayer) {
		this.queue = queue;

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
	
	public void hideGrid(int currentPlayer) {
		if (currentPlayer == 1 ) {
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					rightGrid[i][j].hide();
				}
			}
		}
		else if (currentPlayer == 2) {
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					leftGrid[i][j].hide();
				}
			}
		}
	}

	public void revealGrid(int currentPlayer) {
		if (currentPlayer == 1) {
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					leftGrid[i][j].reveal();
				}
			}
		}
		else if (currentPlayer == 2) {
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
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
	private void buildGrids() {

		this.leftPanel.setLayout(new GridLayout(8,8,5,5));

		for (int i = 0; i <= 7; i++) {
			for (int j = 0; j <= 7; j++) {
				leftGrid[i][j] = new Tile(this.queue);
				if (i <= 3 && j == 0) {
					leftGrid[i][j].setTileState(TileState.OCCUPIED_NOT_HIT);
				}
				else if (i == 0 && j > 5) {
					leftGrid[i][j].setTileState(TileState.OCCUPIED_NOT_HIT);
				}
				else if (i == 5  && j < 3) {
					leftGrid[i][j].setTileState(TileState.OCCUPIED_NOT_HIT);
				}
				
				leftPanel.add(leftGrid[i][j]);
			}
		}
		this.outerPanel.add(leftPanel);
		

		this.rightPanel.setLayout(new GridLayout(8,8,0,0));

		for (int i = 0; i <= 7; i++) {
			for (int j = 0; j <= 7; j++) {
				rightGrid[i][j] = new Tile(this.queue);
				if (i == 1 && j <= 3) {
					rightGrid[i][j].setTileState(TileState.OCCUPIED_NOT_HIT);
				}
				else if (i > 5 && j == 1) {
					rightGrid[i][j].setTileState(TileState.OCCUPIED_NOT_HIT);
				}
				else if (i >= 2 && i < 5  && j == 4) {
					rightGrid[i][j].setTileState(TileState.OCCUPIED_NOT_HIT);
				}
				rightPanel.add(rightGrid[i][j]);
			}
		}
		this.outerPanel.add(rightPanel);
		
		this.add(this.outerPanel);
	}
}