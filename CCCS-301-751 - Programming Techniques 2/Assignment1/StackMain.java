/*
	Name:			Yannick Decosse
	McGill ID:		260551160
	Course ID:		CCCS-301-751 - Programming Techniques 2
	Instructor: 	Joseph Vybihal
	Date:			January 22, 2015
	Subject:		Assignment 1b: Statistics.java - Simulate a stack with an array
	IDE:			Eclipse v.Luna Standard Edition
*/

import java.util.Scanner;

public class StackMain
{
	public static void main(String[] args)
	{
		//	Create a header when running program
		System.out.println("****************************************************************************");
		System.out.println("              Simulate a stack with an array through an object              ");
		System.out.println("****************************************************************************");
		
		TheStack aStack = new TheStack();
		
		Scanner key = new Scanner(System.in);
		
			//	Create loop to enter 10 numbers in object 
			do
			{
				System.out.print("\nEnter next number: ");
					
				//	Validate that only real numbers are entered
				while (!key.hasNext("[0-9-]+"))
				{
					//	If wrong input type, print error message & user can enter again
					System.out.println("\nError! Enter only integers.");
					System.out.print("Please try again. Enter integer: ");
					key.next();
				}	
			}			
			while (aStack.push(Integer.parseInt(key.next())) && aStack.getTop() < 10);
			
			System.out.println("\n****************************************************************************");
			
			//	Display the 10 numbers in reverse order of entry
			System.out.print("Numbers in stack: ");
			
			for (int i = 0; i < 10; i++)
			{
				System.out.print(aStack.pop() + " ");
			}
			
			System.out.println("\n****************************************************************************");
			
			//	Close Scanner
			key.close();

	}
}
