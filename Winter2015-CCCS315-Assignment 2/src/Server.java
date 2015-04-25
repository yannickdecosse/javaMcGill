/*
 * Name:		Yannick Decosse
 * Course ID:	CCCS-301-751 - Programming Techniques 2
 * McGill ID:	260551160
 * Instructor: 	Dr. Hang Lau
 * Date:		February 22, 2015
 * 
 * Subject:		Assignment 2: Time-driven simulation program
 * Details:		Constructing a queuing system implementing a clock as a counter
 * File name:	Server.java
 * Purpose:		Queues & Abstract
 * IDE:			Eclipse v.Luna Standard Edition
 * 
 */

public class Server
{
	private Customer currentCustomer;
	 // Value of 'status' is “free” or “busy”
	private String status;
	private int transactionTime;
	
	//	Default constructor
	public Server() 
	{
		status = "free";
		currentCustomer = new Customer();
		transactionTime = 0;
	}
	
	//	Method to determine whether a server is free.
	public boolean isFree() 
	{
		return (status == "free") ? true : false;
	}
	
	//	Method to set the status of a server to "busy".
	public void setBusy() 
	{
		status = "busy";
	}
	
	//	Method to set the status of a server to "free".
	public void setFree() 
	{
		status = "free";
	}
	
	//	Method to set the transaction time according to the parameter t.
	public void setTransactionTime(int t) 
	{
		transactionTime = t;
	}
	
	//	Method to set the transaction time according to customer’s time.
	public void setTransactionTime() 
	{
		transactionTime = currentCustomer.getTransactionTime();
	}
	
	//	Method to return the remaining transaction time.
	public int getRemainingTransactionTime() 
	{
		return transactionTime;
	}
	
	//	Method to decrease the transaction time by 1.
	public void decreaseTransactionTime() 
	{
		transactionTime--;
	}
	
	//	Method to set the current customer info according to cCustomer.
	public void setCurrentCustomer(Customer cCustomer) 
	{
		currentCustomer.setCustomerInfo(cCustomer.getCustomerNumber(), cCustomer.getArrivalTime(), cCustomer.getWaitingTime(), cCustomer.getTransactionTime());
	}
	
	//	Method to return the customer number of the current customer.
	public int getCurrentCustomerNumber() 
	{
		return currentCustomer.getCustomerNumber();
	}
	
	//	Method to return the arrival time of the current customer.
	public int getCurrentCustomerArrivalTime() 
	{
		return currentCustomer.getArrivalTime();
	}
	
	//	Method to return the current waiting time of the current customer.
	public int getCurrentCustomerWaitingTime() 
	{
		return currentCustomer.getWaitingTime();
	}
	
	//	Method to return the transaction time of the current customer.
	public int getCurrentCustomerTransactionTime() 
	{
		return currentCustomer.getTransactionTime();
	}
}
