package Week11;
/*
	Name:			Yannick Decosse
	McGill ID:		260551160
	Course ID:		CCCS-301-751 - Programming Techniques 2
	Instructor: 	Joseph Vybihal
	Date:			March 16, 2015
	Exercises:		Exception Handling & IO
 */

public class InvalidRadiusException extends Exception 
{
  private double radius;

  /** Construct an exception */
  public InvalidRadiusException(double radius) 
  {
    super("Invalid radius " + radius);
    this.radius = radius;
  }

  /** Return the radius */
  public double getRadius() 
  {
    return radius;
  }
}
