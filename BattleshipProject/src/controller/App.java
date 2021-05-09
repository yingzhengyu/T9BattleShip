package controller;

import java.util.concurrent.*;

import model.Board;
import view.View;

public class App {
	public static void main(String[] args) {
		BlockingQueue<Message> queue = new LinkedBlockingQueue<>();
		Board board = new Board();
		View view = new View(queue);
		Controller controller = new Controller(queue, board, view);
		controller.mainLoop();
	}
}
