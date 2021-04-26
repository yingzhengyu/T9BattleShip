package model;

import view.View;

public class DemoBoard {
	
	public static void main (String[] args) {
		Board gameBoard = new Board();
		View gameView = new View();
		BoardController controller = new BoardController(gameBoard, gameView);
		
		controller.getGrid()[1][4]=2;
		controller.getGrid()[3][6]=2;
		
		System.out.println("Initial board:");
		controller.updateView();
		
		
		// Attacking a2:
		controller.action('a',2);
		// Attacking e5:
		controller.action('e', 5);
		
		// Attacking b5:
		controller.action('b', 5);
		// Attacking d7:
		controller.action('d', 7);
		
		// no additional changes are made when attacking the same tile multiple times: 
		controller.action('d', 7);
	}
	

}
