/*
 * Name:		Yannick Decosse
 * Course ID:	CCCS-301-751 - Programming Techniques 2
 * McGill ID:	260551160
 * Instructor: 	Joseph Vybihal
 * Date:		March 2, 2015
 * 
 * Subject:		Assignment 3: Polymorphism, Interfaces & Abstract
 * Details:		Full Container class using Object class
 * File name:	Transactions.java
 * Purpose:		Using Object class to create Full Container for use in a Bank Account system 
 * IDE:			Eclipse v.Luna Standard Edition
 * 
 */

package Question3;

public interface Transactions 
{
	public static final double OVERDRAFT = 5.00;
	
	//	Method to deposit values greater than zero in account
	public void deposit(double amount);
	
	//	Method to retrieve values greater than zero and less than balance
	//	in account. If values is greater than balance, user is charged 
	//	an overdraft fee and balance become negative
	public void withdrawal(double amount);
	
	//	Method to display the current balance of the account
	public void getBalance();
}
