package Elevator.Requests;

public class DcTowerStopOver extends ElevatorRequest{

	//Properties
	static int COUNTER_REQUEST = 1;
	int ID;
		
	//Inherited Constructor with added Properties
	public DcTowerStopOver(int _currentFloor, int _destinationFloor) {
		super(_currentFloor, _destinationFloor);
		this.ID = COUNTER_REQUEST;
		COUNTER_REQUEST++;
		this.direction = Direction.UP;
	}

	//To String method for the Output
	@Override
	public String toString() {
		return "DC Tower Stop Over Request " + ID + " [current floor:" + currentFloor + ", destination floor:"
				+ destinationFloor + ", direction:" + direction + "]";
	}
}
