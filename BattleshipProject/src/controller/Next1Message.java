package controller;

import java.util.ArrayList;

import model.Boat;
/**
 * 
 * @author Team 9
 *	Utilizing Message interface
 */
public class Next1Message implements Message{
	ArrayList<Boat> p1 = new ArrayList<>();
	/**
	 * Class constructor
	 * @param temp ArrayList of Boat type
	 */
	public Next1Message(ArrayList<Boat> temp) {
		p1 = temp;
	}
	/**
	 * Returning Boat list
	 * @return ArrayList of Boat
	 */
	public ArrayList<Boat> getBoat(){
		return p1;
	}

}
