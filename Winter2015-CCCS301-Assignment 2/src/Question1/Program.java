/*
 * Name:		Yannick Decosse
 * Course ID:	CCCS-301-751 - Programming Techniques 2
 * McGill ID:	260551160
 * Instructor: 	Joseph Vybihal
 * Date:		February 21, 2015
 * 
 * Subject:		Assignment 3: Polymorphism, Interfaces & Abstract
 * Details:		Aggregated Objects
 * File name:	Program.java
 * Purpose:		Main program to instantiate a Classroom object to store 
 * 				Student objects inside an array
 * IDE:			Eclipse v.Luna Standard Edition
 * 
 */

package Question1;

import java.util.Scanner;

public class Program 
{
	public static void main(String[] args) 
	{
		int classroomSize = 0;
		int numberOfStudents = 0;
		//	Defining counter variable check whether that every student is created 
		//	with number defined by user
		int counter = 0;
		String studentName = "";
		double studentGPA = 0;
		
		//	Defining variables for user input
		Scanner inputClassroom = new Scanner(System.in);
		Scanner inputStudents = new Scanner(System.in);
		Scanner inputName = new Scanner(System.in);
		Scanner inputGPA = new Scanner(System.in);
		
		//	Create a header when running program
		System.out.println("\n----------------------------------------------------------------------------------------------------------");
		System.out.println("                                         Testing Aggregated Objects");
		System.out.println("----------------------------------------------------------------------------------------------------------\n");
		
		//	-----------------------------------------------------------------------------------------------
		//	User input section
		//	-----------------------------------------------------------------------------------------------
		
		System.out.print("Please enter size of classroom: ");
		
		//	Validating input for size of classroom. Size must be bigger than 0.
		while (!inputClassroom.hasNext("[0-9]+") || inputClassroom.hasNext("0"))
		{
			System.out.println("\nError! Enter only integers greater than 0.");
			System.out.print("Please try again: ");
			inputClassroom.next();
		}
		classroomSize = Integer.parseInt(inputClassroom.next());
				
		System.out.print("Please enter number of students to add to classroom: ");
		
		//	Validating input for number of students
		while (!inputStudents.hasNext("[0-9]+"))
		{
			System.out.println("\nError! Enter only positive integers.");
			System.out.print("Please try again: ");
			inputStudents.next();
		}
		numberOfStudents = Integer.parseInt(inputStudents.next());	
		
		//	Creating a classroom
		Classroom classroom = new Classroom(classroomSize);
		
		//	-----------------------------------------------------------------------------------------------
		//	Creating Student objects to enter in classroom
		//	-----------------------------------------------------------------------------------------------
		
		//	Enter information for each student while classroom can accept new student until full
		while (counter < numberOfStudents && numberOfStudents != 0)
		{
			System.out.print("\nPlease enter student name: ");

			studentName = inputName.nextLine();
			
			System.out.print("Please enter student gpa: ");
	
			//	Validating input for student GPA
			while (!inputGPA.hasNext("[0-9.-]+"))
			{
				System.out.println("\nError! Enter only digits.");
				System.out.print("Please try again: ");
				inputGPA.next();
			}
			studentGPA = Double.parseDouble(inputGPA.next());
				
			//	Creating new student to add to classroom
			if (classroom.add(new Student(studentName, studentGPA)))
			{				
				counter++;
			}
			
			else
			{
				System.out.println("Student cannot enter classroom!");
				counter++;
			}
		}
		
		//	-----------------------------------------------------------------------------------------------
		//	Display results section
		//	-----------------------------------------------------------------------------------------------
		
		//	If number of students entered by user or classroom size is 0
		if (numberOfStudents == 0)
		{
			//	Create a title before displaying students' details
				System.out.println("\n----------------------------------------------------------------------------------------------------------");
				System.out.println("                                      There is no student in classroom");
				System.out.println("----------------------------------------------------------------------------------------------------------");
		}
		
		else
		{
			//	Create a title before displaying students' details
			System.out.println("\n----------------------------------------------------------------------------------------------------------");
			System.out.println("                                      Display Students' details");
			System.out.println("----------------------------------------------------------------------------------------------------------");
			
			//	Traversing classroom object to print all students' details
			for (int i = 0; i < classroomSize; i++)
			{
				Student actualStudent = classroom.getStudent(i);
				
				//	Check if cell of array is null
				if (classroom.getStudent(i) == null )
				{
					System.out.println("\nnull");
				}
				
				else
				{
					System.out.println("\n" + "Student " + (i + 1) + "\n" + actualStudent);
				}	
			}
			
			//	Create a footer when leaving program
			System.out.println("\n----------------------------------------------------------------------------------------------------------");
			System.out.println("                                      Leaving Aggregated Objects Testing");
			System.out.println("----------------------------------------------------------------------------------------------------------\n");
		}
				
		//	Closing Scanner objects
		inputClassroom.close();
		inputStudents.close();
		inputName.close();
		inputGPA.close();				
	}
}
