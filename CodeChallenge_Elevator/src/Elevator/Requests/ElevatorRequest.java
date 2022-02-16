package Elevator.Requests;

public class ElevatorRequest {
	//Properties
	final static int MIN_FLOOR = 0;
	final static int MAX_FLOOR = 55;
	int currentFloor;
	int destinationFloor;
	Direction direction;
	
	//Constructor
	public ElevatorRequest(int _currentFloor, int _destinationFloor) {
		this.currentFloor = _currentFloor;
		this.destinationFloor = _destinationFloor;
	}

	//Getters and Setters for this class
	public int getCurrentFloor() {
		return currentFloor;
	}

	public void setCurrentFloor(int _currentFloor) {
		this.currentFloor = _currentFloor;
	}

	public int getDestinationFloor() {
		return destinationFloor;
	}

	public void setDestinationFloor(int _destinationFloor) {
		this.destinationFloor = _destinationFloor;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction _direction) {
		this.direction = _direction;
	}

	//To String method for the Output
	@Override
	public String toString() {
		return "ElevatorRequest [current floor:" + currentFloor + ", destination floor=" + destinationFloor
				+ ", direction:" + direction + "]";
	}
	
	
	
	
}
