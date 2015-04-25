/*
	Name:			Yannick Decosse
	McGill ID:		260551160
	Course ID:		CCCS-315-761 - Data Structures & Algorithms
	Instructor: 	Dr. Hang Lau
	Date:			January 25, 2015
	Subject:		Assignment 1: Multiplication & derivative of Polynomials
	IDE:			Eclipse v.Luna Standard Edition
*/

import java.util.Scanner;

public class TestPolynomial
{
	public static void main(String[] args)
	{
		//	Initialize variables and instantiate Polynomial objects
		char choice = 'Y';
		
		//	Variables used to validate input for Polynomials p(x) & q(x) from user
		String validatePx;
		String validateQx;
		
		Scanner key = new Scanner(System.in);
		Scanner poly = new Scanner(System.in);
		
		Polynomial px = new Polynomial();
		Polynomial qx = new Polynomial();
		Polynomial multiply = new Polynomial();
		Polynomial derivative = new Polynomial();
			
			//	User will be asked to enter Polynomials p(x) a& q(x) until choosing 'N' to quit system
			while (choice == 'Y')
			{
				//	Create a header when running program
				System.out.println("\n----------------------------------------------------------------------------------------------------------");
				System.out.println("           Multiplication & Differentiation of Polynomials System          ");
				System.out.println("----------------------------------------------------------------------------------------------------------\n");
				
			
				//	Ask user to enter polynomial p(x)
				System.out.print("Please enter p(x): ");				
				do
				{
					String pX = poly.nextLine();
					validatePx = Polynomial.validatePolynomial(pX);
				}				
				// User must input correct Polynomial before system continues running
				while (!validatePx.matches("[0-9x+-.\\^]+"));
				

				
				//	Ask user to enter polynomial q(x)
				System.out.print("Please enter q(x): ");				
				do
				{
					String qX = poly.nextLine();
					validateQx = Polynomial.validatePolynomial(qX);
				}				
				// User must input correct Polynomial before system continues running
				while (!validateQx.matches("[0-9x+-.\\^]+"));
				
								
				px = Polynomial.createPolynomial(validatePx);
				qx = Polynomial.createPolynomial(validateQx);
				multiply = px.multiply(qx);
				derivative = px.derivative();
				
				
				System.out.println("\n----------------------------------------------------------------------------------------------------------");
				System.out.println("              p(x) = " + px);				
				System.out.println("              q(x) = " + qx);
				System.out.println("       p(x) * q(x) = " + multiply);
				System.out.println("Derivative of p(x) = " + derivative);
				System.out.println("----------------------------------------------------------------------------------------------------------");
				
		
				// 	After set of calculations, ask user to start over or leave system
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
			
			//	Closing Scanner objects
			key.close();
			poly.close();
			
			//	Create a footer when stopping program
			System.out.println("\n\n----------------------------------------------------------------------------------------------------------");
			System.out.println("                               System terminated... Thank you!                               ");
			System.out.println("----------------------------------------------------------------------------------------------------------");
	}
}
