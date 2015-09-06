package Week2;
/*
	Name:			Yannick Decosse
	McGill ID:		260551160
	Course ID:		CCCS-301-751 - Programming Techniques 2
	Instructor: 	Joseph Vybihal
	Date:			January 12, 2015
	Exercises:		Objects & Classes
 */

public class Program2 {

	public static void main(String[] args) {
		int i;
		Example2[] array = new Example2[10];
		
		for (i = 0; i <10; i++)
		{
			array[i] = new Example2(i);
			System.out.println(array[i].y);
		}

	}

}
