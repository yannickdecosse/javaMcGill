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

public class Program
{

	public static void main(String[] args)
	{
		Stack obj = new Stack(); // Instantiate Stack object called 'obj'
		
		int num, i;
		Scanner in = new Scanner(System.in);
		
		// Insert ten numbers in array
		for (i = 0; i < 10; i++)
		{
			System.out.print("Enter a number: ");
			num = in.nextInt();
			obj.push(num);
		}
		
		// Displaying number found in array
		for (i = 0; i < 10; i++)
		{
			num = obj.pop();
			System.out.println(num);
		}

	}
}
