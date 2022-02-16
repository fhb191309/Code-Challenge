package Elevator.Requests;

public class DcTowerReturn extends ElevatorRequest {
	//Properties
	static int COUNTER_REQUEST = 1;
	int ID;
	
	//Inherited Constructor with added Properties
	public DcTowerReturn(int _currentFloor, int _destinationFloor) {
		super(_currentFloor, _destinationFloor);
		this.ID = COUNTER_REQUEST;
		COUNTER_REQUEST++;
		this.direction = Direction.DOWN;
	}

	//To String method for the Output
	@Override
	public String toString() {
		return "Returning from Floor " + currentFloor + " on DC Tower Exit Request " + ID + " [current floor:" + currentFloor + ", destination floor:"
				+ destinationFloor + ", direction:" + direction + "]";
	}
}
