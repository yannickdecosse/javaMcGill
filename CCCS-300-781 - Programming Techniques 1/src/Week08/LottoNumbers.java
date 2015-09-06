package Week08;
// Yannick Decosse 260551160
// CCCS-300-781 Programming Techniques 1
// Instructor: Dr. Malleswara Talla
// Oct 21, 2014
// Arrays 1D : Read the ticket numbers from a file and checks whether all numbers are covered

import java.util.Scanner;

public class LottoNumbers {
  public static void main(String args[]) {
    Scanner input = new Scanner(System.in);
    boolean[] isCovered = new boolean[10]; // default false

    // Read all numbers and mark corresponding element covered
    int number = input.nextInt();
    while (number != 0) {
      isCovered[number - 1] = true;
      number = input.nextInt();
    }

    // Check if all covered
    boolean allCovered = true; // Assume all covered
    for (int i = 0; i < 10; i++) 
      if (!isCovered[i]) {
        allCovered = false; // Find one number is not covered
        break;
      } 

    // Display result
    if (allCovered)
      System.out.println("The tickets cover all numbers");
    else
      System.out.println("The tickets don’t cover all numbers");
  } 
}