/*
 * Name:		Yannick Decosse
 * Course ID:	CCCS-301-751 - Programming Techniques 2
 * McGill ID:	260551160
 * Instructor: 	Joseph Vybihal
 * Date:		March 2, 2015
 * 
 * Subject:		Assignment 3: Polymorphism, Interfaces & Abstract
 * Details:		Full Container class using Object class
 * File name:	Tester2.java
 * Purpose:		Using Object class to create Full Container for use in a Bank Account system 
 * IDE:			Eclipse v.Luna Standard Edition
 * 
 */

package Question3;

import java.util.Scanner;

public class Tester2
{
	public static void main(String[] args)
	{
		//	Initialize choice for menu options
		int choice = 0;
		//	Initialize 'checkEmpty' to check for empty array
		int checkEmpty = 0;
		String accNumber = "";
		double accBalance = 0;
		
		//	Instantiate a FullContainer object which can contains 5 bank accounts
		ContainerVer1 account = new FullContainer(5);
		
		//	Initialize Scanner objects
		Scanner userChoice = new Scanner(System.in);
		Scanner userBalance = new Scanner(System.in);
		
		while (choice != 7)
		{		
			//	Menu header and menu options
			System.out.println("\n----------------------------------------------------------------------------------------------------------");
			System.out.println("                                           Mascareignes Bank System");
			System.out.println("----------------------------------------------------------------------------------------------------------\n\n");
			System.out.println("1.\tCreate Account");
			System.out.println("2.\tDelete Account");
			System.out.println("3.\tDeposit");
			System.out.println("4.\tWithdraw");
			System.out.println("5.\tGet balance");
			System.out.println("6.\tDuplicate Account");
			System.out.println("7.\tQuit\n");
			System.out.println("----------------------------------------------------------------------------------------------------------\n");
			System.out.print("Please enter your choice: ");
			
			//	Validating input from user
			while (!userChoice.hasNext("[1-7]"))
			{
				System.out.println("\nError! Enter only number 1, 2, 3, 4, 5, 6 or 7 as your choice.");
				System.out.print("Please enter your choice: ");
				userChoice.next();
			}
			choice = Integer.parseInt(userChoice.next());
			
			System.out.println("----------------------------------------------------------------------------------------------------------\n");
			
			
			//	Using switch method for menu option
			switch (choice)
			{
				//	Case 1: Creating an account
				case 1:	System.out.print("\nPlease enter Account Number to create: ");
						accNumber = userChoice.next();
						
						System.out.print("\nPlease enter Account Balance: ");
						
						//	Validating input for balance
						while (!userBalance.hasNext("[0-9.-]+"))
						{
							System.out.println("\nError! Enter only numbers.");
							System.out.print("Please try again: ");
							userBalance.next();
						}
						accBalance = Double.parseDouble(userBalance.next());
						
						if (account.add(new BankAccount(accNumber, accBalance)))
						{
							break;
						}
						
						else if (!account.add(new BankAccount(accNumber, accBalance)))
						{
							System.out.println("\n\t\t\t\tSorry: cannot add more accounts in system!");
							break;
						}
				
						
				//	Case 2: Delete account
				case 2: System.out.print("\nPlease enter Account Number to delete: ");
						accNumber = userChoice.next();
				
						//	Take only Account Number for comparison and delete if found
						if (account.delete(((FullContainer)account).find(new BankAccount(accNumber, 0))))
						{
							System.out.println("\n\t\tAccount number " + accNumber + " has been deleted from our system!");
							break;
						}
						
						else
						{
							System.out.println("\n\t\t\t\tSorry: no such account found in our system!");
							break;
						}
						
						
				//	Case 3: Deposit money in account
				case 3: System.out.print("\nPlease enter Account Number in which to deposit money: ");
						accNumber = userChoice.next();
				
						if (account.get(((FullContainer)account).find(new BankAccount(accNumber, 0))) == null)
						{
							System.out.println("\n\t\t\t\tSorry: no such account found in our system!");
							break;
						}
		
						else
						{
							System.out.print("\nPlease enter amount to deposit: ");
							
							//	Validating input for amount deposited
							while (!userBalance.hasNext("[0-9.-]+"))
							{
								System.out.println("\nError! Enter only numbers.");
								System.out.print("Please try again: ");
								userBalance.next();
							}
							accBalance = Double.parseDouble(userBalance.next());
					
							((BankAccount)account.get(((FullContainer)account).find(new BankAccount(accNumber, 0)))).deposit(accBalance);
							break;
						}
						
						
				//	Case 4: Withdraw money from account
				case 4: System.out.print("\nPlease enter Account Number from which to withdraw money: ");
						accNumber = userChoice.next();
				
						if (account.get(((FullContainer)account).find(new BankAccount(accNumber, 0))) == null)
						{
							System.out.println("\n\t\t\t\tSorry: no such account found in our system!");
							break;
						}
				
						else
						{
							System.out.print("\nPlease enter amount to withdraw: ");
							
							//	Validating input for amount withdrawn
							while (!userBalance.hasNext("[0-9.-]+"))
							{
								System.out.println("\nError! Enter only numbers.");
								System.out.print("Please try again: ");
								userBalance.next();
							}
							accBalance = Double.parseDouble(userBalance.next());
							
							((BankAccount)account.get(((FullContainer)account).find(new BankAccount(accNumber, 0)))).withdrawal(accBalance);
							break;
						}
						
						
				//	Case 5: Get balance of account
				case 5: System.out.print("\nPlease enter Account Number for which to obtain the balance: ");
						accNumber = userChoice.next();
						
						if (account.get(((FullContainer)account).find(new BankAccount(accNumber, 0))) == null)
						{
							System.out.println("\n\t\t\t\tSorry: no such account found in our system!");
							break;
						}
						
						else
						{
							
							((BankAccount)account.get(((FullContainer)account).find(new BankAccount(accNumber, 0)))).getBalance();
							break;
						}
						
						
				//	Case 6: Duplicate an account		
				case 6:	System.out.print("\nPlease enter Account Number to duplicate: ");
						accNumber = userChoice.next();
						
						//	Take only Account Number for comparison
						((FullContainer)account).duplicate(((FullContainer)account).find(new BankAccount(accNumber, 0)));
						break;
			}
		}
		
		
		//	Listing bank account values
		System.out.println("\n----------------------------------------------------------------------------------------------------------");
		System.out.println("                                   Mascareignes Bank System: List of Accounts");
		System.out.println("----------------------------------------------------------------------------------------------------------\n\n");
		

		//	Display accounts in FullContainer
		for (int i = 0; i < 5; i++)
		{
			//	If cell is empty, goto next
			if (account.get(i) == null)
			{
				checkEmpty++;
				continue;
			}
			
			else
			{
				System.out.println("\nAccount at position " + i + " in system:");
				System.out.println("\nAccount number: " + ((BankAccount)account.get(i)).getAccountNumber());
				((BankAccount)account.get(i)).getBalance();
				System.out.println("\n----------------------------------------------------------------------------------------------------------\n\n");
			}
		}
		
		//	If no account found, display message
		if (checkEmpty > 4)
		{
			System.out.println("\t\t\t\tSorry: there is no bank accounts in our system!");
		}
		
		//	Footer
		System.out.println("\n----------------------------------------------------------------------------------------------------------");
		System.out.println("                                           Thank you & goodbye!");
		System.out.println("----------------------------------------------------------------------------------------------------------\n\n");
		
		//	Closing Scanner objects
		userChoice.close();
		userBalance.close();
	}
}
