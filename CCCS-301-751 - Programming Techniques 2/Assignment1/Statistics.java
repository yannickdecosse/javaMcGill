/*
	Name:			Yannick Decosse
	McGill ID:		260551160
	Course ID:		CCCS-301-751 - Programming Techniques 2
	Instructor: 	Joseph Vybihal
	Date:			January 22, 2015
	Subject:		Assignment 1a: Statistics.java - Working with Arrays
	IDE:			Eclipse v.Luna Standard Edition
*/

import java.util.Scanner;

public class Statistics
{
	public static void main(String[] args)
	{
		//	Initialize an array called 'series' to store 10 real numbers, 
		//	initialize 'number' to store each number entered by user
		double[] series = new double[10];
		double number;
		String answer;
		
		
		//	Create a header when running program
		System.out.println("****************************************************************************");
		System.out.println("                  Statistical Analysis for 10 real numbers                  ");
		System.out.println("****************************************************************************");
		
		
		//	Initialize Scanner object called 'key' to input numbers 
		Scanner key = new Scanner(System.in);
		
		try
		{
			//	Create loop to enter 10 numbers in array 
			for (int i = 0; i < series.length; i++)
			{
				System.out.print("\nEnter next number: ");
			
				//	Validate that only real numbers are entered
				while (!key.hasNext("[0-9.-]+"))
				{
					//	If wrong input type, print error message & user can enter again
					System.out.println("\nError! Enter only real numbers.");
					System.out.print("Please try again. Enter number: ");
					key.next();
				}
			
				//	Stored number from input in 'number' as double value and store to array at index [i]
				number = Double.parseDouble(key.next());
				series[i] = number;
			}
		}
		
		//	Catch NumberFormatException error when only a dot is entered
		catch (NumberFormatException ex)
		{
			System.out.println("Error detected " + ex);
		}

			System.out.println("\n****************************************************************************");
		
			//	Display the 10 numbers found in array
			System.out.print("Series: ");
			
			for (int i = 0; i < series.length; i++)
			{
				//	If number entered is a whole number, display as such
				int cast = 0;
				
				if (series[i] % 1 == 0)
				{
					cast = (int)(series[i]);
					System.out.print(cast + " ");
				}
				
				//	if number entered is a double, display as such
				else
				{
					System.out.print(series[i] + " ");
				}				 
			}
		
			//	Display average to 3 decimal points
			System.out.println("\nAverage: " + (int)(average(series)*1000) / 1000.0); 
		
			//	Find greatest number in series
			System.out.println("Greatest: " + greatest(series)); 
		
			//	Check if series is monotonic
				if (isMonotonic(series))
				{
					answer = "Yes";
				}
			
				else
				{
					answer = "No";
				}
			System.out.println("Monotonic: " + answer);
		
			//	Check for most frequent number
			System.out.println("Most frequent: " + mostFrequent(series));
		
			System.out.println("****************************************************************************");
			
			//	Close Scanner object
			key.close();
	}
	
	//	Create average() method to calculate average of the 10 numbers
	static double average(double[] arraySeries)
	{
		double[] series = arraySeries;
		double sum = 0;
		double theAverage;
		
		for (int i = 0; i < series.length; i++)
		{
			sum += series[i];
		}
		
		theAverage = sum / series.length;
		
		return theAverage;		
	}
	
	
	//	Create greatest() method to display greatest number in series
	static double greatest(double[] arraySeries)
	{
		double[] theSeries = arraySeries;
		
		// Set greatest number to first number in array
		double great = theSeries[0]; 
		
		for (int i = 0; i < theSeries.length; i++)
		{
			if (i < theSeries.length - 1)
			{
				if (theSeries[i + 1] > theSeries[i] && theSeries[i + 1] > great)
				{
					// If next number > previous number & great, assign next number as greatest
					great = theSeries[i + 1];
				}
			}
		}
		
		return great;		
	}
	
	
	//	Create greatest() method to check if series is Monotonic
	static boolean isMonotonic(double[] arraySeries)
	{
		double[] theSeries = arraySeries;
		boolean monotonic = false;
		
		// Counter used to check for ascending pattern
		int counterPlus = 1;
		
		// Counter used to check for descending pattern
		int counterLess = 1;
		
		//	Check if series is ascending Monotonic
		for (int i = 0; i < theSeries.length; i++)
		{
			if (i < theSeries.length - 1)
			{
				if (theSeries[i + 1] > theSeries[i])
				{
					counterPlus++;
				}
			}			
		}
		
		//	Check if series is descending Monotonic
		for (int i = 0; i < theSeries.length; i++)
		{
			if (i < theSeries.length - 1)
			{
				if (theSeries[i + 1] < theSeries[i])
				{
					counterLess++;
				}
			}			
		}
		
		//	If either ascending or descending counter is equal to array size
		//	series is Monotonic and return true, otherwise return false
		if (counterPlus == 10 || counterLess == 10)
		{
			monotonic = true;
		}
			
		return monotonic;
	}
	
	
	//	Create mostFrequent() method to check for the most frequent number
	static double mostFrequent(double[] arraySeries)
	{
		double[] theSeries = arraySeries;
		double isFrequent = 0;
		
		//	First counter to check for repetition
		int counter = 0;
		
		//	frequentCounter keeps track of last most frequent value
		int frequentCounter = 0;
		
		for (int i = 0; i < theSeries.length; i++)
		{
			if (i < theSeries.length - 1)
			{
				if (theSeries[i + 1] == theSeries[i])
				{
					counter++;
					
					//	if counter is greater than frequentCounter, assign new value to isFrequent
					if (counter++ > frequentCounter)
					{
						frequentCounter = counter;
						isFrequent = theSeries[i + 1];
					}
				}
				
				//	if next number is not equal to previous one, reset counter to 0
				if (theSeries[i + 1] != theSeries[i])
				{
					counter = 0;
				}
			}			
		}
		
		//	If frequentCounter is 0, there is no frequent number
		if (frequentCounter == 0)
		{
			isFrequent = -9999;
		}
		
		return isFrequent;
	}
}
