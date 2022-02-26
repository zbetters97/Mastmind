import java.util.Scanner;

public class Instructions {
	
	static Scanner input = new Scanner (System.in);
	
	public static void instructions() {
		
		System.out.println("\nABOUT:\n\nThis game is called Mastermind.\n\n"
				
				+ "This is a computer only version of the game 'Mastermind.'\n\n"
			
				+ "There is assigned one code maker and one code breaker.\n"
				+ "In ONE PLAYER MODE, the computer is the code maker and the player is the code breaker.\n"
				+ "In TWO PLAYER MODE, it is decided between the players who is the code maker and who is the code breaker.\n\n"
				
				+ "By selecting letters A-G, the code maker will come up with a 5 "
				+ "letter sequence (nothing more, nothing less).\n\t"
				+ "(For example: it may use the sequence 'ABCDB' or 'DBFEC').\n"
				+ "The code maker is allowed to use multiple letters in the same sequence.\n\t"
				+ "(For example: it may use the sequence 'AABBC' or 'DDDCE').\n\n"
				
				+ "The code breaker must type in a sequence he/she thinks the code maker has come up with.\n\n"
				
				+ "If a letter that they used is used in the code maker's sequence, the code breaker gets a 'W.'\n\t"
				+ "(For example: MAKER SEQUENCE - 'ABFED', BREAKER SEQUENCE - 'EFCCG', BREAKER RECEIVES - 'WW'\n\t"
				+ "since both code maker and code breaker have 'E' and 'F').\n\n"
				
				+ "If a letter that they used is in the computer's sequence AND is"
				+ " in the correct spot, they get a 'B.'\n\t"
				+ "(For example: MAKER SEQUENCE - 'GABFE', BREAKER SEQUENCE - 'CACDE', BREAKER RECEIVES - 'BB'\n\t"
				+ "since 'A' and 'E' are in the same spots).\n\n"
				
				+ "The code breaker, if applicable, will always receive 'B' before 'W.'\n\t"
				+ "(For example: MAKER SEQUENCE - 'GABFE', BREAKER SEQUENCE - 'ABEFC', BREAKER RECEIVES - 'BBWW'\n\t"
				+ "since 'A' and 'E' are in the same spots and code breaker and code maker have 'E' and 'F').\n\n"
				
				+ "If the code maker makes a sequence consisting of multiple letters, the player will receive\n"
				+ "either one 'B' or one 'W' corrosponding to each letter matched.\n\t"
				+ "(For example: MAKER SEQUENCE - 'DDABB', BREAKER SEQUENCE - 'DCFFG', BREAKER RECEIVES - 'B'\n\t"
				+ "since the code breaker has only put down one 'D.'\n\n"
				
				+ "The breaker is given a specified number of tries to guess the sequence.\n"
				+ "If the breaker guesses the sequence (gets 'BBBBB'), the breaker wins.\n"
				+ "If the breaker cannot guess the sequence in the limited number of tries, the maker wins.\n\n"
				
				+ "\nHIT THE ENTER KEY TO EXIT INSTRUCTIONS");
		
		input.nextLine();
	}
}