package controller;

import java.util.ArrayList;

import model.Boat;

public class Next2Message implements Message{
	ArrayList<Boat> p2 = new ArrayList<>();
	
	public Next2Message(ArrayList<Boat> temp) {
		p2 = temp;
	}
	
	public ArrayList<Boat> getBoat(){
		return p2;
	}
}