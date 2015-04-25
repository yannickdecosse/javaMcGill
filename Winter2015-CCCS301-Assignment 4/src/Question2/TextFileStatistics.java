/*
 * Name:		Yannick Decosse
 * Course ID:	CCCS-301-751 - Programming Techniques 2
 * McGill ID:	260551160
 * Instructor: 	Joseph Vybihal
 * Date:		March 27, 2015
 * 
 * Subject:		Assignment 4: Exceptions & File IO
 * Details:		Working with FIle IO and Exceptions for validation
 * File name:	TextFileStatistics.java
 * Purpose:		Use Exception Class and File IO
 * IDE:			Eclipse v.Luna Standard Edition
 * 
 */

package Question2;

import java.io.*;
import java.util.Scanner;

public class TextFileStatistics
{
	public static void main(String[] args) throws Exception
	{
		String fileName = "";
		String choice = "Y";
		Scanner input = new Scanner(System.in);
		//	Scanner object to input 'Y' or 'N' to continue program or stop 
		Scanner choiceInput = new Scanner(System.in);
		//	Variable to check for file existence or file is empty
		boolean fileExist = false;
		boolean fileEmpty = true;
		
		
		//	Program start over again unless user enter 'N' to quit system
		while (choice.equals("Y"))
		{
			//	Create a header when running program
			System.out.println("\n----------------------------------------------------------------------------------------------------------");
			System.out.println("|                                          Compute File Statistics                                       |");
			System.out.println("----------------------------------------------------------------------------------------------------------\n");
			
			try
			{
				while (!fileExist || fileEmpty)
				{
					try
					{
						System.out.print("Please enter file name: ");
						//	Check if input has at least a character to continue
						while ((fileName = input.nextLine()).isEmpty())
						{
							System.out.print("*** Error: you have input nothing!\n\nPlease enter a file name: ");
						}

						//	Check if file exists or can be read
						fileExist = fileExistence(fileName);
						//	Check if file is empty
						fileEmpty = fileIsEmpty(fileName);
					}
					
					catch (IOException none)
					{
						System.out.println(none.getMessage());
					}
					
					catch (EmptyException empty)
					{
						System.out.println(empty.getMessage());
					}
				}
				
				//	If file is not empty, compute statistics
				ComputeStatistics(fileName);
			}
			
			//	Handling exception in ComputeStatistics method too
			catch (FileNotFoundException notFound)
			{
				System.out.println(notFound.getMessage());
			}

			finally
			{
				//	Ask user to continue or not
				System.out.print("\nDo you want to compute another file statistics? (Y/N): ");
				
				//	Validating input from user
				while (!choiceInput.hasNext("[YNyn]"))
				{
					System.out.println("\nError! Enter only 'Y' or 'N'.");
					System.out.print("Do you want to compute another file statistics? (Y/N): ");
					choiceInput.nextLine();
				}
				choice = choiceInput.nextLine().toUpperCase();
				
				//	reset fileExist condition to false to allow loop 
				fileExist = false;
			}
		}
		
		//	Closing Scanner objects
		input.close();
		choiceInput.close();
		
		//	Create a footer before ending program
		System.out.println("\n\n----------------------------------------------------------------------------------------------------------");
		System.out.println("|                                      Thank you for using the system...                                 |");
		System.out.println("----------------------------------------------------------------------------------------------------------\n");		
	}
	
