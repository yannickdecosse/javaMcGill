/*
 * Name:		Yannick Decosse
 * Course ID:	CCCS-301-751 - Programming Techniques 2
 * McGill ID:	260551160
 * Instructor: 	Joseph Vybihal
 * Date:		April 1, 2015
 * 
 * Subject:		Assignment 4: Generics & GUI
 * Details:		Using Generics with a data structure together with Swing to create a multi file airport application
 * File name:	Queue.java
 * Purpose:		Use Generics and Swing library
 * IDE:			Eclipse v.Luna Standard Edition
 * 
 */

package Question3;

public class Queue<E>
{
	private E[] dynamicQueue;
	private final int FRONTQUEUE = 0;
	private int rearQueue;
	private int sizeOfQueue;
	
	//	Default constructor
	@SuppressWarnings("unchecked")
	public Queue()
	{
		//	Default queue size, typecast Object array to Generic type
		dynamicQueue = (E[]) new Object[10];
		rearQueue = 0;
		sizeOfQueue = 0;
	}
	
	//	Add new object to queue
	public boolean enqueue(E object)
	{	
		if (isQueueFull() || rearQueue + 1 == dynamicQueue.length)
		{
			doubleSize();
			dynamicQueue[rearQueue] = object;
			rearQueue++;
			sizeOfQueue++;
			
			return true;
		}
		
		else if (object != null || !isQueueFull() || rearQueue + 1 != dynamicQueue.length)
		{
			dynamicQueue[rearQueue] = object;
			rearQueue++;
			sizeOfQueue++;

			return true;
		}

		else
		{
			return false;
		}
	}
	
	//	Add new object to queue with index provided
	public boolean insert(E object, int index)
	{
		if (index >= rearQueue || rearQueue + 1 == dynamicQueue.length || index < 0 && object != null)
		{
			if (enqueue(object))
			{
				return true;
			}
			
			else
			{
				return false;
			}		
		}
		
		else if (object != null || !isQueueFull() || rearQueue + 1 != dynamicQueue.length && index < rearQueue)
		{
			int tmpRear = rearQueue;
			rearQueue++;
			
			//	Shift all objects from position index in queue to end of size of queue 1 cell up
			//	Insert new object at position dynamicQueue[index]
			for (int i = tmpRear; i > index; i--)
			{
				dynamicQueue[i] = dynamicQueue[i - 1];
			}
			
			dynamicQueue[index] = object;
			sizeOfQueue++;

			return true;
		}
		
		else
		{
			return false;
		}
	}
	
	//	Dequeue object from front of queue
	public E dequeue()
	{
		E returnObject = null;
		
		if (!isQueueEmpty())
		{
			returnObject = dynamicQueue[FRONTQUEUE];
			
			// Shift all objects 1 cell down
			for (int i = 0; i < rearQueue; i++)
			{
				dynamicQueue[i] = dynamicQueue[i + 1];
			}
			
			rearQueue--;
			sizeOfQueue--;
			
			return returnObject;
		}
		
		else
		{
			return null;
		}
	}
	
	//	Delete an object given index of queue
	public E delete(int index)
	{
		E returnObject = null;
		
		if (isQueueEmpty() || index < 0 || index > dynamicQueue.length - 1 || dynamicQueue[index] == null || index == rearQueue)
		{
			return null;
		}
		
		else
		{
			returnObject = dynamicQueue[index];
			
			// Shift all objects 1 cell down
			for (int i = index; i < rearQueue; i++)
			{
				dynamicQueue[i] = dynamicQueue[i + 1];
			}
						
			rearQueue--;
			sizeOfQueue--;
			
			return returnObject;
		}
	}
	
	//	Get size of queue
	public int getQueueSize()
	{
		return sizeOfQueue;
	}
	
	//	Method to peek an object at a given index
	public E peek(int index)
	{
		return dynamicQueue[index];
	}
	
	//	Check if queue is full
	private boolean isQueueFull()
	{		
		if (sizeOfQueue == dynamicQueue.length || rearQueue == dynamicQueue.length - 1)
		{
			return true;
		}
		
		else
		{
			return false;
		}	
	}
	
	//	Check if queue is empty
	private boolean isQueueEmpty()
	{		
		if (sizeOfQueue == 0 || rearQueue == FRONTQUEUE)
		{
			return true;
		}
		
		else
		{
			return false;
		}	
	}
	
	//	Double size of actual queue when full
	@SuppressWarnings("unchecked")
	private void doubleSize()
	{
		int newSize = dynamicQueue.length * 2;
		E[] newQueue = (E[]) new Object[newSize];
		int tmpRear = 0;
		//	Reset size of array
		sizeOfQueue = 0;
		
		//	Copy elements from actual queue to new 
		for (int i = 0; i <= rearQueue; i++)
		{
			if (dynamicQueue[i] != null)
			{
				newQueue[i] = dynamicQueue[i];
				tmpRear++;
				sizeOfQueue++;
			}
			
			else
			{
				continue;
			}
		}

		//	Assign newly created array to this queue reference
		//	Actual array is garbage collected
		dynamicQueue = newQueue;
		rearQueue = tmpRear;
		newQueue = null;
	}
}
