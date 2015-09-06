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

public class GeometricObjectComparator implements Comparator<GeometricObject>, java.io.Serializable 
{
	public int compare(GeometricObject o1, GeometricObject o2) 
    {
    	double area1 = o1.getArea();
    	double area2 = o2.getArea();

    	if (area1 < area2)
    		return -1;
    	else if (area1 == area2)
    		return 0;
    	else
    		return 1;
    }
}
