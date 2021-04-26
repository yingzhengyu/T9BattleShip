package model;

import view.View;

public class DemoBoard {
	
	public static void main (String[] args) {
		Board gameBoard = new Board();
		View gameView = new View();
		BoardController controller = new BoardController(gameBoard, gameView);
		
		System.out.println("Initial board:");
		controller.updateView();
		
		// Attacking a2:
		controller.action('a',2);
		// Attacking e5:
		controller.action('e', 5);
	}
	

}
