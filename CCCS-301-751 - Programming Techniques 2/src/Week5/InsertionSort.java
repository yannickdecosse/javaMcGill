package Week5;
/*
	Name:			Yannick Decosse
	McGill ID:		260551160
	Course ID:		CCCS-301-751 - Programming Techniques 2
	Instructor: 	Dr. Hang Lau
	Date:			February 12, 2015
	Exercises:		Sorting in ascending order
 */

public class InsertionSort
{
	public static void main(String[] args)
	{
		int[] num = {12,2,5,41,98,27,3,0,4};
		int j;                     // the number of items sorted so far
		int key;                // the item to be inserted
		int i;  

		for (j = 1; j < num.length; j++)    // Start with 1 (not 0)
		{
			key = num[j];
			for(i = j - 1; (i >= 0) && (num[i] > key); i--)   // Smaller values are moving up
			{
				num[i+1] = num[i];
			}
			num[i+1] = key;    // Put the key in its proper location
		}
		
		for (int x : num)
			System.out.print(x + " ");
	}
}