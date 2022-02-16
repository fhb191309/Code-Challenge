package Elevator;

public class Elevator {
	//Properties
	static int ELEVATOR_ID = 1;
	final static int MIN_FLOOR = 0;
	final static int MAX_FLOOR = 55;
	int ID;
	int currentFloor;
	boolean isAvailable = true;
	boolean isDriving = false;

	//Constructor
	public Elevator(int _currentFloor) {
		this.ID = ELEVATOR_ID;
		ELEVATOR_ID++;
		this.currentFloor = _currentFloor;
	}

	//Getters and Setters for this class
	public int getCurrentFloor() {
		return currentFloor;
	}

	public void setCurrentFloor(int currentFloor) {
		this.currentFloor = currentFloor;
	}
	
    public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public boolean isDriving() {
		return isDriving;
	}

	public void setDriving(boolean isDriving) {
		this.isDriving = isDriving;
	}

	public void addRequest() {
		
	}

	//To String method for the Output
	@Override
	public String toString() {
		return "Elevator " + ID + " [currentFloor=" + currentFloor + ", isAvailable=" + isAvailable + ", isDriving=" + isDriving + "]";
	}
    
    
	
	
}
