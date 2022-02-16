package Elevator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import Elevator.Requests.DcTowerEntry;
import Elevator.Requests.DcTowerReturn;
import Elevator.Requests.DcTowerStopOver;
import Elevator.Requests.Direction;
import Elevator.Requests.ElevatorRequest;

public class Main_ElevatorControl {

	//Properties
	static DcTowerEntry dcTowerEntry;
	static DcTowerReturn dcTowerReturn;
	static DcTowerStopOver dcTowerStopOver;
	static int requestCounter;
	static Scanner scanner = new Scanner(System.in);
	static ArrayList<Elevator> allElevators = new ArrayList<Elevator>();
	static Queue<ElevatorRequest> request_Queue = new LinkedList<ElevatorRequest>();
	
	//Creating all 7 Elevators
	public static void createElevators() {
		for (int i = 0; i < 7; i++) {
			allElevators.add(new Elevator(0));
		}
		
		for(Elevator elevator : allElevators) {
			System.out.println(elevator.toString());
		}
	}
	
	/**
	 * This method adds new requests to the Queue
	 * IF requests are not valid the User will be notified
	 * via an error message
	 * @param currentFloor
	 * @param destinationFloor
	 */
	public static void addRequest(int currentFloor, int destinationFloor) {
		
		if(currentFloor == 0 && destinationFloor <= 55) {
			dcTowerEntry = new DcTowerEntry(currentFloor, destinationFloor);
			request_Queue.add(dcTowerEntry);
			System.out.println(dcTowerEntry.toString());
		}else if (currentFloor > 0 && currentFloor <= 55 && destinationFloor == 0) {
			dcTowerReturn = new DcTowerReturn(currentFloor, destinationFloor);
			request_Queue.add(dcTowerReturn);
			System.out.println(dcTowerReturn.toString());
		}else if (currentFloor > destinationFloor){
			dcTowerStopOver = new DcTowerStopOver(currentFloor, destinationFloor);
			dcTowerStopOver.setDirection(Direction.DOWN);
			System.out.println(dcTowerStopOver.toString());
		}else if (currentFloor < destinationFloor){
			dcTowerStopOver = new DcTowerStopOver(currentFloor, destinationFloor);
			dcTowerStopOver.setDirection(Direction.UP);
			System.out.println(dcTowerStopOver.toString());
		}else {
			System.err.println("Value of current floor or destination floor invalid");
		}
		
//		for (ElevatorRequest elevatorRequest : request_Queue) {
//			System.out.println(elevatorRequest.toString());
//		}
	}

	/**
	 * This method checks for available elevators depending on the requests in the queue
	 * To simulate the movement of the elevators the destination floors from the 
	 * requests will be set as current floor of the new elevators after each round.
	 * 
	 * IF elevators are available requests will be removed after setting the current floor
	 * of the elevator
	 * 
	 * IF no elevators are available the request will stay in the queue
	 * 
	 */
	public static void checkAvailableElevators() {
		int requestedElevators = 0;
		
		while(requestedElevators > 0) {
			for (int i = 0; i < allElevators.size(); i++) {
				if(allElevators.get(i).isAvailable) {
					requestedElevators++;
					allElevators.get(i).setCurrentFloor(request_Queue.element().getDestinationFloor());
					request_Queue.poll();
					allElevators.get(i).setAvailable(false);
					allElevators.get(i).setDriving(true);
					System.out.println("Elevator requests: " + requestedElevators);
				}else if (!allElevators.get(i).isAvailable) {
					requestedElevators--;
					allElevators.get(i).setAvailable(true);
					allElevators.get(i).setDriving(false);
					System.out.println("Elevators requests: " + requestedElevators);
				}
				
			}
			break;
		}
		
	}
	
	
	/**
	 * This method checks if the Elevator Control System is still running
	 * User will be notified according to given Input
	 * @param _alive
	 */
	public static void checkStatus(String _alive) {
		String alive = _alive;
		
		if(alive.equals("run")) {
			System.out.println("Elevator Control still running...");
		}else {
			System.err.println("Elevator Control terminated");
		}
	}
	
	/*
	 * TEST:
	 * 
	 * Testing if new addRequests work
	 * Testing if checking for available Elevators works
	 */
	
	public static void main(String[] args) {
		String isAlive = "run";
		
		allElevators.clear();
		System.out.println("Creating Elevators...");
		createElevators();
		
		System.out.println("------------------------------------------------------------");

		while(isAlive.equals("run")) {
			System.out.println("Enter current floor:");
			int currentFloor = scanner.nextInt();
			
			System.out.println("Enter destination floor:");
			int destinationFloor = scanner. nextInt();
			
			addRequest(currentFloor, destinationFloor);
			
			System.out.println("---------------------------------------------------------");
			
			System.out.println("Enter current floor:");
			int currentFloor1 = scanner.nextInt();
			
			System.out.println("Enter destination floor:");
			int destinationFloor1 = scanner. nextInt();
			
			addRequest(currentFloor1, destinationFloor1);
			
			System.out.println("---------------------------------------------------------");
			
			checkAvailableElevators();
			
			System.out.println("---------------------------------------------------------");
			
			System.out.println("Enter current floor:");
			int currentFloor2 = scanner.nextInt();
			
			System.out.println("Enter destination floor:");
			int destinationFloor2 = scanner. nextInt();
			
			addRequest(currentFloor2, destinationFloor2);
			
			System.out.println("---------------------------------------------------------");
			
			System.out.println("run or stop?");
			isAlive = scanner.next();
			
			checkStatus(isAlive);
			
			System.out.println("---------------------------------------------------------");
			
		}
		
		
	}

}
