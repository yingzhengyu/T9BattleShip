package controller;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
/**
 * 
 * @author Team 9
 *	This class is for when users presses Start 
 */
public class StartMessage implements Message {
	BlockingQueue<Message> queue = new LinkedBlockingQueue<>();
	/**
	 * Constructor for this class
	 * @param q q is BlockingQueue interface
	 */
	public StartMessage (BlockingQueue<Message> q) {
		queue = q;
	}
	/**
	 * 
	 * @return queue BlockingQueue
	 */
	public BlockingQueue<Message> getQueue() {
		return queue;
	}

}
