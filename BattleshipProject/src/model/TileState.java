package model;
/**
 * 
 * @author Team 9
 *	This is a enumerated class for the different Tile states. 
 */
public enum TileState {
	HIDDEN(-1),
	EMPTY_NOT_HIT(0),
	EMPTY_HIT(1),
	OCCUPIED_NOT_HIT(2),
	OCCUPIED_HIT(3),
	DEFEATED(4);
	
	private int Action;
	/**
	 * Constructor for TiltState
	 * @param action Int value
	 */
	private TileState(int action) {
		this.Action = action;
	}
	/**
	 * Getting the action value
	 * @return Action int value
	 */
	public int getAction() {
		return this.Action;
	}
	/**
	 * 
	 * @author Team 9
	 *	Second enumerated class for ship fleet that players user
	 */
	public enum TypeofBoats{
		Carrier(5),
		Battleship(4),
		Crusier(3),
		Submarine(3),
		Destroyer(2);
		
		
		private int size;
		/**
		 * Constructor for TypeofBoats
		 * @param s Integer value
		 */
		private TypeofBoats(int s){
			this.size = s;
		}
		/**
		 * 
		 * @return Integer value
		 */
		public int getSize() {
			return size;
		}
	}
}
