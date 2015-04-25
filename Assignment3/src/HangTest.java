/*
	Name:			Yannick Decosse
	McGill ID:		260551160
	Course ID:		CCCS-300-781 Programming Techniques 1
	Instructor: 	Dr. Malleswara Talla
	Date:			November 1, 2014
	Assignment 3:	using Arrays and Loops to create Hangman game (Guess a word)
 */

import java.util.Scanner;
import java.util.Arrays;

public class HangTest {
	
	public static void main(String[] args) {
		
		/* Display Welcome  message */
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("|                     * Welcome to the HANGMAN Game *                    |");
		System.out.println("--------------------------------------------------------------------------\n\n");
		
		/* Player 1 enter word to guess */
		System.out.print("Player 1: Please enter word to guess: ");
		
		Scanner key = new Scanner(System.in);
		try {
				
			while (!key.hasNext("[A-Za-z]+")) { // Check that user input are only characters
				System.out.println("Error: please enter letters only!");
				key.next();
			}
				
			String input = key.next();
			char[] guessWord = input.toUpperCase().toCharArray(); // Store input word to guess to array guessWord
			BlankLines.hideWord("",20); // Call hideWord sub-routine to print 20 blank lines
			
		
			/* Player 2 has 10 tries to guess word */
			char[] tryGuess = new char[guessWord.length]; // Assign same length as char Array guessWord
				for (int i = 0; i < tryGuess.length; i++) {
					tryGuess[i] = '*';// Fill array with '*' to display to Player 2
				}
			
			/* Create an array to display the 26 letters of the alphabet */
			char[] alphabet = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
			char[] tryWord = new char[tryGuess.length]; // Create tryWord array to word with 'Enter a letter at a time' option
			int counter;
			
			/* tempWord array is used to check for possibility of than 1 of the same letter in a word */
			char[] tempWord = new char[guessWord.length];
				for (int i = 0; i < guessWord.length; i++) {
					tempWord[i] = guessWord[i]; // Copy content of guessWord to tempWord: used to check if a word has more than 1 same letter
				}
				
			System.out.println("Player 2, please proceeed: ");
			/* Main loop: Give a maximum of 10 possibilities to guess a word */
			for (counter = 10; counter > 0 && !Arrays.equals(tryWord, guessWord) && !Arrays.equals(tryGuess, guessWord); counter--) { // Counter for number of tries
				
				/* Initialize all Counter variables*/
				int countLetter = 0;
				int letterCount = 0;
				int zCount = 0; 
				
				/* Choose between entering entire word or a letter at a time */
				System.out.print("\nWord to guess: ");
				System.out.print(tryGuess);
				System.out.print(" " + "(" + counter + " guess(es) left)");
				System.out.print("\nPress 'Y' to guess entire word or 'N' to enter one character only :");
			
				Scanner guess = new Scanner(System.in);
					
					
					while (!guess.hasNext("[y||n||Y||N]")) { // Check that user input is only 'Y' or 'N'
						System.out.println("Error: please enter 'Y' or 'N' only!");
						guess.next();
					}
					
					String answer = guess.next(); // assign choice to variable answer
					
					/* ------------------------------------------------------------------------------------- */
					/* CHOICE IS TO GUESS ENTIRE WORD */
					/* ------------------------------------------------------------------------------------- */
					if (answer.equals("Y") || answer.equals("y")) {  // if choice is "Y" or "y"
						
						/* Display the alphabet array: is updated when a letter of the alphabet is used by removing it from array */
						System.out.print("Letter(s) available: ");
						for (int i = 0; i < alphabet.length; i++) {
							System.out.print(alphabet[i]);
							System.out.print(" ");
						}
						
						/* Possibility to enter the entire word at any stage */
						System.out.print("\nEnter entire word to solve the puzzle: ");
						Scanner wholeGuess = new Scanner(System.in);
						
						
						while (!wholeGuess.hasNext("[A-Za-z]+")/* || wholeGuess.next().length() != input.length()*/) { // Check that user input is only 'Y' or 'N'
							System.out.println("Error: please enter characters only!");
							wholeGuess.next();
						} 
						
						String entireWord = wholeGuess.next().toUpperCase();
						tryWord = entireWord.toCharArray();

						/* Check if entire word entered is equal to word to guess */ 
						boolean compare=Arrays.equals(tryWord, guessWord);
							if (compare) 
								break;
							else
								System.out.println("Sorry: your answer is wrong! Try again.");
					}
					
					else {
						
						/* ------------------------------------------------------------------------------------- */
						/* CHOICE IS TO GUESS ONLY A LETTER */
						/* ------------------------------------------------------------------------------------- */
						if (answer.equals("N") || answer.equals("n")) { // Option chosen is to enter a letter at a time
							
							System.out.print("Letter(s) available: ");
								for (int i = 0; i < alphabet.length; i++) {
									System.out.print(alphabet[i]);
									System.out.print(" ");
								}
							
								System.out.print("\nEnter a letter: ");
								Scanner enterAletter = new Scanner(System.in);
								
									
								char checkLetter = ' ';
								String z = "";
								while (letterCount == 0 && z != ("[A-Za-z]")) { // Check that user input are only characters
									
									z = enterAletter.next().toUpperCase();
									char b = z.charAt(0);
									checkLetter = b;
									
									for (int i = 0; i < alphabet.length; i++) {
										
										if (alphabet[i] == b)
											letterCount++;
									}
									if (letterCount == 0)
										System.out.println("Error: letter already used. Try again!");
								}
								
								 // Convert String from Scanner input to char for comparison with char[] arrays
								
								///////////////////////////////////////////////////////////////////////////
								/* Check if letter has already been used */
								
									/* Error message if letter has already been used */
									/*if (letterCount == 0) {*/
										
										/* zCount++; // */
									/*}*/
									
								///////////////////////////////////////////////////////////////////////////
								/* Calculate no of occurrence of letter entered in word to guess */
								for (int i = 0; i < tempWord.length; i++) {
									if (tempWord[i] == checkLetter) {
										countLetter++;
									}
								}
								
								/* If a letter entered is found in word to guess, but have more than 1 occurrence */
								if (countLetter > 1) {
									for (int i = 0; i < tempWord.length; i++) {
										if (tempWord[i] == checkLetter) {
											tryGuess[i] = checkLetter;
											tempWord[i] = '*';
											break;
										}
									}
								}
								
								/* If a letter entered is found in word to guess */
								if (countLetter == 1) {
									for (int i = 0; i < tempWord.length; i++) {
										if (tempWord[i] == checkLetter) {
											tryGuess[i] = checkLetter;
											tempWord[i] = '*';
										}
									}
								
									for (int j = 0; j < alphabet.length; j++) {
										if (alphabet[j] == checkLetter) {
											alphabet[j] = '*';
										}
									}
								}
								
								/* If a letter entered is not found in word to guess */
								if (countLetter == 0) {
									int localCount = 0;
									for (int i = 0; i < guessWord.length; i++) {
										if (guessWord[i] == checkLetter) {
											localCount++;
										}
									}
									if (localCount == 0 && zCount == 0)		
									System.out.println("Error: letter not found in word to guess. Try again!");
									for (int j = 0; j < alphabet.length; j++) {
										if (alphabet[j] == checkLetter) {
											alphabet[j] = '*';
										}
									}
								}	 
						} // Close 'if choice is N' option
						
					} // Close Else
					
			} // Close Main loop
		
			
		/* Success  message */
		if (counter != 0) {
			System.out.println("--------------------------------------------------------------------------");
			System.out.print("HOW SMART!\nYou guessed the word \"");
			
			System.out.print(guessWord);
			System.out.print("\" in ");
			System.out.print(11 - counter);
			System.out.print(" guess(es)");
			System.out.println("\nTHANK YOU AND GOODBYE...");
			System.out.println("--------------------------------------------------------------------------\n\n");
		}
			else {
				/*Failure  message */
				System.out.println("\n--------------------------------------------------------------------------");
				System.out.print("Sorry: You failed to guess the word \"");
				System.out.print(guessWord);
				System.out.println("\"\nGOODBYE FOR NOW. TRY AGAIN LATER...");
				System.out.println("--------------------------------------------------------------------------\n\n");
			}

		} // Close Try for key Scanner
		finally { key.close(); }  // Close key Scanner
		
	}
}
