package controller;

import java.util.concurrent.BlockingQueue;

import javax.swing.text.View;

import model.Board;

public class Controller {
	BlockingQueue<Message> queue;
	Board gameboard;
	View view;
	
	public Controller(BlockingQueue<Message> queue, Board gameboard, View view) {
		this.queue = queue;
		this.gameboard = gameboard;
		this.view = view;
	}
	public void mainLoop() {
		while(view.isDisplayable()) {
			
	
}
