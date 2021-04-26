package model;

import view.View;

public class BoardController {
	
	private Board model;
	private View view;
	
	public BoardController(Board model, View view) {
		this.model = model;
		this.view = view;
	}
	// Calls updateGrid from Board class to update the model, observer automatically updates the view
	public void action(char x, int y) {
		model.updateGrid(x, y);
	}
	
	public int[][] getGrid() {
		return model.getGrid();
	}
	
	public void updateView() {
		view.printGrid(model.getGrid());
	}

}
