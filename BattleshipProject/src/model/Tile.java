package model;

import java.awt.event.*;
import java.util.concurrent.BlockingQueue;

import javax.swing.*;

import controller.AttackMessage;
import controller.Message;

public class Tile extends JButton implements ActionListener {

	ImageIcon redHitIcon;
	ImageIcon blackHitIcon;
	ImageIcon redOIcon; // O = OCCUPIED
	ImageIcon blackOIcon;
	ImageIcon blankIcon;
	BlockingQueue<Message> queue;


	TileState state = TileState.EMPTY_NOT_HIT; // default state
	TileState placeholderState = TileState.EMPTY_NOT_HIT; // this is used when hiding the tile to remember its true state before setting state to hidden

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

	public void setTileState(TileState newState) {
		this.state = newState;
		this.placeholderState = newState;
		this.updateIcon(newState);
	}

	public TileState getTileState() {
		return this.state;
	}

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

	public void updateIcon(TileState currentState) {
		switch (currentState) {
		case EMPTY_NOT_HIT:
			this.setIcon(blankIcon);
			break;

		case EMPTY_HIT:
			this.setIcon(redHitIcon);
			break;
			
		case OCCUPIED_NOT_HIT:
			this.setIcon(blackOIcon);
			break;
			
		case OCCUPIED_HIT:
			this.setIcon(redOIcon);
			break;
			
		case HIDDEN:
			this.setIcon(blankIcon);
			break;
		}
	}

	public void hide() {
		if (this.state == TileState.EMPTY_NOT_HIT|| this.state == TileState.OCCUPIED_NOT_HIT) {
			this.placeholderState = this.state;
			this.updateIcon(TileState.HIDDEN);
		}
	}

	public void reveal() {
		this.setTileState(placeholderState);
	}
}
