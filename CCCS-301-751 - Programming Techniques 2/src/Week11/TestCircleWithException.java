package Week11;
/*
	Name:			Yannick Decosse
	McGill ID:		260551160
	Course ID:		CCCS-301-751 - Programming Techniques 2
	Instructor: 	Joseph Vybihal
	Date:			March 16, 2015
	Exercises:		Exception Handling & IO
 */

public class TestCircleWithException 
{
  public static void main(String[] args) 
  {
    try {
      CircleWithException c1 = new CircleWithException(5);
      CircleWithException c2 = new CircleWithException(-5);
      CircleWithException c3 = new CircleWithException(0);
    }
    catch (IllegalArgumentException ex) 
    {
      System.out.println(ex);
    }

    System.out.println("Number of objects created: " + CircleWithException.getNumberOfObjects());
  }
}
