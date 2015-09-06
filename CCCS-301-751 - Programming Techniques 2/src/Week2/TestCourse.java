package Week2;
/*
	Name:			Yannick Decosse
	McGill ID:		260551160
	Course ID:		CCCS-301-751 - Programming Techniques 2
	Instructor: 	Joseph Vybihal
	Date:			January 12, 2015
	Exercises:		Lists
 */

public class TestCourse 
{
	public static void main(String[] args) 
	{
		Course course1 = new Course("Data Structures");
		Course course2 = new Course("Database Systems");

		course1.addStudent("Peter Jones");
		course1.addStudent("Brian Smith");
		course1.addStudent("Anne Kennedy");

		course2.addStudent("Peter Jones");
		course2.addStudent("Steve Smith");

		System.out.println("Number of students in course1: " + course1.getNumberOfStudents());
		System.out.println(course1.getCourseName());
		String[] students = course1.getStudents();
		
		for (int i = 0; i < course1.getNumberOfStudents(); i++)
			System.out.print(students[i] + ", ");
    
		System.out.println();
		System.out.print("Number of students in course2: " + course2.getNumberOfStudents());
	}
}
