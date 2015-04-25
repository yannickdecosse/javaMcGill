/*
 * Name:		Yannick Decosse
 * Course ID:	CCCS-301-751 - Programming Techniques 2
 * McGill ID:	260551160
 * Instructor: 	Joseph Vybihal
 * Date:		April 1, 2015
 * 
 * Subject:		Assignment 4: Generics & GUI
 * Details:		Using Generics with a data structure together with Swing to create a multi-file airport application
 * File name:	Program.java
 * Purpose:		Use Generics and Swing library
 * IDE:			Eclipse v.Luna Standard Edition
 * 
 */

package Question3;

import java.util.Scanner;

public class Program
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		int airplanes = 0;
		//	Creating an Airport reference
		Airport airport;
		
		//	Create a header when running program
		System.out.println("\n----------------------------------------------------------------------------------------------------------");
		System.out.println("|                                       Airports & Travel Itineraries                                    |");
		System.out.println("----------------------------------------------------------------------------------------------------------\n");
		
		System.out.print("Please enter number of airplanes: ");
		
		//	Validating input from user
		while (!input.hasNext("[0-9]+") || input.hasNext("0"))
		{
			System.out.println("Error! Enter only numbers greater than zero.");
			System.out.print("\nPlease enter number of airplanes: ");
			input.next();
		}
		airplanes = Integer.parseInt(input.next());
		
		//	Instantiating new Airport object with number of airplanes
		airport = new Airport(airplanes);
		//	Calling menu() swing interface
		airport.menu();
		//	Closing Scanner object
		input.close();
	}
}
