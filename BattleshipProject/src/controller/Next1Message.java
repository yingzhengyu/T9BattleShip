package controller;

import java.util.ArrayList;

import model.Boat;

public class Next1Message implements Message{
	ArrayList<Boat> p1 = new ArrayList<>();
	
	public Next1Message(ArrayList<Boat> temp) {
		p1 = temp;
	}
	
	public ArrayList<Boat> getBoat(){
		return p1;
	}

}
