import java.util.Scanner;

public class MazeGame {
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("**************************************************");
		System.out.println("************  Welcome to Crazy Maze!  ************");
		System.out.println("**************************************************\n");
		
		System.out.println("Ali is staying the night at his friend's house.\nHe is really really hungry.\n" +
							"Please guide him to the kitchen.\nThen guide him back to his bed room.");
		
		int currentRoom = 1;
		int doorSelection = 0;
		
		boolean reachedKitchen = false;
		boolean kitchenMessage = false;
		
		while(true) {
			
			System.out.println("\n**************************************************");
			
			System.out.println("\nYou are in Room " + currentRoom + ".");
			
			System.out.print("\nEnter a door number you want to open: ");
			doorSelection = input.nextInt();
			
			if(currentRoom == 1) {
				
				if(doorSelection == 1) {
					currentRoom = 3;
				}else if(doorSelection == 2) {
					currentRoom = 8;
				}else {
					System.out.println("\nThis door is locked. Try again!");
				}
				
			}else if(currentRoom == 2) {
				
				if(doorSelection == 1) {
					currentRoom = 1;
					
					if(reachedKitchen == true) {
						break;
					}
					
				}else if(doorSelection == 2) {
					currentRoom = 3;
				}else if(doorSelection == 3) {
					currentRoom = 6;
				}else {
					System.out.println("\nThis door is locked. Try again!");
				}
				
			}else if(currentRoom == 3) {
				
				if(doorSelection == 1) {
					currentRoom = 2;
				}else if(doorSelection == 2) {
					currentRoom = 6;
				}else {
					System.out.println("\nThis door is locked. Try again!");
				}
				
			}else if(currentRoom == 4) {
				
				if(doorSelection == 1) {
					currentRoom = 5;
				}else if(doorSelection == 2) {
					currentRoom = 9;
					
					if(kitchenMessage == false) {
						
						System.out.println("\n**************************************************");
						
						System.out.println("\nCongratulations! You have successfully guided Ali to the Kitchen.");
						System.out.println("\nNow try to guide him back to his bedroom.");
						
						reachedKitchen = true;
						kitchenMessage = true;
					}
					
				}else {
					System.out.println("\nThis door is locked. Try again!");
				}
				
			}else if(currentRoom == 5) {
				
				if(doorSelection == 1) {
					currentRoom = 4;
				}else if(doorSelection == 2) {
					currentRoom = 6;
				}else {
					System.out.println("\nThis door is locked. Try again!");
				}
				
			}else if(currentRoom == 6) {
				
				if(doorSelection == 1) {
					currentRoom = 2;
				}else if(doorSelection == 2) {
					currentRoom = 3;
				}else if(doorSelection == 3) {
					currentRoom = 5;
				}else {
					System.out.println("\nThis door is locked. Try again!");
				}
				
			}else if(currentRoom == 7) {
				
				if(doorSelection == 1) {
					currentRoom = 2;
				}else {
					System.out.println("\nThis door is locked. Try again!");
				}
				
			}else if(currentRoom == 8) {
				
				if(doorSelection == 1) {
					currentRoom = 1;
					
					if(reachedKitchen == true) {
						break;
					}
					
				}else if(doorSelection == 2) {
					currentRoom = 5;
				}else if(doorSelection == 3) {
					currentRoom = 7;
				}else {
					System.out.println("\nThis door is locked. Try again!");
				}
				
			}else {
				
				if(doorSelection == 1) {
					currentRoom = 4;
				}else {
					System.out.println("\nThis door is locked. Try again!");
				}
				
			}
			
		}
		
		System.out.println("\n**************************************************");
		
		System.out.println("\nCongratulations! You have successfully guided Ali back to his room.");
		System.out.println("\nThanks for playing!");
		
		System.out.println("\n**************************************************");
		System.out.println("****************  Game Finished!  ****************");
		System.out.println("**************************************************");
		
	}
	
}
