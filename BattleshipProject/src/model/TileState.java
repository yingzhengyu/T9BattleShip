package model;

public enum TileState {
	HIDDEN(-1),
	EMPTY_NOT_HIT(0),
	EMPTY_HIT(1),
	OCCUPIED_NOT_HIT(2),
	OCCUPIED_HIT(3),
	DEFEATED(4);
	
	private int Action;
	
	private TileState(int action) {
		this.Action = action;
	}
	public int getAction() {
		return this.Action;
	}
	
	public enum TypeofBoats{
		Carrier(5),
		Battleship(4),
		Crusier(3),
		Submarine(3),
		Destroyer(2);
		
		
		private int size;
		
		private TypeofBoats(int s){
			this.size = s;
		}
		
		public int getSize() {
			return size;
		}
	}
}
