package controller;

import java.util.concurrent.*;

import model.Board;
import view.*;


public class App {
	public static void main(String[] args) {
		BlockingQueue<Message> queue = new LinkedBlockingQueue<>();
		Board board = new Board();
		Menu menu = new Menu(queue);
		Controller controller = new Controller(queue, board, menu);
		controller.mainLoop();
	}
}
