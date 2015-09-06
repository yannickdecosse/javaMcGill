package Week1;
/*
	Name:			Yannick Decosse
	McGill ID:		260551160
	Course ID:		CCCS-301-751 - Programming Techniques 2
	Instructor: 	Joseph Vybihal
	Date:			January 5, 2015
	Exercises:		Objects & Classes
 */

import java.util.Date;

public class Date1
{
	public static void main(String[] args)
	{
		Date date = null;
		m1(date);
		System.out.println(date);
	}

	public static void m1(Date date)
	{
		date = new Date();
	}
}