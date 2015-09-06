package Week8;
/*
	Name:			Yannick Decosse
	McGill ID:		260551160
	Course ID:		CCCS-301-751 - Programming Techniques 2
	Instructor: 	Joseph Vybihal
	Date:			February 23, 2015
	Exercises:		Abstracts and Interfaces
 */

public class Tester
{
	public static void main(String[] args)
	{
		Rectangle r1 = new Rectangle(5, 5);
		Rectangle r2 = new Rectangle(10, 10);
		Circle c1 = new Circle(5);
		Circle c2 = new Circle(10);
		
		System.out.println(r1.isLargerThan(r2));
		System.out.println(r1.isLargerThan(r1));
		System.out.println(c1.isLargerThan(c2));
		System.out.println(c1.isLargerThan(c1));
		System.out.println(r1.isLargerThan(c1));
	}
}
