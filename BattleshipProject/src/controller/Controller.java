package controller;

import java.awt.Component;
import java.awt.Menu;
import java.awt.Window;
import java.util.concurrent.BlockingQueue;

import model.Board;
import model.Tile;
import view.*;

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
				View view = new View(queue, gameboard.getCurrentPlayer());
				BetweenTurnScreen between = new BetweenTurnScreen(gameboard.getCurrentPlayer(), queue, view);
				Controller controller = new Controller(queue, gameboard, between);
				controller.mainLoop();
			}
			else if (message.getClass() == AttackMessage.class) {
				//View view = (View) window;
				AttackMessage attackMessage = (AttackMessage) message;
				Tile tile = attackMessage.getTile();
				tile.attacked();
			
//				try {
//					Thread.sleep(2000);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
			}
			else if (message.getClass() == SwitchMessage.class) {
				View view = (View) window;
				view.setVisible(false);
				changeTurns(view); 
				BetweenTurnScreen between = new BetweenTurnScreen(gameboard.getCurrentPlayer(), queue, view);
				Controller controller = new Controller(queue, gameboard, between);
				controller.mainLoop();
			}
			else if(message.getClass() == SwitchBoardMessage.class) {
				SwitchBoardMessage sMessage = (SwitchBoardMessage) message;
				View view = sMessage.getView();
				view.setVisible(true);
				((Window) window).dispose();
				Controller controller = new Controller(queue, gameboard, view);
				controller.mainLoop();
				
	
			}
		}
	}
	
	public void changeTurns(View view) {
		this.gameboard.updateCurrentPlayer();
		view.hideGrid(gameboard.getCurrentPlayer());
		view.revealGrid(gameboard.getCurrentPlayer());
	}
}
