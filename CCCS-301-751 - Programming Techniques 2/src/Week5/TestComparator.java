package Week5;
/*
	Name:			Yannick Decosse
	McGill ID:		260551160
	Course ID:		CCCS-301-751 - Programming Techniques 2
	Instructor: 	Dr. Hang Lau
	Date:			February 1, 2015
	Exercises:		Comparator
 */

import java.util.Comparator;

public class TestComparator
{
  public static void main(String[] args) 
  {
    GeometricObject g1 = new Rectangle(5, 5);
    GeometricObject g2 = new Circle(5);

    GeometricObject g = 
      max(g1, g2, new GeometricObjectComparator());
    
    System.out.println("The area of the larger object is " + 
      g.getArea());
  }
  
  public static GeometricObject max(GeometricObject g1, 
      GeometricObject g2, Comparator<GeometricObject> c) 
  {
    if (c.compare(g1, g2) > 0)
      return g1;
    else
      return g2;
  }
}