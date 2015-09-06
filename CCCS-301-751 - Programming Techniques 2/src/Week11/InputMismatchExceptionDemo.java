package Week11;
/*
	Name:			Yannick Decosse
	McGill ID:		260551160
	Course ID:		CCCS-301-751 - Programming Techniques 2
	Instructor: 	Joseph Vybihal
	Date:			March 16, 2015
	Exercises:		Exception Handling & IO
 */

import java.util.*;

public class InputMismatchExceptionDemo 
{
  public static void main(String[] args) 
  {
    Scanner input = new Scanner(System.in);
    boolean continueInput = true;

    do 
    {
      try 
      {
        System.out.print("Enter an integer: ");
        int number = input.nextInt();
  
        // Display the result
        System.out.println(
          "The number entered is " + number);
        
        continueInput = false;
      } 
      catch (InputMismatchException ex) 
      {
        System.out.println("Try again. (" + "Incorrect input: an integer is required)");
        input.nextLine(); // discard input 
      }
    } while (continueInput);
    
    input.close();
  }
}
