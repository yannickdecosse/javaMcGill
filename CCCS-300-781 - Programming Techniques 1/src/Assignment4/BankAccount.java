package Assignment4;
/*
	Name:			Yannick Decosse
	McGill ID:		260551160
	Course ID:		CCCS-300-781 Programming Techniques 1
	Instructor: 	Dr. Malleswara Talla
	Date:			November 18, 2014
	Assignment 4:	Understanding and using Classes, Objects, Methods & Constructors
 */

import java.util.Scanner;

public class BankAccount {

	public static void main(String[] args) {
		
		/* Display welcome message */
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("---               * WELCOME TO BANQUE DES MASCAREIGNES *               ---");
		System.out.println("--------------------------------------------------------------------------");

		/* Set today's interest rate */
		double rate = 4.5;
		Account.setAnnualInterestRate(rate);
		System.out.println("\nToday's interest rate is " + rate + "%");
		
		/* User input first name and last name */
		Scanner customer = new Scanner(System.in);
		
		try {
			System.out.print("\nPlease enter your first name: ");
			while (!customer.hasNext("[A-Za-z]+")) {
				System.out.print("\nError: please enter letters only!");
				customer.nextLine();
			}
				String fName = customer.nextLine(); // Assign Scanner to fName
			
			System.out.print("\nPlease enter your last name: ");
			while (!customer.hasNext("[A-Za-z]+")) {
				System.out.print("\nError: please enter letters only!");
				customer.nextLine();
			}
				String lName = customer.nextLine(); // Assign Scanner to lName
		
				/* Create account using class Account and display information  */
				Account account = new Account (fName, lName, 100);
				account.displayNewlyCreatedAccount();
				
				/* Perform deposits or withdrawal of funds */
				account.transactions();
						
		} // Close customer Scanner
		finally {
			customer.close();
		}

	}

}

