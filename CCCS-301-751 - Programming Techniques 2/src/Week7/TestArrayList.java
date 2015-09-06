package Week7;
/*
	Name:			Yannick Decosse
	McGill ID:		260551160
	Course ID:		CCCS-301-751 - Programming Techniques 2
	Instructor: 	Joseph Vybihal
	Date:			February 16, 2015
	Exercises:		ArrayList & LinkedList
 */

import java.util.ArrayList;

public class TestArrayList 
{
	public static void main( String[] args) 
	{
		ArrayList<String> cityList = new ArrayList<String>();
		cityList.add("London");
		cityList.add("Denver");
		cityList.add("Paris");
		cityList.add("Miami");
		cityList.add("Seoul");
		cityList.add("Tokyo");
		
		System.out.println("List size? "+ cityList.size());
		System.out.println("Is Miami in the list? " + cityList.contains("Miami"));
		System.out.println(" The location of Denver in the list? " + cityList.indexOf("Denver"));
		System.out.println(" Is the list empty? " + cityList.isEmpty());
		
		cityList.add(2, "Xian");
		cityList.remove(1);
		
		System.out.println(cityList.toString());
		
		for (int i = cityList.size() - 1; i >= 0; i--)
		{
			System.out.print(cityList.get(i) + " ");
			System.out.println();
		}
	}
}