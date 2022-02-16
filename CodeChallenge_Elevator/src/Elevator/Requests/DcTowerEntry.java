package Elevator.Requests;

public class DcTowerEntry extends ElevatorRequest {
	//Properties
	static int COUNTER_REQUEST = 1;
	int ID;
	
	//Inherited Constructor with added Properties
	public DcTowerEntry(int _currentFloor, int _destinationFloor) {
		super(_currentFloor, _destinationFloor);
		this.ID = COUNTER_REQUEST;
		COUNTER_REQUEST++;
		this.direction = Direction.UP;
	}

	//To String method for the Output
	@Override
	public String toString() {
		return "DC Tower Entry Request " + ID + " [current floor:" + ElevatorRequest.MIN_FLOOR + ", destination floor:"
				+ destinationFloor + ", direction:" + direction + "]";
	}
	
}
