/*
 * Name:		Yannick Decosse
 * Course ID:	CCCS-301-751 - Programming Techniques 2
 * McGill ID:	260551160
 * Instructor: 	Joseph Vybihal
 * Date:		March 2, 2015
 * 
 * Subject:		Assignment 3: Polymorphism, Interfaces & Abstract
 * Details:		Full Container class using Object class
 * File name:	BankAccount.java
 * Purpose:		Using Object class to create Full Container for use in a Bank Account system 
 * IDE:			Eclipse v.Luna Standard Edition
 * 
 */

package Question3;

public class BankAccount implements Transactions
{
	private String accountNumber;
	private double balance;
	
	//	Default no-args constructor
	BankAccount() {}
	
	//	Constructor with parameters
	BankAccount(String accountNumber, double balance)
	{
		this.accountNumber = accountNumber;
		this.balance = balance;
	}
	
	//	Method to get Account Number
	public String getAccountNumber()
	{
		return accountNumber;
	}
	
	//	Implement deposit method from interface Transactions
	public void deposit(double amount)
	{
		if (amount < 0)
		{
			System.out.println("\nAmount is less than zero: cannot deposit in account!");
			return;
		}
		
		else
		{
			System.out.println("\nAmount deposited is $" + amount);
			balance += (int)(amount * 100) / 100.0;
		}
	}
	
	//	Implement withdrawal method from interface Transactions
	public void withdrawal(double amount)
	{
		//	Checking if amount withdrawn is possible */
		if (amount > 0 && amount <= balance)
		{
			System.out.println("\nAmount withdrawn is $" + amount);
			balance -= (int)(amount * 100) / 100.0;
		}
		
		else if (amount < 0)
		{
			System.out.println("\nPlease do not enter negative amount! Remove '-' operator in front of amount entered.");
		}
		
		else
		{
			System.out.println("You're trying to withdraw amount that is greater than the balance.\nAn overdraft fee will be charged.");
			balance -= (amount + OVERDRAFT);
		}
	}
	
	//	Implement getBalance method from interface Transactions
	public void getBalance()
	{
		System.out.printf("The balance of this account is $%.2f", balance);
	}
	
	//	Override Object equals method, compare only accountNumber
	@Override
	public boolean equals(Object o)
	{
		if (!(o instanceof BankAccount) || o == null)
		{
			return false;
		}
				
		else if (this == o)
		{
			return true;
		}
		
		else
		{
			return accountNumber.equals(((BankAccount)o).getAccountNumber());
		}
		
	}
}
