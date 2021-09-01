//Christopher Morris 
// Date 8/29/2021
//Program Name: Morris_Drone
//Program used to control drone and maneuver it up, down, forwards, backwards, and allow it turn left or right. The program will also be able to display the position of the drone and the cardinal direction it is currently facing based on how many times the drone has rotated and in what direction it rotated.

package drone;

import java.util.Scanner;

public class Morris_Drone {

	public static class Drone1 {
		private int x; // forwards or backwards
		private int y; // turn left or right
		private int z; // up or down
		
		public Drone1() {
			x = 0;
			y = 0;
			z = 0;
			
		}
		
		//Parameter for Drone1
		public Drone1(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
			
		}
		//commands to move drone and turn it. These are called by the main method to control the drone. This uses a numerical value (1, 2, 3, etc.) as a way to show position and direction of the drone.
		public void moveUp() {
			z++;
			System.out.println("Drone moved upwards.");
		}

		public void moveDown() {
			z--;
			System.out.println("Drone moved downwards.");
		}
		
		public void moveForward() {
			x++;
			System.out.println("Drone moved forwards.");
		}
		
		public void moveBackward() {
			x--;
			System.out.println("Drone moved backwards.");
		}
		
		public void turnLeft() {
			y++;
			System.out.println("Drone turned left.");
		}
		
		public void turnRight() {
			y--;
			System.out.println("Drone turned right.");
		}
		
		//This is called by the main method to show the current position of the drone and what it is facing. The orientation of the drone uses the value attached to the turning position of the drone to determine if the drone is facing north, east, south, or west. This program currently has a limit to how many turns the drone can do before it does not return a value. 
		
		public void displayPosition() {
			System.out.println("Drone's current position is: ");
			System.out.println("x = " + x);
			System.out.println("y = " + y);
			System.out.println("z = " + z);
			if (y == -8 || y == -4 || y == 0 || y == 4 || y == 8 || y == 12 || y == 16)
				System.out.println("orientation = North");
			else if (y == -11 || y == -7 || y == -3 || y == 1 || y == 5 || y == 9 || y == 13)
				System.out.println("orientation = East");
			else if (y == -10 || y == -6 || y == -2 || y == 2 || y == 6 || y == 10 || y == 14)
				System.out.println("orientation = South");
			else if (y == -9 || y == -5 || y == -1 || y == 3 || y == 7 || y == 11 || y == 15)
				System.out.println("orientation = West");				
		}
	}
	
	//main method which will display the menu and ask the user to choose an option which will allow the drone to react and move accordingly.
	
	public static void main(String[] args) {

		Drone1 drone = new Drone1(0, 0, 0);
		
		drone.displayPosition();
		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		int menu;
		
		// basic menu using cases to show options that the user can choose.
		
		while (true) {
			System.out.print("Which direction would you like to move the drone? \n1. Move up one unit. \n2. Move down one unit. \n3. Move forwards one unit. \n4. Move backwards one unit. \n5. Turn left one unit. \n6. Turn right one unit. \n7. Display Position. \n8. Exit Navigation. \n Choose an option: ");

			menu = input.nextInt();
			
			switch(menu) {
			
			case 1:
				drone.moveUp();
				break;
			case 2:
				drone.moveDown();
				break;
			case 3:
				drone.moveForward();
				break;
			case 4:
				drone.moveBackward();
				break;
			case 5:
				drone.turnLeft();
				break;
			case 6:
				drone.turnRight();
				break;
			case 7:
				drone.displayPosition();
				break;
			case 8:
				System.out.println("Exiting the Navigation Menu.");
				return;
			}
		}
	}
}