package view;
 
import java.awt.GridLayout;
import java.util.concurrent.*;
import javax.swing.*;
import controller.Message;
import model.Board;
import model.Tile;
public class View extends JFrame {
	// Stores a grid of integers to represent the game board
	Tile[][] grid = new Tile[8][8];
	JPanel panel = new JPanel();
	BlockingQueue<Message> queue;
	
	public View(BlockingQueue<Message> queue) {
		this.queue = queue;
		
		buildGrid();
	}
	
	private void buildGrid() {
		this.setSize(1000, 1000);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.panel.setLayout(new GridLayout(8,8));
		
		for (int i = 0; i <= 7; i++) {
			for (int j = 0; j <= 7; j++) {
				grid[i][j] = new Tile();
				panel.add(grid[i][j]);
			}
		}
		this.add(panel);
		this.setVisible(true);
	}

}