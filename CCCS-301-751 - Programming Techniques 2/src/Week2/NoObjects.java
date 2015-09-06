package Week2;
/*
	Name:			Yannick Decosse
	McGill ID:		260551160
	Course ID:		CCCS-301-751 - Programming Techniques 2
	Instructor: 	Joseph Vybihal
	Date:			January 12, 2015
	Exercises:		Objects & Classes
 */

import java.util.Scanner;

public class NoObjects
{
	static int[] list = new int[15];
	static int count = 0; // next available place in array

	public static void main(String[] args)
	{
		int num, i;
		Scanner in = new Scanner(System.in);
		
		// Insert ten numbers in array
		for (i = 0; i < 10; i++)
		{
			System.out.print("Enter a number: ");
			num = in.nextInt();
			push(num);
		}
		
		// Displaying number found in array
		for ( i= 0; i < 10; i++)
		{
			num = pop();
			System.out.println(num);
		}

	}
	
	// 'push' method to insert each integer at end of 'list' array
	static void push(int x)
	{
		if (count < 15) 
		{
			list[count] = x;
			count++;
		}
	}
	
	// 'pop' method to retrieve each integer from end of 'list' array
	static int pop()
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
