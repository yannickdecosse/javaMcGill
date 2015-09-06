/*
 * Name:		Yannick Decosse
 * Course ID:	CCCS-301-751 - Programming Techniques 2
 * McGill ID:	260551160
 * Instructor: 	Joseph Vybihal
 * Date:		March 27, 2015
 * 
 * Subject:		Assignment 4: Recursion
 * Details:		Recursive method to print a string in reverse order
 * File name:	TestStringRecursion.java
 * Purpose:		Use Recursion
 * IDE:			Eclipse v.Luna Standard Edition
 * 
 */

package Question4;

import java.util.Scanner;

public class TestStringRecursion
{
	//	StringBuilder variable used to process reverse input from user
	private static StringBuilder reverse;
	
	public static void main(String[] args)
	{
		String inputString = "";
		Scanner input = new Scanner(System.in);
		
		//	Create a header when running program
		System.out.println("\n----------------------------------------------------------------------------------------------------------");
		System.out.println("|                                        String Recursive Method Tester                                  |");
		System.out.println("----------------------------------------------------------------------------------------------------------\n");
		
		//	Input from user
		System.out.print("Please enter a sentence: ");
		//	Check if input has at least a character to continue
		while ((inputString = input.nextLine()).trim().isEmpty())
		{
			System.out.print("*** Error: enter at least 1 character!\n\nPlease enter a sentence: ");
		}
		
		//	set reverse length to input String's length
		reverse = new StringBuilder(inputString.length());
		//	Output Reverse order of String entered by user
		System.out.print("Recursive output: " + ReversePrint(inputString));
		
		//	Create a footer before ending program
		System.out.println("\n\n----------------------------------------------------------------------------------------------------------");
		System.out.println("|                                      Thank you for using the Tester...                                 |");
		System.out.println("----------------------------------------------------------------------------------------------------------\n");
		
		input.close();
	}
	
	public static String ReversePrint(String msg)
	{
		//	Variable to return reverse String
		String returnReverse = "";		
		//	Variable used to go from last character of String to first one
		int position = msg.length() - 1;
		
		//	Base case
		if (position == 0)
		{
			reverse.append(msg.charAt(0));
		}
		
		else 
		{
			//	Recursive methods to reverse string one character at a time
			reverse.append(msg.charAt(position));
			ReversePrint(msg.substring(0, position));
		}
		
		//	Assigning StringBuilder object value to String
		returnReverse = reverse.toString();
		
		return returnReverse;
	}
}
