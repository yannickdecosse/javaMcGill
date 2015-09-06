package Week1;
/*
	Name:			Yannick Decosse
	McGill ID:		260551160
	Course ID:		CCCS-301-751 - Programming Techniques 2
	Instructor: 	Joseph Vybihal
	Date:			January 5, 2015
	Exercises:		Objects & Classes
 */

public class OutputB 
{
	public static void main(String[] args) 
	{
		int[] a = {1, 2};
		swap(a);
		System.out.println("a[0] = " + a[0] + " a[1] = " + a[1]);
	}

	public static void swap(int[] a)
	{
		int temp = a[0];
		a[0] = a[1];
		a[1] = temp;
	}
}