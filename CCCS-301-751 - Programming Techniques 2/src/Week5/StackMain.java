package Week5;
/*
	Name:			Yannick Decosse
	McGill ID:		260551160
	Course ID:		CCCS-301-751 - Programming Techniques 2
	Instructor: 	Dr. Hang Lau
	Date:			February 12, 2015
	Exercises:		Stacks
 */

import java.util.*; // for the Stack class and the exception class

public class StackMain 
{ 

   public static void main(String[] args) 
   { 
      // create two stacks of Objects
      Stack<Object> s = new Stack<Object>();
      Stack<Object> t = new Stack<Object>();
      // push ints onto the stacks.  Need wrappers for int.
      //  Can assign Integer to Object, but not int to Object
      for (int i = 0; i < 10; i++) 
      {
         Object obj = new Integer(i*i); // wrapper for i*i value
         s.push(obj); 
         t.push(obj);
      }

      // three ways to peek at top element
      // s.peek() is an object, so must let system convert
      //   with +"", or must do an explicit cast
      int i = (new Integer(s.peek() + "")).intValue();
      System.out.println("1st peek: " + i);
      int j = Integer.parseInt(s.peek() + "");
      System.out.println("2nd peek: " + j);
      int k = ((Integer)s.peek()).intValue();
      System.out.println("3rd peek: " + k);

      // pop and print the first stack, using empty()
      //   method to terminate loop
      while (!s.empty())
         System.out.print(s.pop() + " ");
      System.out.println("\nEnd of the first stack");

      // try to pop an empty stack (get error message)
      try 
      {
         s.pop();
      } 
      
      catch (EmptyStackException ese) 
      {
         System.out.println("Tried to pop empty stack");
      }

      // pop and print 2nd stack, using EmptyStackException
      //   to terminate loop (not the preferred method)
      while (true) 
      {
         try 
         {
            System.out.print(t.pop() + " ");
         } 
         catch (EmptyStackException ese) 
         {
            break;
         }
      }
      System.out.println("\nTh-th-th-th-that's-all-folks");
   }
}