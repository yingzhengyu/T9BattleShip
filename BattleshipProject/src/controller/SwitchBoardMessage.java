package controller;

import view.View;

public class SwitchBoardMessage implements Message {
	View view;
	
	public SwitchBoardMessage (View v) {
		view = v;
	}
	
	public View getView() {
		return view;
	}

}
