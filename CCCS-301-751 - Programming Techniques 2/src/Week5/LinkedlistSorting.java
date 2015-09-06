package Week5;
/*
	Name:			Yannick Decosse
	McGill ID:		260551160
	Course ID:		CCCS-301-751 - Programming Techniques 2
	Instructor: 	Dr. Hang Lau
	Date:			February 1, 2015
	Exercises:		LinkedList
 */

import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedlistSorting
{
	public static void main(String[] args)
	{
		int[] integerList = {1,5,-1,23,51,42};
		LinkedList<Integer> linkedListInt = new LinkedList<Integer>();
		
		for(int i = 0; i < integerList.length; i++)
		{
			ListIterator<Integer> check =  linkedListInt.listIterator();
			int more = 0;
			int less = 0;
			
			if (!check.hasNext())
			{
				linkedListInt.add(integerList[i]);
			}
			
			while (check.hasNext())
			{
				Integer next = (Integer) check.next();
				
				if (integerList[i] == next)
				{
					linkedListInt.add(integerList[i]);
				}
				
				if (integerList[i] > next && next == linkedListInt.size() - 1)
				{
					more = linkedListInt.indexOf(next);
				}
				
				else
				{
					less = linkedListInt.indexOf(next);
				}
			}
			
			if (more != 0)
			{
				linkedListInt.add(more, integerList[i]);
			}
			
			else
			{
				linkedListInt.add(less, integerList[i]);
			}
			
			linkedListInt.addLast(integerList[i]);
		}
		
		System.out.println(linkedListInt);

	}

}
