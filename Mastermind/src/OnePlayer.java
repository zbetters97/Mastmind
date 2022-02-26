import java.util.ArrayList;
import java.util.Scanner;

public class OnePlayer {
	
	static Scanner input = new Scanner(System.in);
 
	public static ArrayList<Character> tempCombo; //lists are made to store combinations
	public static ArrayList<Character> compCombo;
	public static ArrayList<Character> playCombo;
	public static int counter;
	public static String value; 
	public static boolean winner;
	
	public static void play() throws InterruptedException {
		
		tempCombo = new ArrayList<>(); compCombo = new ArrayList<>(); 
		playCombo = new ArrayList<>(); //lists are initialized 
		counter = 1; winner = false; 
		
		System.out.println("\nYou have chosen ONE PLAYER MODE");
		
		System.out.println("\nPlease enter the number of turns to play with:");		
		
		while(!input.hasNextInt()) { //loop until input is correct
			System.out.println("Turns must be an integer:");
		    input.next();
		}
		int turns = input.nextInt();
		
		compGo(); //computer makes up combination
		
		while (counter <= turns) { //loop until counter goes over
			
			value = "";	//reset value very time
			compCombo.clear(); compCombo.addAll(tempCombo);	//reset combination list every time
			
			playerTurn(); checkBlack(); //player goes, check for matches		
			
			if (value.equals("BBBBB")) { //if win, break the loop and set winner
				winner = true;
				break;
			}	
			
			checkWhite(); //if not, check matches
			playCombo.clear(); //clear list for next round
			
			System.out.println("You receive: " + value);
			counter++;
		}
		
		if (winner) //if player won
			System.out.println("You have beaten the computer in " + counter + " turn(s)!");
		
		else {
			System.out.println("\nThe computer has stumped you! Better luck next time!");
			
			System.out.print("Code: "); //reveal combination
			for (int i = 0; i <= 4; i++) 
			  	System.out.print(tempCombo.get(i));
		}
		
		input.nextLine(); input.nextLine();
	}
	
	/** METHOD FOR COMPUTER TO GENERATE COMBINATION **/
	public static void compGo() {
		
		for (int i = 0; i <= 4; i++) {
			
			char letter = 'O'; //temp variable setter
			
			int num = 1 + (int) (Math.random() * ((6 - 1) + 1)); //random number 1-6

			switch (num) { //number corresponds to letter
				case 1: letter = 'A'; break;
				case 2: letter = 'B'; break;
				case 3: letter = 'C'; break;
				case 4: letter = 'D'; break;
				case 5: letter = 'E'; break;
				case 6: letter = 'F'; break;
				case 7: letter = 'G'; break;
			}
			
			tempCombo.add(letter); //add letters to list
		}
	}
	
	/** METHOD FOR PLAYER TURN **/
	public static void playerTurn() {
		
		System.out.println("TURN " + counter + " - Please enter your combination (Q to quit):");
		String choice = input.next();
		
		if (choice.toUpperCase().equals("Q")) { //stop if enters Q
			System.out.println("So long and thanks for all the fish!");
			System.exit(1);
		}
		
		else {	
			while (!isValid(choice)) //loop until player enters valid guess	
				choice = input.next();	
		}

		for (int i = 0; i <= 4; i++) //add guess to character arraylist
			playCombo.add(Character.toUpperCase(choice.charAt(i)));	
		
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
	
	/** METHODS TO FIND MATCHES **/
	public static void checkBlack() {
		
		int i = 0;

		while (i < compCombo.size()) { //no for loop because i doesn't always increment 
			
			if (compCombo.get(i).equals(playCombo.get(i))) { //if spots match, remove that spot	
				
				compCombo.remove(i); playCombo.remove(i);
				value += "B"; //and give B to the list
			}
			
			else
				i++; //only increment if spots do not match
		}
	}
	
	public static void checkWhite() {
		
		for (Character i : playCombo) { //loop for each spot in player combo
			
			for (int a = 0; a < compCombo.size(); a++) { 
				
				if (i.equals(compCombo.get(a)))	{ //if player spot matches any, give W...
					value += "W";						//...and stop inner loop
					break;
				}
			}
		}
	}
}