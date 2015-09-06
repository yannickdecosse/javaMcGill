package Week5;
/*
	Name:			Yannick Decosse
	McGill ID:		260551160
	Course ID:		CCCS-301-751 - Programming Techniques 2
	Instructor: 	Dr. Hang Lau
	Date:			February 1, 2015
	Exercises:		ArrayDeque
 */

import java.util.ArrayDeque;
import java.util.Iterator;
 
public class ArrayDequeTest 
{
	public static void main(String[] args)
	{
		
		ArrayDeque<String> aq= new ArrayDeque<String>();
		aq.add("A");
		aq.add("B");
		aq.add("C");
		
		//offerFirst-adds elements at the front of the ArrayDeque 
		aq.addFirst("D");
		
		//offerLast inserts the element at the last of ArrayDeque 
		aq.addLast("E");
		
		Iterator<String> itr= aq.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}		
	}
}