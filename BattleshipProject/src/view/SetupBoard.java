//package view;
//
//import java.awt.GridLayout;
//import java.util.concurrent.BlockingQueue;
//import java.util.concurrent.LinkedBlockingQueue;
//
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//
//import controller.Message;
//import model.Boat;
//import model.Tile;
//
//public class SetupBoard extends JFrame implements Window {
//	Tile[][] grid = new Tile[8][8];
//	JPanel gridPanel = new JPanel();
//	JPanel boatPanel = new JPanel();
//	Boat b1 = new Boat("ship1", 3 );
//	BlockingQueue<Message> queue;
//	
//	public SetupBoard(BlockingQueue<Message> queue) {
//		
//		this.setSize(700, 500);
//		this.setResizable(false);
//		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
//		
//		
//		this.gridPanel.setLayout(new GridLayout(8,8,5,5));
//		gridPanel.setSize(500,500);
//
//		for (int i = 0; i < 8; i++) {
//			for (int j = 0; j < 8; j++) {
//				grid[i][j] = new Tile(this.queue);
//				gridPanel.add(grid[i][j]);
//			}
//		}
//		this.add(gridPanel);
//		this.setVisible(true);
//	}
//	
//
//	 public static void main(String[] args) {
//		 BlockingQueue<Message> queue = new LinkedBlockingQueue<>();
//		 SetupBoard s = new SetupBoard(queue);
//	    }
//
//}
