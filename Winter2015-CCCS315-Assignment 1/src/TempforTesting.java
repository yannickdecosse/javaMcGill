/*
	Name:			Yannick Decosse
	McGill ID:		260551160
	Course ID:		CCCS-315-761 - Data Structures & Algorithms
	Instructor: 	Dr. Hang Lau
	Date:			January 23, 2015
	Subject:		Assignment 1: Multiplication & derivative of Polynomials
	IDE:			Eclipse v.Luna Standard Edition
*/

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TempforTesting
{
	public static void main(String[] args)
	{
		char choice = 'Y';
		String validatePolynomial = "x";
		Scanner key = new Scanner(System.in);
		Scanner poly = new Scanner(System.in);
		
		try
		{
			while (choice == 'Y' || choice == 'y')
			{
				//	Create a header when running program
				System.out.println("\n****************************************************************************");
				System.out.println("                 Multiplication & derivative of Polynomials                 ");
				System.out.println("****************************************************************************");
				
				
				//	Ask user to enter first polynomial
				System.out.print("Please enter P(x): ");
				
				do
				{
					String pX = poly.nextLine();
					validatePolynomial = pX.replaceAll("\\s", "")
								 		   .replaceAll("([*]+)",  "")
								 		   .replaceAll("([-])(\\1{1,})", "$1")
								 		   .replaceAll("([\\^])(\\1{1,})", "$1")
								 		   .replaceAll("(\\d)([\\^])", "$1x$2")
								 		   .replaceAll("([+])(\\1{1,})", "$1")
								 		   .replaceAll("([+-])(\\d)([+-])", "$1$2^0$3")
								 		   .replaceAll("([+-]|^)(\\d|[\\d]+[.][\\d]+)([+-]|$)", "$1$2x^0$3")
								 		   .replaceAll("(^)([+])(\\d|[-])", "$1$3")
								 		   .replaceAll("(^)([-]+)(\\d)", "$1-$3")
								 		   .replaceAll("(\\d)([+-]+)$", "$1")
								 		   .replaceAll("([+-]|^|\\d)([x])([+-]|$)", "$1$2^1$3");

					System.out.println(validatePolynomial);
				
					//	If user input is incorrect, display error message & ask user to enter new Polynomial for P(x)
					if (!validatePolynomial.matches("[0-9x+-.\\^]+"))
					{
						//	If wrong input type, print error message & user can enter selection again
						System.out.println("\nError! Enter only digits, dots, mathematical operator except 'x' and only leter x!");
						System.out.print("\nPlease enter P(x): ");
					}
				
				}
				// User must input correct Polynomial before system continues running
				while (!validatePolynomial.matches("[0-9x+-.\\^]+"));



				//Pattern px = Pattern.compile("\\d+\\[.]+\\[^]+\\[-]+\\[*]+\\[x]+");
				//Matcher mx = px.matcher(check);
				
				/*
				if (check.matches("[0-9x+-]+"))
				{
					System.out.println("Good");
				}
				
				else
				{
					System.out.println("Bad");
				}
				*/
				
				/* 
				while (!polyP.hasNext("[0-9.x^*+-]+"))
				{
					//	If wrong input type, print error message & user can enter selection again
					System.out.println("\nError! Enter only digits, dots, mathematical operator except 'x' and only leter x!");
					System.out.print("\nPlease enter P(x): ");
					polyP.next();
				}
				
				String temp = polyP.next();
				System.out.println(temp);
				*/
				
				// 	After set of calculations, ask user to start again or leave system
				System.out.print("\nDo you want to perform another set of Polynomial calculations? ");
				
				while (!key.hasNext("[YyNn]"))
				{
					//	If wrong input type, print error message & user can enter selection again
					System.out.println("\nError! Enter 'Y' or 'N'. Try again.");
					System.out.print("\nDo you want to perform another set of Polynomial calculations? ");
					key.next();
				}
				
				choice = key.next().toUpperCase().charAt(0);
				
				if (choice == 'N')
				{
					break;
				}				
			}
		}
		
		finally
		{			
			key.close();
			poly.close();
			
			//	Create a footer when stopping program
			System.out.println("\n\n****************************************************************************");
			System.out.println("                        Leaving System... Thank you!                        ");
			System.out.println("****************************************************************************");
		}
	}
}
