/*
 * Name:		Yannick Decosse
 * Course ID:	CCCS-301-751 - Programming Techniques 2
 * McGill ID:	260551160
 * Instructor: 	Joseph Vybihal
 * Date:		April 1, 2015
 * 
 * Subject:		Assignment 4: Generics & GUI
 * Details:		Using Generics with a data structure together with Swing to create a multi file airport application
 * File name:	Itinerary.java
 * Purpose:		Use Generics and Swing library
 * IDE:			Eclipse v.Luna Standard Edition
 * 
 */

package Question3;

public class Itinerary
{
	private Queue<String> theItinerary;
	private String Title;
	
	//	Default no-args constructor
	public Itinerary() {};
	
	//	Default constructor
	public Itinerary(String title)
	{
		theItinerary = new Queue<String>();
		Title = title;
	}
	
	//	Add an item to Itinerary queue
	public boolean add(String item)
	{
		if (theItinerary.enqueue(item))
		{
			return true;
		}
		
		else
		{
			return false;
		}
	}
	
	//	Add an item to Itinerary queue given an index
	public boolean insert(String item, int index)
	{
		if (theItinerary.insert(item, index))
		{
			return true;
		}
		
		else
		{
			return false;
		}
	}
	
	//	Delete an item from queue given an index
	public boolean delete(int index)
	{
		if (theItinerary.delete(index) != null)
		{
			return true;
		}
		
		else
		{
			return false;
		}
	}
	
	// Move an item to another position
	public boolean move(int indexFrom, int indexTo)
	{
		String tmpItem;
		
		if (indexFrom < 0 || indexFrom > theItinerary.getQueueSize() || indexTo < 0 || indexTo > theItinerary.getQueueSize() || indexFrom == indexTo)
		{
			return false;
		}
		
		else
		{
			tmpItem = theItinerary.delete(indexFrom);
			
			if (theItinerary.insert(tmpItem, indexTo))
			{
				return true;
			}
				
			else
			{
				return false;
			}
		}
	}

	// Check if Itinerary list is empty
	public boolean isEmpty()
	{
		if (theItinerary.getQueueSize() == 0)
		{
			return true;
		}
		
		else
		{
			return false;
		}
	}
	
	// Get title of Itinerary
	public String getTitle()
	{
		return Title;
	}
	
	// Print all String in Itinerary list
	@Override
	public String toString()
	{
		String list = "";
		//	Variable counter to printer position of String in queue
		int counter = 1;
		
		if (theItinerary.getQueueSize() == 0)
		{
			return "\n" + Title + "\n-----------------------------------------------------------------\n" + "Itinerary list is empty."
					+ "\n-----------------------------------------------------------------\n\n";
		}
		
		else
		{
			for (int i = 0; i < theItinerary.getQueueSize(); i++)
			{
				list += counter + "." + "    " + theItinerary.peek(i) + "\n";
				counter++;
			}
		
			return "\n" + Title + "\n-----------------------------------------------------------------\n\n" + list
					+ "\n-----------------------------------------------------------------\n\n";
		}
	}
}
