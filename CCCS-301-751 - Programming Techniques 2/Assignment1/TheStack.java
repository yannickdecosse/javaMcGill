/*
	Name:			Yannick Decosse
	McGill ID:		260551160
	Course ID:		CCCS-301-751 - Programming Techniques 2
	Instructor: 	Joseph Vybihal
	Date:			January 22, 2015
	Subject:		Assignment 1b: Statistics.java - Simulate a stack with an array
	IDE:			Eclipse v.Luna Standard Edition
*/

public class TheStack
{
	private int[] theArray = new int[20];
	private int top;
	
	TheStack()
	{
		top = 0;
		
		//	Assign -1 to each cell in array
		for (int i = 0; i < theArray.length; i++)
		{
			theArray[i] = -1;
		}
	}
	
	public int getTop()
	{
		return top;
	}
	
	public boolean push(int value)
	{
		int number = value;
		boolean check = true;
		
		//	Check if array is full and that number entered is >= 0
		if (!isFull() && number >= 0)
		{
			theArray[top] = number;
			top++;
		}
		
		else
		{
			check = false;
		}
		
		return check;			
	}
	
	public boolean isFull()
	{
		boolean check = false;
		
		if (top == theArray.length - 1)
		{
			check = true;
		}
		
		return check;
	}
	
	public int pop()
	{
		int value = 0;
		
		// Check id array is empty and top >=0 to prevent OutOfBound error
		if (!isEmpty() && top > 0)
		{
			top--;
			value = theArray[top];
			theArray[top] = -1;
			
		}
		
		else
		{
			value = -9999;
		}
		
		return value;
	}
	
	public boolean isEmpty()
	{
		boolean check = false;
		int counter = 0;
		
		//	use counter to see if all cells in array are empty
		for (int i = 0; i < theArray.length; i++)
		{
			if (theArray[i] == -1)
				counter++;
		}
		
		if (counter == 20)
		{
			check = true;
		}
		
		return check;
	}
}
