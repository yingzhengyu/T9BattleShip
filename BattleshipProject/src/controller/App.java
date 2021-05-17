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
}
