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
import java.util.Deque;
import java.util.Iterator;

public class ArrayDequeDemo 
{
   public static void main(String[] args) 
   {
      
      // create an empty array deque with an initial capacity
      Deque<Integer> deque = new ArrayDeque<Integer>(8);

      // use add() method to add elements in the deque
      deque.add(15);
      deque.add(22);
      deque.add(25);
      deque.add(20);

      // iterator() is used to print all the elements
      // next() returns the next element on each iteration
      System.out.println("printing elements using iterator:");
      for(Iterator<Integer> itr = deque.iterator(); itr.hasNext();)  
      {
        System.out.println(itr.next());
      }
   }
}   