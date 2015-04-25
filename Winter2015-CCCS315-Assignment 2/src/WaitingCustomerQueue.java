/*
 * Name:		Yannick Decosse
 * Course ID:	CCCS-301-751 - Programming Techniques 2
 * McGill ID:	260551160
 * Instructor: 	Dr. Hang Lau
 * Date:		February 28, 2015
 * 
 * Subject:		Assignment 2: Time-driven simulation program
 * Details:		Constructing a queuing system implementing a clock as a counter
 * File name:	WaitingCustomerQueue.java
 * Purpose:		Queues & Abstract
 * IDE:			Eclipse v.Luna Standard Edition
 * 
 */

public class WaitingCustomerQueue extends CirArrayQueue
{
	//	Default constructor: this will call CirArrayQueue no-args constructor
	public WaitingCustomerQueue() {}
	
	//	Constructor with parameter queue size
	public WaitingCustomerQueue(int size)
	{
		super(size);
	}
	
	//	Copy constructor
	public WaitingCustomerQueue(WaitingCustomerQueue otherQ)
	{
		super(otherQ);
	}
	
	//	Method to increment the waiting time of each customer in the queue by one time unit.
	//	Postcondition: The waiting time of each customer in the queue is incremented by one time unit.
	public void updateWaitingQueue()
	{
		super.incrementQueueWaitingTime();
	}
	
	//	Method to get number of elements in queue
	public int getQueueElements()
	{
		return super.getCount();
	}
}
