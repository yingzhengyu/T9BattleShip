package model;

import view.View;
// Demo class to simulate attacking different board positions that contain different states (occupied, not occupied, hit, not hit)
public class DemoBoard {
	
	public static void main (String[] args) {
		Board gameBoard = new Board();
		View gameView = new View();
		BoardController controller = new BoardController(gameBoard, gameView);
		
		// 0 = empty, not hit
		// 1 = empty, hit
		// 2 = occupied, not hit
		// 3 = occupied, hit
		
		// setting b5 and d7 tiles to occupied status 
		controller.getGrid()[1][4]=2;
		controller.getGrid()[3][6]=2;
		// Displaying initial board
		System.out.println("Initial board:");
		controller.updateView();
		
		// Simulating attacks on different tiles and printing each iteration using the observer
		// Attacking a2 (empty, not hit):
		controller.action('a',2);
		// Attacking e5 (empty, not hit):
		controller.action('e', 5);
		
		// Attacking b5 (occupied, not hit):
		controller.action('b', 5);
		// Attacking d7 (occupied, not hit):
		controller.action('d', 7);
		
		// no additional changes are made when attacking the same tile multiple times (occupied, hit): 
		controller.action('d', 7);
	}
	

}
