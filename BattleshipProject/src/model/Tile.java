package model;

import java.awt.event.*;
import java.util.concurrent.BlockingQueue;

import javax.swing.*;

import controller.AttackMessage;
import controller.Message;
import controller.SwitchMessage;
import controller.VictoryMessage;
/**
 * 
 * @author Team 9
 *	This class is every individual element in the grid game board. 
 */
public class Tile extends JButton implements ActionListener {

	ImageIcon redHitIcon;
	ImageIcon blackHitIcon;
	ImageIcon redOIcon; // O = OCCUPIED
	ImageIcon blackOIcon;
	ImageIcon blankIcon;
	BlockingQueue<Message> queue;


	TileState state = TileState.EMPTY_NOT_HIT; // default state
	TileState placeholderState = TileState.EMPTY_NOT_HIT; // this is used when hiding the tile to remember its true state before setting state to hidden
/**
 * Constructor for Tile that uses local image to display what is populated
 * @param queue queue from BlockingQueue interface
 */
	public Tile(BlockingQueue<Message> queue) {
		this.queue = queue;
		redHitIcon = new ImageIcon(".\\Images\\redx.png");
		blackHitIcon = new ImageIcon(".\\Images\\blackx.png");
		blackOIcon = new ImageIcon(".\\Images\\blacko.png");
		redOIcon = new ImageIcon(".\\Images\\redo.png");
		blankIcon = new ImageIcon(".\\Images\\whitebg.png");
		this.setIcon(blankIcon);
		this.addActionListener(this);
	}
/**
 * This method takes an actionevent which would be a click of the mouse when user selects a tile.
 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// test, just flips the colors back and forth on button press
		//		if (this.getIcon() == redHitIcon) {
		//			this.setIcon(blackHitIcon);
		//		}
		//		else if (this.getIcon() == blackHitIcon){
		//			this.setIcon(redHitIcon);
		//		}
		try {
			Message message = new AttackMessage(this);
			queue.put(message);
		}
		catch (InterruptedException exception) {
			exception.printStackTrace();
		}
	}
/**
 * This method changes the tile state
 * @param newState Enumerated type containing fixed constants
 */
	public void setTileState(TileState newState) {
		this.state = newState;
		this.placeholderState = newState;
		this.updateIcon(newState);
	}
/**
 * This method returns the Tile's state
 * @return Tile's state
 */
	public TileState getTileState() {
		return this.state;
	}
/**
 * This method is for setting the tile to either empty or hit when a player attacks a tile
 * @return tile state 
 */
	// called when this tile is attacked
	public TileState attacked() {
		switch (state) {
		case EMPTY_NOT_HIT:
			this.setTileState(TileState.EMPTY_HIT);
			break;

		case OCCUPIED_NOT_HIT:
			this.setTileState(TileState.OCCUPIED_HIT);
			break;
		}
		return this.state;
	}
/**
 * This method is for updating the tile picture when there are changes
 * @param currentState
 */
	public void updateIcon(TileState currentState) {
		switch (currentState) {
		case EMPTY_NOT_HIT:
			this.setIcon(blankIcon);
			break;

		case EMPTY_HIT:
			this.setIcon(redHitIcon);
			this.setEnabled(false);
			this.setDisabledIcon(redHitIcon);
			break;
			
		case OCCUPIED_NOT_HIT:
			this.setDisabledIcon(blackOIcon);
			this.setIcon(blackOIcon);
			break;
			
		case OCCUPIED_HIT:
			this.setIcon(redOIcon);
			this.setEnabled(false);
			this.setDisabledIcon(redOIcon);
			break;
			
		case HIDDEN:
			this.setIcon(blankIcon);
			break;
		}
	}
/**
 * This method is for hiding tile spaces when there is a switch in turns
 */
	public void hide() {
		if (this.state == TileState.EMPTY_NOT_HIT|| this.state == TileState.OCCUPIED_NOT_HIT) {
			this.placeholderState = this.state;
			this.updateIcon(TileState.HIDDEN);
			this.setEnabled(true);
		}
	}
/**
 * This method is for revealing the tile grid back to user
 */
	public void reveal() {
		this.setTileState(placeholderState);
		this.setEnabled(false);
	}
}
