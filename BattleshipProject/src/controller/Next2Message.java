package controller;

import java.util.ArrayList;

import model.Boat;
/**
 * 
 * @author Team 9
 * Utilizing Message Interface
 */
public class Next2Message implements Message{
	ArrayList<Boat> p2 = new ArrayList<>();
	/**
	 * Class constructor
	 * @param temp Arraylist of Boat
	 */
	public Next2Message(ArrayList<Boat> temp) {
		p2 = temp;
	}
	/**
	 * Returning Arraylist
	 * @return ArrayList of Boat
	 */
	public ArrayList<Boat> getBoat(){
		return p2;
	}
}