package controller;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class StartMessage implements Message {
	BlockingQueue<Message> queue = new LinkedBlockingQueue<>();
	
	public StartMessage (BlockingQueue<Message> q) {
		queue = q;
	}
	
	public BlockingQueue<Message> getQueue() {
		return queue;
	}

}
