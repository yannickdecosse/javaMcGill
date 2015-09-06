package Week12;
/*
	Name:			Yannick Decosse
	McGill ID:		260551160
	Course ID:		CCCS-301-751 - Programming Techniques 2
	Instructor: 	Joseph Vybihal
	Date:			March 23, 2015
	Exercises:		Recursion
*/

public class ComputeFactorialTailRecursion 
{
  /** Return the factorial for a specified number */
  public static long factorial(int n) 
  {
    return factorial(n, 1); // Call auxiliary method
  }
    
  /** Auxiliary tail-recursive method for factorial */
  private static long factorial(int n, int result) 
  {
    if (n == 0) 
      return result;
    else
      return factorial(n - 1, n * result); // Recursive call
  }
  
  public static void main(String[] args)
  {
	  System.out.println(factorial(5));
  }
}

