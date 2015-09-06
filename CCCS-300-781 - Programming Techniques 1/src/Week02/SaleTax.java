package Week02;
// Yannick Decosse 260551160
// CCCS-300-781 Programming Techniques 1
// Instructor: Dr. Malleswara Talla
// Sep 16, 2014

// Calculate Sales Tax

import java.util.Scanner;

public class SaleTax {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    try {
    System.out.print("Enter purchase amount: ");
    double purchaseAmount = input.nextDouble();
    
    double tax = purchaseAmount * 0.06;
    System.out.println("Sales tax is " + (int)(tax * 100) / 100.0);
    }
    finally {
		input.close(); //close output to prevent Resource Leak
	}
  }
}