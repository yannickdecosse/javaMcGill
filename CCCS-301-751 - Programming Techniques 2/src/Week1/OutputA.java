package Week1;
/*
	Name:			Yannick Decosse
	McGill ID:		260551160
	Course ID:		CCCS-301-751 - Programming Techniques 2
	Instructor: 	Joseph Vybihal
	Date:			January 5, 2015
	Exercises:		Objects & Classes
 */

public class OutputA 
{
	public static void main(String[] args) 
	{
		int[] a = {1, 2};
		swap(a[0], a[1]);
		System.out.println("a[0] = " + a[0] + " a[1] = " + a[1]);
	}
	
	public static void swap(int n1, int n2)
	{
		int temp = n1;
		n1 = n2;
		n2 = temp;
	}
}