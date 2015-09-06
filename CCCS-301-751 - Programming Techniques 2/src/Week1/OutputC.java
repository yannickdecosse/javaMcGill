package Week1;
/*
	Name:			Yannick Decosse
	McGill ID:		260551160
	Course ID:		CCCS-301-751 - Programming Techniques 2
	Instructor: 	Joseph Vybihal
	Date:			January 5, 2015
	Exercises:		Objects & Classes
 */

public class OutputC 
{
	public static void main(String[] args)
	{
		S t = new S();
		swap(t);
		System.out.println("e1 = " + t.e1 + " e2 = " + t.e2);
	}

	public static void swap(S t)
	{
		int temp = t.e1;
		t.e1 = t.e2;
		t.e2 = temp;
	}
}

class S 
{
	int e1 = 1;
	int e2 = 2;
}