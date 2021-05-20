package BoatTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import model.*;

import org.junit.Test;

import controller.Message;

public class BoatTest {

	@Test
	public void simpleTest() {
		Boat a = new Boat(4,1,1,true);
		
		assertEquals(4,a.getSize());
		assertEquals(1,a.getRow());
		assertEquals(1,a.getColumn());
		assertEquals(true, a.getVert());
		
	}
	
	@Test
	public void boardTest() {
		BlockingQueue<Message> queue = new LinkedBlockingQueue<>();
		
		ArrayList<Boat> p1 = new ArrayList<>();
		ArrayList<Boat> p2 = new ArrayList<>();
			p1.add(new Boat(2,1,1,true));
			p2.add(new Boat(4,2,2,false));
		
		
		
		Board tempBoard = new Board(queue,p1,p2);
		tempBoard.setPlayerBoat(1, p1);
		ArrayList<Boat> btemp = new ArrayList<>();
		btemp = tempBoard.getBoatList(1);
	
		
		assertEquals(btemp.get(0).getSize(),p1.get(0).getSize());
		assertEquals(tempBoard.getCurrentPlayer(),1);
		tempBoard.updateCurrentPlayer();
		assertEquals(tempBoard.getCurrentPlayer(),2);
	}
	
	
	@Test
	public void TileState() {
		BlockingQueue<Message> queue = new LinkedBlockingQueue<>();
		
		Tile tile = new Tile(queue);
		
		tile.setTileState(TileState.EMPTY_NOT_HIT);
		assertEquals(tile.getTileState(),TileState.EMPTY_NOT_HIT);
		tile.attacked();
		
		assertEquals(tile.getTileState(),TileState.EMPTY_HIT);
		
		Tile mysecondTile = new Tile(queue);
		mysecondTile.setTileState(TileState.OCCUPIED_NOT_HIT);
		mysecondTile.attacked();
		assertEquals(mysecondTile.getTileState(),TileState.OCCUPIED_HIT);

	}

}
