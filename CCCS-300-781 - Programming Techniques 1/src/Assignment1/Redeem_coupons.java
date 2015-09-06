package Assignment1;
/*	Assignment 1
	Written by: Yannick Decosse (260551160)
	Purpose: Working with arithmetic operators
	Class: CCCS 300
	Instructor: Dr. Malleswara Talla
	Date: Sep 13, 2014
*/

/*	a. There is one input, which is the number of coupons to redeem
	b. There are three outputs, which are first, the # of Candy bars won, # of free Video Games won and the remaining coupons
	c. 
		Start program
			Declare variable "coupon" as Integer
			Declare variable "candy" as Integer
			Declare variable "free_games" as Integer			
			Declare variable "remainingCoupons" as Integer
			
			Prompt user to enter number of coupons and store to variable "coupon"
				Divide "coupon" by 5 and store to variable "candy"
				Store remainder of "coupon" / 5 to variable "remainingCoupons"
				Divide "remainingCoupons" by 3 and store to variable "free_games"
				Store remainder of "free_games" / 3 to "remainingCoupons"

			Display	message to user on # of Candy bars, Free Video Games won, and # of coupons left by using values assigned to the variables
		End of program
	d. If user enters 16, 16 / 5 is 3, remainder is 1, cannot be divided by 3: therefore, message display 3 Candy bars, 0 Free Video Games and 1 coupon left. If user enters
	   2, 2 / 5 is 0, remainder is 2 / 3, is also 0 and remainder is 2: therefore, message display 0 Candy Bars, 0 Free Games and 2 coupons left.
*/
// ------------------------------------------------------------------------------------------------------------------------------------------

import java.util.Scanner;

public class Redeem_coupons {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		try { //used to prevent Resouce Leak with Scanner
			System.out.println ("Welcome to the Coupons Redeem System");
			System.out.println ("");
			System.out.print("Please enter number of coupons: ");
		
			int coupons = input.nextInt(); // Enter number of coupons
			int candy = coupons / 5; // Divide coupons by 5 to get # of candy bars
			int remainingCoupons = coupons % 5; // Store remainder in variable remainingCoupons
			int free_games = remainingCoupons / 3; // Divide remainingCoupons by 3 to get # of free games
			remainingCoupons = remainingCoupons % 3;// Replace value of remainingCoupons with new value with remainder of remainingCoupons divided by 3
				
			System.out.println ("");
			System.out.println("With your coupons, you can have " + candy + " Candy Bar/s, " + free_games + " Free Game/s and have " + remainingCoupons + " coupons left."); //display results
			System.out.println("");
			System.out.println("Thank you for using our system.");
		} 
		finally {
			input.close(); //close output to prevent Resource Leak
		}
	}
}
