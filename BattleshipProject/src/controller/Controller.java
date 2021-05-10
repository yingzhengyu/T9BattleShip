package controller;

import java.util.concurrent.BlockingQueue;

import model.Board;
import model.Tile;
import view.View;

public class Controller {
	BlockingQueue<Message> queue;
	Board gameboard;
	View view;

	public Controller(BlockingQueue<Message> queue, Board gameboard, View view) {
		this.queue = queue;
		this.gameboard = gameboard;
		this.view = view;
	}
	public void mainLoop() {
		while (view.isDisplayable()) {
			Message message = null;
			try {
				message = queue.take();
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			//handle message cases here
			
			if (message.getClass() == AttackMessage.class) {
				AttackMessage attackMessage = (AttackMessage) message;
				Tile tile = attackMessage.getTile();
				tile.attacked();
			}
		}
	}
}
