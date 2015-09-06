package Week5;
/*
	Name:			Yannick Decosse
	McGill ID:		260551160
	Course ID:		CCCS-301-751 - Programming Techniques 2
	Instructor: 	Dr. Hang Lau
	Date:			February 12, 2015
	Exercises:		Sorting in ascending order
 */

public class SelectionSort
{
	public static void main(String[] args)
	{
		int[] num = {12,2,5,41,98,27,3,0,4};
		int[] theArray = sortArray(num, num.length);
		
			for (int x : theArray)
			System.out.print(x + " ");
	}
	
	public static int[] sortArray(int[] sortNum, int n)
	{
		int max = 1;
		
		if (n < 2)
			return sortNum;
		else
		{
			for (int i = 0; i < n - 1; i++)
			{
				if (sortNum[i] > sortNum[max])
					max = i;
			}
			
			if (sortNum[n - 1] == sortNum[max])
			{
				sortArray(sortNum, n - 1);
			}
			else
			{
				int temp = sortNum[n - 1];
				sortNum[n - 1] = sortNum[max];
				sortNum[max] = temp;
				sortArray(sortNum, n - 1);
			}
			
			return sortNum;
		}
		
		
		
	}
}