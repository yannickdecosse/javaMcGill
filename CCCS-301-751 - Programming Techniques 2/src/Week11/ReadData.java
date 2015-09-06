package Week11;
/*
	Name:			Yannick Decosse
	McGill ID:		260551160
	Course ID:		CCCS-301-751 - Programming Techniques 2
	Instructor: 	Joseph Vybihal
	Date:			March 16, 2015
	Exercises:		Exception Handling & IO
 */

import java.util.Scanner; 

public class ReadData 
{
  public static void main(String[] args) throws Exception 
  {
    // Create a File instance
    java.io.File file = new java.io.File("test2.txt");

    // Create a Scanner for the file
    Scanner input = new Scanner(file);
    String firstName = "";
    // Read data from a file
    while (input.hasNext()) 
    {
      firstName = input.nextLine();
      //String mi = input.next();
      //String lastName = input.next();
      //int score = input.nextInt();
      //System.out.println(
        //firstName + " " + mi + " " + lastName + " " + score);
      System.out.println(firstName);
    }
    
    // Close the file
    input.close();
  }
}
