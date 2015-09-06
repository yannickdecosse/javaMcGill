package Week04;
// Yannick Decosse 260551160
// CCCS-300-781 Programming Techniques 1
// Instructor: Dr. Malleswara Talla
// Sep 23, 2014

// Using While loop to guess number

import java.util.Scanner; 

public class GuessNumber {
  public static void main(String[] args) {
    // Generate a random number to be guessed
    int number = (int)(Math.random() * 101);

    Scanner input = new Scanner(System.in);
    try {
    System.out.println("Guess a magic number between 0 and 100");

    int guess = -1;
    while (guess != number) {
      // Prompt the user to guess the number
      System.out.print("\nEnter your guess: ");
      guess = input.nextInt();

      if (guess == number)
        System.out.println("Yes, the number is " + number);
      else if (guess > number)
        System.out.println("Your guess is too high");
      else
        System.out.println("Your guess is too low");
    } // End of loop
    }
    finally {
    	input.close();
    }
  }
}