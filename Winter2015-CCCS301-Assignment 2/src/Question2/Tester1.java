/*
 * Name:		Yannick Decosse
 * Course ID:	CCCS-301-751 - Programming Techniques 2
 * McGill ID:	260551160
 * Instructor: 	Joseph Vybihal
 * Date:		February 27, 2015
 * 
 * Subject:		Assignment 3: Polymorphism, Interfaces & Abstract
 * Details:		Basic Container class using Object
 * File name:	Tester1.java
 * Purpose:		Using Object class to create a container implementation
 * IDE:			Eclipse v.Luna Standard Edition
 * 
 */

package Question2;

import java.util.Scanner;
import java.util.Arrays;

public class Tester1 
{
	public static void main(String[] args) 
	{
		//	Initialize repeat to test Container again
		String repeat = "y";
		//	Two arrays to keep possibilities of yes or no
		String[] positiveAns = {"y", "Y", "yes", "Yes", "YES"};
		String[] negativeAns = {"n", "N", "no", "No", "NO"};
		
		//	Scanner objects to store inputs from user
		//	Enter series of string
		Scanner getString = new Scanner(System.in);
		//	Get index number from user
		Scanner getIndex = new Scanner(System.in);
		//	Enter string from user to compare with strings in array
		Scanner getComparison = new Scanner(System.in);
		//	Choice from user to continuer testing Container or quit
		Scanner getRepeat = new Scanner(System.in);
		
		//	Keep repeating loop until answer is no
		while (Arrays.asList(positiveAns).contains(repeat))
		{			
			//	Create a Container of size 20
			ContainerVer1 container = new ContainerVer1(20);
			//	Initialize a pointer to be use to visit each cell and enter String objects
			int pointer = 0;
			//	Initialize userAnswer to enter string
			String userAnswer = "";
			//	Initialize index to get elements from Container
			int searchIndex = 0;

		
			//	Create a header when running program
			System.out.println("\n----------------------------------------------------------------------------------------------------------");
			System.out.println("                                         Testing Basic Container Class");
			System.out.println("----------------------------------------------------------------------------------------------------------\n");		
		
			//	-----------------------------------------------------------------------------------------------
			//	Entering strings in Container
			//	-----------------------------------------------------------------------------------------------				
			while (pointer < 20)
			{
				//	Print cell number before user enter string
				System.out.println("\nString " + (pointer + 1));
				System.out.print("Please enter any string: ");
				userAnswer = getString.nextLine();
			
				if (userAnswer.equals("DONE"))
				{	
					break;
				}
			
				else if (container.add(userAnswer))
				{
					pointer++;	
				}
					
				else
				{
					System.out.println("Container is now full!");
					break;
				}

			}
			
			//	-----------------------------------------------------------------------------------------------
			//	Testing the Container and display contents
			//	-----------------------------------------------------------------------------------------------			

			//	Create a header for Testing section
			System.out.println("\n----------------------------------------------------------------------------------------------------------");
			System.out.println("                                         Results from Container Class");
			System.out.println("----------------------------------------------------------------------------------------------------------\n");
			
			//	(d-1)
			//	Ask user to enter integer to retrieve string
			System.out.print("\nPlease enter an integer digit: ");
			
			//	Validating input for integer
			while (!getIndex.hasNext("[0-9]+"))
			{
				System.out.println("\nError! Enter only a positive integer.");
				System.out.print("Please try again: ");
				getIndex.next();
			}
			searchIndex = Integer.parseInt(getIndex.next());
			
			System.out.println("Content of cell is \"" + container.get(searchIndex) + "\"");
			

			//	(d-2)
			//	Ask user to enter integer to delete string
			System.out.print("\nPlease enter an integer digit: ");
			
			//	Validating input for integer
			while (!getIndex.hasNext("[0-9]+"))
			{
				System.out.println("\nError! Enter only a positive integer.");
				System.out.print("Please try again: ");
				getIndex.next();
			}
			searchIndex = Integer.parseInt(getIndex.next());
			
			if (!container.delete(searchIndex))
			{
				//	If cell does not exist
				System.out.println("Invalid number: no such cell in this Container!");

			}
			
			else
			{
				//	If string has been deleted
				System.out.println("String in cell " + searchIndex + " has been deleted.");

			}
			
			
			//	(d-3)
			//	Display content of Container
			for (int i = 0; i < 20; i++)
			{
				System.out.println("\nString in cell " + i + ":");
				System.out.println(container.get(i));
			}
			
			
			//	(d-4)
			//	Ask user to enter a string
			System.out.print("\nPlease enter a string: ");
			userAnswer = getComparison.nextLine();
			
			System.out.println("\nString entered is at index: " + container.find(userAnswer));
			System.out.println("String in array? " + container.isMember(userAnswer));
			
			
			//	(d-5)
			//	Ask user to continue or quit
			System.out.print("\nWould you like to test Container again (yes or no) ?");
			
			//	Repeat question if user enter input other than 'yes' or 'no'
			while (!getRepeat.hasNext("[ynYN]|yes|Yes|YES|no|No|NO"))
			{
				System.out.println("\nError! Enter only 'y' or 'Y' or 'yes' or 'Yes' or 'YES' or 'n' or 'N' or 'no' or 'No' or 'NO'.");
				System.out.print("Please try again: ");
				getRepeat.next();
			}
			repeat = getRepeat.next();
			
			//	If user enter no quit Container testing
			if (Arrays.asList(negativeAns).contains(repeat))
			{
				break;
			}
		}

		//	Create a footer when leaving program
		System.out.println("\n----------------------------------------------------------------------------------------------------------");
		System.out.println("                                              Leaving Container Testing");
		System.out.println("----------------------------------------------------------------------------------------------------------\n");
		
		//	Close Scanner objects
		getString.close();
		getIndex.close();
		getComparison.close();
		getRepeat.close();
	}
}
