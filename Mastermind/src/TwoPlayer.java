import java.util.ArrayList;
import java.util.Scanner;

public class TwoPlayer {
	
	static Scanner input = new Scanner(System.in);
 
	public static ArrayList<String> guesses;
	public static ArrayList<String> results;
	public static String combo;
	public static String value; 
	public static int counter;
	public static boolean winner;
	
	public static void play() throws InterruptedException {

		guesses = new ArrayList<>(); //lists are initialized 
		results = new ArrayList<>();
		counter = 1; winner = false; 
		
		System.out.println("\nYou have chosen TWO PLAYER MODE");
		
		System.out.println("\nPlease enter the number of turns to play with:");		
		
		while(!input.hasNextInt()) { //loop until input is correct
			System.out.println("Turns must be an integer:");
		    input.next();
		}
		int turns = input.nextInt();
		
		createCombo(); //player one makes up combination
		
		while (counter <= turns) { //loop until counter goes over
			
			value = "";	//reset value very time		
			playerGuess(); playerCheck(); //player goes, check for matches		
			
			if (value.equals("BBBBB")) { //if win, break the loop and set winner
				winner = true;
				break;
			}	
			
			counter++;
		}
		
		if (winner) 
			System.out.println("You have cracked the code in " + counter + " turn(s)!");
		
		else {
			System.out.println("\nPlayer one has stumped you! Better luck next time!");
			
			System.out.print("Code: "); //reveal combination
			for (int i = 0; i <= 4; i++) 
			  	System.out.print(combo);
		}
		
		input.nextLine(); input.nextLine();
	}
	
	/** METHOD FOR PLAYER TO ENTER COMBINATION **/
	public static void createCombo() {
		
		System.out.println("Player one, please enter combination to use "
				+ "(player two should not be looking):");
		
		combo = input.next();
		
		while (!isValid(combo)) //loop until player enters valid guess	
			combo = input.next();	

		for(int clear = 0; clear < 200; clear++) 
			System.out.println("\n") ;
	}
	
	/** METHOD FOR PLAYER TURN **/
	public static void playerGuess() {
		
		while (true) {
			System.out.println("TURN " + counter + " - Player two, please enter your combination (Q to quit, R to view records):");
			String choice = input.next();
			
			if (choice.toUpperCase().equals("Q")) { //stop if enters Q
				System.out.println("So long and thanks for all the fish!");
				System.exit(1);
			}
			
			else if (choice.toUpperCase().equals("R")) 
				viewRecords();
			
			else {
				
				while (!isValid(choice)) //loop until player enters valid guess	
					choice = input.next();	
				
				for (int i = 0; i <= 4; i++) //add guess to character array list
					guesses.add(choice.toUpperCase());	
				
				break;
			}
		}
	}	
	
	/** METHOD TO VIEW STORED RECORDS **/
	public static void viewRecords() {	
		
		if (!guesses.isEmpty()) {			
			for (int i = 0; i <= counter - 2; i++) {				
				System.out.println((i++) + " - CODE: " + guesses.get(i) 
					+ " | RESULT: " + results.get(i));
			}
		}
		
		else
			System.out.println("No records to be found!");
	}
	
	/** METHOD TO FIND MATCHES **/
	public static void playerCheck() {
		
		while (true) {
		
			System.out.println("Player one, please give your results (C to check code): ");
			
			value = input.next();	
			
			if (value.toUpperCase().equals("C")) //stop if enters Q
				System.out.println("Code: " + combo);	
			
			else {
				while (!isCheckValid()) //loop until player enters valid result	
					value = input.next();
					value = value.toUpperCase();
					
				results.add(value);
				break;
			}
		}
		
		for(int clear = 0; clear < 200; clear++) 
			System.out.println("\n") ;
	}
	
	/** METHOD TO ASK IF INPUT IS VALID **/
	public static boolean isValid(String choice) {
		
		if (choice.length() == 5) { //length must be 5 
			
			for (int i = 0; i < choice.length(); i++) {
				
				char n = Character.toUpperCase(choice.charAt(i)); //for each character in choice

				if (!(n >= 'A' && n <= 'G')) { //ask if it is A-G
					System.out.println("Only letters A-G are acceptable:");
					return false;
				}
			}
			
	        return true;
		}
		
		else {
			System.out.println("The combination must be 5 letters in length:");
			return false;	
		}
	}
	
	/** METHOD FOR CHECKING IF RESULTS ARE VALID **/
	public static boolean isCheckValid() {
		
		if (value.length() <= 5) { //length must be 5 
			
			for (int i = 0; i < value.length(); i++) {
				
				char n = Character.toUpperCase(value.charAt(i)); //for each character in choice

				if (!(n == 'B' || n == 'W')) { //ask if it is A-G
					System.out.println("Only B, W, or nothing is acceptable:");
					return false;
				}
			}
			
	        return true;
		}
		
		else {
			System.out.println("The results must be no more than 5 letters in length:");
			return false;	
		}
	}
}