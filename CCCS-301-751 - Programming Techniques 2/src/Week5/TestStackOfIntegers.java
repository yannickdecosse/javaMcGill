package Week5;
/*
	Name:			Yannick Decosse
	McGill ID:		260551160
	Course ID:		CCCS-301-751 - Programming Techniques 2
	Instructor: 	Dr. Hang Lau
	Date:			February 12, 2015
	Exercises:		Stacks
 */

public class TestStackOfIntegers 
{
  public static void main(String[] args) 
  {
    StackOfIntegers stack = new StackOfIntegers();
    
    for (int i = 0; i < 10; i++)
      stack.push(i);
    
    while (!stack.empty())
      System.out.print(stack.pop() + " ");  
  }
}
