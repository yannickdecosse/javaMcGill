package Week8;
/*
	Name:			Yannick Decosse
	McGill ID:		260551160
	Course ID:		CCCS-301-751 - Programming Techniques 2
	Instructor: 	Joseph Vybihal
	Date:			February 23, 2015
	Exercises:		Abstracts and Interfaces
 */

public class Circle implements Relatable
{
	public int radius;
	
	public Circle(int radius)
	{
		this.radius = radius;
	}
	
	public int getArea()
	{
		return (int) Math.PI * radius * radius;
	}
	
	public int isLargerThan(Relatable other)
	{
		if (this.getArea() < other.getArea())
		{
			return -1;
		}
		
		if (this.getArea() > other.getArea())
		{
			return 1;
		}
		
		else
		{
			return 0;
		}
	}
}
