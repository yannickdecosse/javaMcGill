package Week01;
// Yannick Decosse 260551160
// CCCS-300-781 Programming Techniques 1
// Instructor: Dr. Malleswara Talla
// Sep 1, 2014

// Testing the Scanner module with an Average calculation

import java.util.Scanner;

public class Scanner_module {
	public static void main (String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter three numbers:");
		double NumberOne = input.nextDouble();
		double NumberTwo = input.nextDouble();
		double NumberThree = input.nextDouble();		
		double average = (NumberOne + NumberTwo + NumberThree) / 3;
		
		System.out.println("The average of " + NumberOne + "," + NumberTwo + "," + NumberThree + " is " + average);
	}
}