/*
 * Name:		Yannick Decosse
 * Course ID:	CCCS-301-751 - Programming Techniques 2
 * McGill ID:	260551160
 * Instructor: 	Dr. Hang Lau
 * Date:		February 22, 2015
 * 
 * Subject:		Assignment 2: Time-driven simulation program
 * Details:		Constructing a queuing system implementing a clock as a counter
 * File name:	Customer.java
 * Purpose:		Queues & Abstract
 * IDE:			Eclipse v.Luna Standard Edition
 * 
 */

public class Customer extends DataElement
{
	private int customerNumber;
	private int arrivalTime;
	private int waitingTime;
	private int transactionTime;
	
	//	Default constructor
	public Customer()
	{
		customerNumber = 0;
		arrivalTime = 0;
		waitingTime = 0;
		transactionTime = 0;
	}
	
	//	Constructor to initialize the data members
	public Customer(int custN, int aTime, int wTime, int tTime) 
	{
		customerNumber = custN;
		arrivalTime = aTime;
		waitingTime = wTime;
		transactionTime = tTime;
	}
	
	//	Method to set the data members according to the parameters
	public void setCustomerInfo(int custN, int aTime, int wTime, int tTime) 
	{
		customerNumber = custN;
		arrivalTime = aTime;
		waitingTime = wTime;
		transactionTime = tTime;
	}
	
	//	Method to return the waiting time of a customer.
	public int getWaitingTime() 
	{
		return waitingTime;
	}
	
	//	Method to set the waiting time of a customer.
	public void setWaitingTime(int time) 
	{
		waitingTime = time;
	}
	
	//	Method to increment the waiting time.
	public void incrementWaitingTime() 
	{
		waitingTime++;
	}
	
	//	Method to return the arrival time of a customer.
	public int getArrivalTime() 
	{
		return arrivalTime;
	}
	
	//	Method to return the transaction time of a customer.
	public int getTransactionTime() 
	{
		return transactionTime;
	}
	
	//	Method to return the customer number.
	public int getCustomerNumber()
	{
		return customerNumber;
	}
	
	//	Implement equals method provided by DataElement class
	public boolean equals(DataElement otherElement) 
	{
		if (!(otherElement instanceof Customer) || otherElement == null)
		{
			return false;
		}
		
		else if (this == ((Customer)otherElement))
		{
			return true;
		}
		
		else
		{
			return	customerNumber == (((Customer)otherElement).getCustomerNumber()) && 
					arrivalTime == (((Customer)otherElement).getArrivalTime()) &&
					waitingTime == (((Customer)otherElement).getWaitingTime()) &&
					transactionTime == (((Customer)otherElement).getTransactionTime());
		}
	}
	
	//	Implement compareTo method provided by DataELement class
	public int compareTo(DataElement otherElement) 
	{ 
		return (arrivalTime - ((Customer)otherElement).arrivalTime);
	}
	
	//	Copy Customer information from otherElement
	public void makeCopy(DataElement otherElement) 
	{
		customerNumber = ((Customer)otherElement).customerNumber;
		arrivalTime = ((Customer)otherElement).arrivalTime;
		waitingTime = ((Customer)otherElement).waitingTime;
		transactionTime = ((Customer)otherElement).transactionTime;
	}
	
	//	Return a copy of Customer object
	public DataElement getCopy() 
	{
		DataElement element = new Customer(customerNumber, arrivalTime, waitingTime, transactionTime);
		
		return element;
	}
}
