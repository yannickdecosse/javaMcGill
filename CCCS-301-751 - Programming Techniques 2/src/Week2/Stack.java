package Week2;
/*
	Name:			Yannick Decosse
	McGill ID:		260551160
	Course ID:		CCCS-301-751 - Programming Techniques 2
	Instructor: 	Joseph Vybihal
	Date:			January 12, 2015
	Exercises:		Objects & Classes
 */

public class Stack
{
	int[] list = new int[15];
	int count = 0; // next available place in array
	
	Stack()
	{
		
	}
	// 'push' method to insert each integer at end of 'list' array
	void push(int x)
	{
		if (count < 15) 
		{
			list[count] = x;
			count++;
		}
	}
		
	// 'pop' method to retrieve each integer from end of 'list' array
	int pop()
	{
		int x;
		if (count - 1 >= 0)
		{
			--count;
			x = list[count];
			list[count] = 0;
			
			return x;
		}
		else
			
		{
			return -999;
		}
	}
}
