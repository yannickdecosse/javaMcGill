package Week5;
/*
	Name:			Yannick Decosse
	McGill ID:		260551160
	Course ID:		CCCS-301-751 - Programming Techniques 2
	Instructor: 	Dr. Hang Lau
	Date:			February 1, 2015
	Exercises:		ArrayList & LinkedList
 */

import java.util.*;

public class TestArrayAndLinkedlist {
  public static void main(String[] args) {
    List<Integer> arrayList = new ArrayList<Integer>(10);
    arrayList.add(1); // 1 is autoboxed to new Integer(1)
    arrayList.add(2);
    arrayList.add(3);
    arrayList.add(1);
    arrayList.add(4);
    arrayList.add(0, 10);
    arrayList.add(3, 30);

    System.out.println("A list of integers in the array list:");
    System.out.println(arrayList);

    LinkedList<Object> linkedList = new LinkedList<Object>(arrayList);
    
    linkedList.add(1, "red");
    linkedList.removeLast();
    linkedList.addFirst("green");

    System.out.println("Display the linked list backward:");
    for (int i = linkedList.size() - 1; i >= 0; i--) 
    {
      System.out.print(linkedList.get(i) + " ");
    }
    
    linkedList.remove("red");
    System.out.println("\n");
    
    for (Object o : linkedList)
    {
    	System.out.print(o + " ");
    }
  }
}
