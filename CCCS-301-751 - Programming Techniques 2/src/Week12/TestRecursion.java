package Week12;
/*
	Name:			Yannick Decosse
	McGill ID:		260551160
	Course ID:		CCCS-301-751 - Programming Techniques 2
	Instructor: 	Joseph Vybihal
	Date:			March 23, 2015
	Exercises:		Recursion
*/

public class TestRecursion
{
	public static void main(String[] args) 
	{
		print(3);
	}
	
	public static void print(int n)
	{
		if (n == 0)
		{
			return;
		}
		
		else
		{
			print(n - 1);
		}
		
		System.out.println(n);
	}
}
