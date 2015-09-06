package Week3;
/*
	Name:			Yannick Decosse
	McGill ID:		260551160
	Course ID:		CCCS-301-751 - Programming Techniques 2
	Instructor: 	Joseph Vybihal
	Date:			January 19, 2015
	Exercises:		ArrayList and LinkedList
 */

import java.util.*;

public class TestIterator {
  public static void main(String[] args) {
    Collection<String> collection = new ArrayList<String>();
    collection.add("New York"); 
    collection.add("Atlanta"); 
    collection.add("Dallas"); 
    collection.add("Madison"); 

    Iterator<String> iterator = collection.iterator();
    while (iterator.hasNext()) {
      System.out.print(iterator.next().toUpperCase() + " ");
    }
    System.out.println();
    System.out.println(((ArrayList<String>) collection).indexOf("Dallas"));
  }
}
