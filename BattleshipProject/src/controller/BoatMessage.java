package controller;

public class BoatMessage implements Message{
	int[] fourTiltBoat = new int [3]; // 0,1,2,3 element so health is 4
	int[] fiveTiltBoat = new int [4];
	
	
	public int[] getFourTiltBoat() {
		return fourTiltBoat;
	}
	public void setFourTiltBoat(int[] fourTiltBoat) {
		this.fourTiltBoat = fourTiltBoat;
	}
	public int[] getFiveTiltBoat() {
		return fiveTiltBoat;
	}
	public void setFiveTiltBoat(int[] fiveTiltBoat) {
		this.fiveTiltBoat = fiveTiltBoat;
	}
	
	
}