	public static void ComputeStatistics(String fileName) throws Exception
	{
		//	Create a FileReader object to check if file or path to file exists
		FileReader checkPath = new FileReader(fileName);
		//	Create a FileReader & BufferedReder objects with file entered by user
		FileReader textFile = new FileReader(fileName);
		BufferedReader readTextFile = new BufferedReader(textFile);
		//	Initialize variables to count no of characters, words, sentences and find longest sentence
		int chars = 0;
		int words = 0;
		int sentences = 0;
		int checkSentenceLength = 0;
		int longestSentence = 0;
		//	Variable use to count for number of white space after dot at end of line
		int whitespaceAfterDot = 0;
		
		//	String to process each line in text file
		String line = "";
		//	String used to computer no of characters
		String concatenateWords = "";
		//	Character delimeter to check for no of sentences
		char delimeter = '.';
		//	String array to store all words in file
		String[] totalWords;
		//	String array to process longest sentence
		String[] longest;
		
		if (checkPath.read() == -1)
		{
			checkPath.close();
			textFile.close();
			throw new FileNotFoundException("Sorry: path to file not found!");
		}

		while ((line = readTextFile.readLine()) != null)
		{
			//	Count no of sentences
			for (int i = 0; i < line.length(); i++)
			{
				if (Character.isWhitespace(line.charAt(i)) && line.charAt(i - 1) == '.')
				{
					sentences++;
				}
				else if (line.charAt(i) == delimeter && i == line.length() - 1)
				{
					sentences++;
				}
			}

			//	Adding all words per line in concatenateWords
			totalWords = line.split(" ");
			
			if (line.length() > 0)
			{
				if (line.charAt(line.length() - 1) == delimeter)
				{
					concatenateWords += (line + " ");
					whitespaceAfterDot++;
				}
				
				else
				{
					concatenateWords += (line + " ");
					whitespaceAfterDot++;
				}
			}
			
			else
			{
				concatenateWords += line;
			}

			//	Count no of words				
			for (String word : totalWords)
			{
				//	Do not count empty space between paragraphs
				if (!word.isEmpty())
				{
					words++;
				}
			}
		}
		
		//	Find no of words in longest sentence
		longest = concatenateWords.split(" ");
		
		for (int i = 0; i < longest.length; i++)
		{
			if (longest[i].isEmpty())
			{
				continue;
			}
			
			else if (longest[i].charAt(longest[i].length() - 1) == delimeter)
			{
				checkSentenceLength++;
				
				if (checkSentenceLength > longestSentence)
				{
					longestSentence = checkSentenceLength;
					checkSentenceLength = 0;
				}
				
				else
				{
					checkSentenceLength = 0;
				}
			}
			
			else
			{
				checkSentenceLength++;
			}
		}
		
		// Count no of characters
		chars = concatenateWords.length() - whitespaceAfterDot;

		//	Close BufferedReader & FileReader objects
		checkPath.close();
		textFile.close();
		readTextFile.close();
		
		System.out.println("\n\n----------------------------------------------------------------------------------------------------------");
		System.out.println("                                      Statistics for " + fileName);
		System.out.println("----------------------------------------------------------------------------------------------------------\n");
		System.out.println("Total number of characters: \t" + chars);
		System.out.println("Total number of words: \t\t" + words);
		System.out.println("Total number of sentences: \t" + sentences);
		System.out.println("Longest sentence: \t\t" + longestSentence + " words");
		System.out.println("\n----------------------------------------------------------------------------------------------------------");
	}
	
	//	Method to check if file exists or can be read
	public static boolean fileExistence(String fileName) throws IOException
	{
		//	Create new File object
		File text = new File(fileName);
		boolean check = false;
		
		if (!text.exists())
		{
			throw new IOException("Sorry: file does not exist. Try again!\n");
		}
		
		else if (!text.canRead())
		{
			throw new IOException("Sorry: file cannot be read. Try again!\n");
		}
		
		else
		{
			check = true;
		}
		
		return check;
	}
	
	//	Method to check if file is empty
	public static boolean fileIsEmpty(String fileName) throws Exception, EmptyException
	{
		boolean check = true;
		//	Create a FileReader & BufferedReder objects with file entered by user
		FileReader textFile = new FileReader(fileName);
		BufferedReader readTextFile = new BufferedReader(textFile);
		
		//	Check if text file is empty
		if (readTextFile.readLine() == null)
		{
			//	Closing FileReader object
			textFile.close();
			throw new EmptyException("Sorry: Text file is empty!\n");
		}
		
		else
		{
			check = false;
		}
		
		//	Closing BufferedReader object
		readTextFile.close();
		
		return check;
	}
}
