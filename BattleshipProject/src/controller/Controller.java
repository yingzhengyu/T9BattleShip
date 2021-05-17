package controller;

import java.awt.Component;
import java.awt.Menu;
import java.awt.Window;
import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import model.Board;
import model.Boat;
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
				((Window)window).dispose();
				View view = new View(queue, gameboard.getCurrentPlayer(), gameboard.getGrid(1), gameboard.getGrid(2));
				BetweenTurnScreen between = new BetweenTurnScreen(gameboard.getCurrentPlayer(), queue, view);
				Controller controller = new Controller(queue, gameboard, between);
				controller.mainLoop();
			}
			
			else if (message.getClass() == AttackMessage.class) {
				//View view = (View) window;
				AttackMessage attackMessage = (AttackMessage) message;
				Tile tile = attackMessage.getTile();
				tile.attacked();
				if (gameboard.checkVictory()) {
					try {
						message = new VictoryMessage();
						queue.put(message);
					}
					catch (InterruptedException exception) {
						exception.printStackTrace();
					}
				}
				else {
					try {
						message = new SwitchMessage();
						queue.put(message);
					}
					catch (InterruptedException exception) {
						exception.printStackTrace();
					}
				}
			
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
			
			else if(message.getClass() == VictoryMessage.class){
				((Window)window).dispose();
				Victoryscreen victory = new Victoryscreen(gameboard.getCurrentPlayer(), queue);
				Controller controller = new Controller(queue, gameboard, victory);
				controller.mainLoop();
				
			}
			
			else if(message.getClass() == MenuMessage.class) {
				((Window) window).dispose();
				BlockingQueue<Message> queue = new LinkedBlockingQueue<>();
				ArrayList<Boat> p1 = new ArrayList<>();
				ArrayList<Boat> p2 = new ArrayList<>();
				Boat boat1 = new Boat(4,0,0,true);
				Boat boat2 = new Boat(3,0,5,false);
				Boat boat3 = new Boat(2,5,0,false);
				Boat boat4 = new Boat(4,0,0,false);
				Boat boat5 = new Boat(3,5,1,true);
				Boat boat6 = new Boat(2,2,4,true);
				p1.add(boat1);
				p1.add(boat2);
				p1.add(boat3);
				p2.add(boat4);
				p2.add(boat5);
				p2.add(boat6);
			
				Board board = new Board(queue, p1, p2);		
				MenuInterface menu = new MenuInterface(queue);
				Controller controller = new Controller(queue, board, menu);
				controller.mainLoop();
			}
			else if (message.getClass() == QuitMessage.class) {
				((Window) window).dispose();
			}
		}
	}
	
	public void changeTurns(View view) {
		this.gameboard.updateCurrentPlayer();
		view.hideGrid(gameboard.getCurrentPlayer());
		view.revealGrid(gameboard.getCurrentPlayer());
	}
}
