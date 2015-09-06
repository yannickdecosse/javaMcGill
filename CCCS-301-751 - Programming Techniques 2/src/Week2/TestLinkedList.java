package Week2;
/*
	Name:			Yannick Decosse
	McGill ID:		260551160
	Course ID:		CCCS-301-751 - Programming Techniques 2
	Instructor: 	Joseph Vybihal
	Date:			January 12, 2015
	Exercises:		Lists
 */

import java.util.LinkedList;

public class TestLinkedList
{
	public static void main( String[] args)
	{
		LinkedList<Integer> theList = new LinkedList<Integer>();
		
		theList.addLast(39);
		theList.addLast(6);
		theList.addFirst(15);
		theList.addFirst(22);
		theList.removeFirst();
		theList.removeLast();
		theList.add(37);

		System.out.printf("%d %d", theList.getFirst(), theList.getLast());
		System.out.println("\n");
		System.out.println(theList.indexOf(15));
		printList(theList);
	}
	static void printList(LinkedList<Integer> lList)
	{
		for (int i = 0; i < lList.size(); i++)
		{
			System.out.print(lList.get(i) + " ");
		}

	}
}