package Week1;
/*
	Name:			Yannick Decosse
	McGill ID:		260551160
	Course ID:		CCCS-301-751 - Programming Techniques 2
	Instructor: 	Joseph Vybihal
	Date:			January 5, 2015
	Exercises:		Objects & Classes
 */

public class OutputD 
{
	public static void main(String[] args)
	{
		T t1 = new T();
		T t2 = new T();
		System.out.println("t1's i = " + t1.i + " and j = " + t1.j);
		System.out.println("t2's i = " + t2.i + " and j = " + t2.j);
	}
}

class T
{
	int i = 0;
	int j = 0;
	
	T()
	{
		i++;
		j = 1;
	}
}