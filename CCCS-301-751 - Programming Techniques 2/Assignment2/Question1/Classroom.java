/*
 * Name:		Yannick Decosse
 * Course ID:	CCCS-301-751 - Programming Techniques 2
 * McGill ID:	260551160
 * Instructor: 	Joseph Vybihal
 * Date:		February 21, 2015
 * 
 * Subject:		Assignment 3: Polymorphism, Interfaces & Abstract
 * Details:		Aggregated Objects
 * File name:	Classroom.java
 * Purpose:		Store Student's objects in Student array
 * IDE:			Eclipse v.Luna Standard Edition
 * 
 */

package Question1;

public class Classroom 
{
	private Student[] students;
	//	Defining a size variable to keep track of array size
	private int size;
	//	Defining a pointer variable to keep track of pointer location
	//	which is the next available position in array
	private int pointer;
	
	//	Defining default no-args constructor
	Classroom() {}
	
	Classroom(int maxClassroomSize)
	{
		size = maxClassroomSize;
		students = new Student[size];
		pointer = 0;
	}
	
	public boolean add(Student aStudent)
	{
		//	Variable to check for available space in students array
		boolean check = false;
		
		//	If array is full, stop inserting more Student objects in array
		if (pointer >= size)
		{
			System.out.println("\nSorry: classroom is full.");
			
			return check;
		}
		
		//	If student's has gpa is not between 0 and 4, or name is not given, do not insert Student object in array
		else if (aStudent.getName().trim().isEmpty() || aStudent.getGPA() < 0 || aStudent.getGPA() > 4)
		{
			System.out.println("\nSorry: Name has no characters or gpa is not between 0 & 4.");
			pointer++;
			
			return check;
		}

		//	If student gpa is between 0 and 4, and there is place in array, insert new Student object
		else
		{
			students[pointer] = aStudent;
			pointer++;
			check = true;
			
			return check;		
		}
	}
	
	// Display details of student for Student object at position in Student array
	public Student getStudent(int position)
	{
		//	Throw exception if position points to cell outside array
		if (position < 0 || position >= size)
		{
			//throw new IndexOutOfBoundsException("null");
			return null;
		}
		
		else
		{
			return students[position];
		}
	}
}
