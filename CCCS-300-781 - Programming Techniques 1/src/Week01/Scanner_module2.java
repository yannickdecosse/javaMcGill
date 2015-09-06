package Week01;
// Yannick Decosse 260551160
// CCCS-300-781 Programming Techniques 1
// Instructor: Dr. Malleswara Talla
// Sep 11, 2014

// Testing the Scanner module with an input radius

import java.util.Scanner;

public class Scanner_module2 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter radius of circle:");
		double radius = input.nextDouble();
		
		double area = radius*radius*3.14159;
		
		System.out.println("Area of circle with radius " + radius + " is " + area);

	}

}
