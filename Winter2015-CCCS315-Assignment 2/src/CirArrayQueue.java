/*
 * Name:		Yannick Decosse
 * Course ID:	CCCS-301-751 - Programming Techniques 2
 * McGill ID:	260551160
 * Instructor: 	Dr. Hang Lau
 * Date:		February 28, 2015
 * 
 * Subject:		Assignment 2: Time-driven simulation program
 * Details:		Constructing a queuing system implementing a clock as a counter
 * File name:	CirArrayQueue.java
 * Purpose:		Queues & Abstract
 * IDE:			Eclipse v.Luna Standard Edition
 * 
 */

public class CirArrayQueue
{
	private int maxQueueSize;
	// Number of elements in the queue
	private int count; 
	private int queueFront;
	private int queueRear;
	//	Array of references to the objects that store queue elements
	private DataElement[] list; 

	//	Default constructor, creates a queue of default size 100
	public CirArrayQueue() 
	{
		list = new DataElement[100];
		maxQueueSize = 100;
		queueFront = 0;
		queueRear = 0;
		count = 0;
	}
	
	//	Constructor with a parameter
	public CirArrayQueue(int queueSize) 
	{
		list = new DataElement[queueSize];
		maxQueueSize = queueSize;
		queueFront = 0;
		queueRear = 0;
		count = 0;
	}
	
	//	Copy constructor
	public CirArrayQueue(CirArrayQueue otherQueue) 
	{
		maxQueueSize = otherQueue.maxQueueSize;
		list = new DataElement[maxQueueSize];

		for (int i = 0; i < maxQueueSize; i++)
		{
			if (otherQueue.list[i] != null)
			{
				list[i] = otherQueue.list[i];
			}
		}
		
		queueFront = otherQueue.queueFront;
		queueRear = otherQueue.queueRear;
		count = otherQueue.count;
	}
	
	//	Method to initialize the queue to an empty state.
	public void initializeQueue()
	{
		for (int i = 0; i < list.length; i++)
		{
			list[i] = null;
		}

		queueFront = 0;
		queueRear = 0;
		count = 0;

	}
	
	//	Method to determine whether the queue is empty.
	public boolean isEmpty()
	{
		return (queueFront == queueRear || count == 0) ? true : false;
	}
	
	//	Method to determine whether the queue is full.
	public boolean isFull()
	{
		return ((queueRear - queueFront) == -1 || (queueRear - queueFront) == (maxQueueSize - 1) || count == maxQueueSize) ? true : false;
	}
	
	//	Method to return the first element of the queue.
	public DataElement peekFront()
	{
		if (!isEmpty() && list[queueFront] != null)
		{
			return list[queueFront];
		}
		
		else
		{
			System.out.println("***Sorry: the queue is actually empty!");
			return null;
		} 
	}
	
	//	Method to return the last element of the queue.
	public DataElement peekRear()
	{
		if (!isEmpty() && list[queueRear] != null)
		{
			return list[queueRear];
		}
		
		else
		{
			System.out.println("***Sorry: the queue is actually empty!");
			return null;
		}
	}
	
	//	Method to add queueElement to the rear of the queue.
	public void enqueue(DataElement queueElement)
	{
		if (isFull())
		{
			System.out.println("***Sorry: the queue is actually full. Cannot add more customers!");
		}
		
		else
		{
			list[queueRear] = queueElement;
			count++;
			
			if (count != maxQueueSize)
			{
				queueRear = (queueRear + 1) % maxQueueSize;
			}
		}
	}
	
	//	Method to remove the first element of the queue.
	public void dequeue()
	{
		if (isEmpty())
		{
			System.out.println("***Sorry: the queue is actually empty!");
		}
		
		else
		{
			list[queueFront] = null;
			count--;
			queueFront = (queueFront + 1) % maxQueueSize;
		}	
	}
	
	//	Method to make a copy of otherQueue.
	public void copyQueue(CirArrayQueue otherQueue)
	{
		CirArrayQueue copy = new CirArrayQueue(otherQueue);
		System.out.println("This copied queue have " + copy.count + " customers.");
	}
	
	//	Method to increment waiting of elements in queue
	public void incrementQueueWaitingTime()
	{
		if (!isEmpty())
		{
			for (int i = 0; i < maxQueueSize; i++)
			{
				if (list[i] == null)
				{
					continue;
				}
				
				else
				{
					((Customer)list[i]).incrementWaitingTime();
				}
			}
		}
	}
	
	//	Method to get number of elements in queue
	public int getCount()
	{
		return count;
	}
}
