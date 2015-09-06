package Week2;
/*
	Name:			Yannick Decosse
	McGill ID:		260551160
	Course ID:		CCCS-301-751 - Programming Techniques 2
	Instructor: 	Joseph Vybihal
	Date:			January 12, 2015
	Exercises:		Lists
 */

public class Course 
{
	private String courseName;
	private String[] students = new String[100];
	private int numberOfStudents;
    
	public Course(String courseName) 
	{
		this.courseName = courseName;
	}
  
	public void addStudent(String student) 
	{
		students[numberOfStudents] = student;
		numberOfStudents++;
	}
  
	public String[] getStudents() 
	{
		return students;
	}

	public int getNumberOfStudents() 
	{
		return numberOfStudents;
	}  

	public String getCourseName() 
	{
		return courseName;
	}  
  
	public void dropStudent(String student) 
	{
    // Left as an exercise in Exercise 9.9
	}
}