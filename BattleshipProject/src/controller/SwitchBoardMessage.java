package controller;

import view.View;
/**
 * 
 * @author Team 9
 *	This class uses Message interface
 */
public class SwitchBoardMessage implements Message {
	View view;
	/**
	 * Constructor for this class
	 * @param v View 
	 */
	public SwitchBoardMessage (View v) {
		view = v;
	}
	/**
	 * Returning view
	 * @return View view
	 */
	public View getView() {
		return view;
	}

}
