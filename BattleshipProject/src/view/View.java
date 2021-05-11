package view;
 
import java.awt.GridLayout;
import java.util.concurrent.*;
import javax.swing.*;
import controller.Message;
import model.Board;
import model.Tile;
public class View extends JFrame implements Window {
	// Stores a grid of integers to represent the game board
	Tile[][] leftGrid = new Tile[8][8];
	Tile[][] rightGrid = new Tile[8][8];
	JPanel outerPanel = new JPanel(new GridLayout(1,2,60,5));
	JPanel leftPanel = new JPanel();
	JPanel rightPanel = new JPanel();
	BlockingQueue<Message> queue;
	
	public View(BlockingQueue<Message> queue) {
		this.queue = queue;
		
		this.setSize(1400, 1000);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		buildGrids();
		this.setVisible(true);
	}
	
	public void hideGrid(Tile[][] grid) {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				grid[i][j].hide();
			}
		}
	}
	
	private void buildGrids() {

		this.leftPanel.setLayout(new GridLayout(8,8,5,5));
		
		for (int i = 0; i <= 7; i++) {
			for (int j = 0; j <= 7; j++) {
				leftGrid[i][j] = new Tile(this.queue);
				leftPanel.add(leftGrid[i][j]);
			}
		}
		this.outerPanel.add(leftPanel);
		
		this.rightPanel.setLayout(new GridLayout(8,8,5,5));
		
		for (int i = 0; i <= 7; i++) {
			for (int j = 0; j <= 7; j++) {
				rightGrid[i][j] = new Tile(this.queue);
				rightPanel.add(rightGrid[i][j]);
			}
		}
		this.outerPanel.add(rightPanel);
		
		this.add(this.outerPanel);
	}

}