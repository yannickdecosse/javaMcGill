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

public class Date3
{
	public static void main(String[] args)
	{
		Date date = new Date(1234567);
		m1(date);
		System.out.println(date.getTime());
	}
	
	public static void m1(Date date)
	{
		date.setTime(7654321);
	}
}