/*
 * Name:		Yannick Decosse
 * Course ID:	CCCS-301-751 - Programming Techniques 2
 * McGill ID:	260551160
 * Instructor: 	Joseph Vybihal
 * Date:		February 21, 2015
 * 
 * Subject:		Assignment 3: Polymorphism, Interfaces & Abstract
 * Details:		Aggregated Objects
 * File name:	Student.java
 * Purpose:		Store students' names and gpas
 * IDE:			Eclipse v.Luna Standard Edition
 * 
 */

package Question1;

public class Student 
{
	private String name;
	private double gpa;
	
	//	Defining default no-args constructor
	Student() {}
	
	//	Default args constructor - parameters are compulsory to add
	//	Student object to Classroom
	Student(String name, double gpa)
	{
		this.name = name;
		this.gpa = gpa;
	}
	
	//	Set name of student after validating characters entered by user
	public void setName(String name)
	{
		if (name != null)
		{
			this.name = name;
		}
		
		else
		{
			System.out.println("Cannot set name with no characters!");
		}	
	}
	
	//	Set name of student after validating digits entered by user
	public void setGPA(double gpa)
	{
		if (gpa >=0 || gpa <= 4)
		{
			this.gpa = gpa;
		}
		
		else
		{
			System.out.println("Student cannot have a gpa less than 0 or greater than 4");
		}
	}
	
	public String getName()
	{
		return name;
	}
	
	//	Return gpa rounded to 2 decimal places
	public double getGPA()
	{
		return Math.round(gpa * 100.0) / 100.0;
	}
	
	// Overriding Object.toString() method to display details of each student
	@Override
	public String toString()
	{
		String studentDetails = "";
		
		studentDetails = "Name:\t" + getName() + "\n" + "GPA:\t" + getGPA();
		
		return studentDetails;
	}
}
