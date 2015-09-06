package Week8;
/*
	Name:			Yannick Decosse
	McGill ID:		260551160
	Course ID:		CCCS-301-751 - Programming Techniques 2
	Instructor: 	Joseph Vybihal
	Date:			February 23, 2015
	Exercises:		Abstracts and Interfaces
 */

public class Rectangle implements Relatable
{
	public int width, height;
	
	public Rectangle(int w, int h)
	{
		width = w;
		height = h;
	}
	
	public int getArea()
	{
		return width * height;
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
