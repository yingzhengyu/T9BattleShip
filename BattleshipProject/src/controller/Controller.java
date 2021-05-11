package controller;

import java.awt.Component;
import java.awt.Menu;
import java.awt.Window;
import java.util.concurrent.BlockingQueue;

import model.Board;
import model.Tile;
import view.View;

public class Controller {
	BlockingQueue<Message> queue;
	Board gameboard;
	view.Window window;

	public Controller(BlockingQueue<Message> queue, Board gameboard, view.Window window) {
		this.queue = queue;
		this.gameboard = gameboard;
		this.window = window;
	}
	public void mainLoop() {
		while (((Component) window).isDisplayable()) {
			Message message = null;
			try {
				message = queue.take();
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			//handle message cases here
			
			if (message.getClass() == StartMessage.class) {
				StartMessage startMessage = (StartMessage) message;
				((Window)window).dispose();
				View view = new View(startMessage.getQueue());
				Controller controller = new Controller(startMessage.getQueue(), gameboard, view);
				controller.mainLoop();
			}
			else if (message.getClass() == AttackMessage.class) {
				AttackMessage attackMessage = (AttackMessage) message;
				Tile tile = attackMessage.getTile();
				tile.attacked();
			}
		}
	}
}
