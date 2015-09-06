package Week5;
/*
	Name:			Yannick Decosse
	McGill ID:		260551160
	Course ID:		CCCS-301-751 - Programming Techniques 2
	Instructor: 	Dr. Hang Lau
	Date:			February 1, 2015
	Exercises:		Abstract class & Parent class
 */

public class Rectangle extends GeometricObject 
{
  private double width;
  private double height;

  public Rectangle() 
  {
  }

  public Rectangle(double width, double height) 
  {
    this.width = width;
    this.height = height;
  }

  /** Return width */
  public double getWidth() 
  {
    return width;
  }

  /** Set a new width */
  public void setWidth(double width) 
  {
    this.width = width;
  }

  /** Return height */
  public double getHeight() 
  {
    return height;
  }

  /** Set a new height */
  public void setHeight(double height) 
  {
    this.height = height;
  }

  @Override /** Return area */
  public double getArea() 
  {
    return width * height;
  }

  @Override /** Return perimeter */
  public double getPerimeter() 
  {
    return 2 * (width + height);
  }
}
