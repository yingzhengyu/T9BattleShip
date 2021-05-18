package controller;

import java.util.ArrayList;
import java.util.concurrent.*;

import model.Board;
import model.Boat;
import view.*;


public class App {
	public static void main(String[] args) {
		BlockingQueue<Message> queue = new LinkedBlockingQueue<>();
		ArrayList<Boat> p1 = new ArrayList<>();
		ArrayList<Boat> p2 = new ArrayList<>();
	
		Board board = new Board(queue, p1, p2);		
		MenuInterface menu = new MenuInterface(queue);
		Controller controller = new Controller(queue, board, menu);
		controller.mainLoop();
	}
}
