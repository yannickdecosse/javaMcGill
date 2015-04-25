/*
	Name:			Yannick Decosse
	McGill ID:		260551160
	Course ID:		CCCS-315-761 - Data Structures & Algorithms
	Instructor: 	Dr. Hang Lau
	Date:			January 23, 2015
	Subject:		Assignment 1: Multiplication & Differentiation of Polynomials
	IDE:			Eclipse v.Luna Standard Edition
*/

import java.util.Collections;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;
import java.text.DecimalFormat;

public class Polynomial
{
	private LinkedList<Term> polynomial;
	
	public Polynomial()
	{
		polynomial = new LinkedList<Term>();
	}
	
	//	Copy constructor
	public Polynomial(Polynomial q)
	{
		this.polynomial = q.polynomial;
	}
	
	public void addTerm(Term t)
	{	
		//	If Coefficient of Term is 0, do not add
		if (t.getCoefficient() == 0) {
            return;
        }

		//	Check if a term with same exponent already exist using an Iterator to traverse the List.
		//	If yes, add new Term to existing Term.
		ListIterator<Term> iterator = polynomial.listIterator();
		
		//	Counter is used to add Polynomial to list if a Term with same exponent does not already exist in list
		int counterCheck = 0;

			while (iterator.hasNext())
			{
				Term check = (Term) iterator.next();
				
				if (t.getExponent() == check.getExponent())
				{
					check.setCoefficient(t.getCoefficient() + check.getCoefficient());
					counterCheck++;
					
					if (check.getCoefficient() == 0)
					{
						iterator.remove();
					}				
				}	
			}
		
		//	If Term with similar exponent does not already exist in List, add Term
		if (counterCheck == 0)
		{
			polynomial.add(t);
		}
	}
	
	//	Method to multiply two Polynomials
	public Polynomial multiply(Polynomial q)
	{
		Polynomial multiply = new Polynomial();
		
		ListIterator<Term> iteratorPx = polynomial.listIterator();
		ListIterator<Term> iteratorQx = q.polynomial.listIterator();
		
		while (iteratorQx.hasNext())
		{
			Term checkQx = (Term) iteratorQx.next();
			
			while (iteratorPx.hasNext())
			{	
				Term checkPx = (Term) iteratorPx.next();	
				multiply.addTerm(new Term(checkPx.getExponent() + checkQx.getExponent(), checkPx.getCoefficient() * checkQx.getCoefficient()));			
			}
			
			//	Reset iterator of Polynomial p(x) to beginning of list to continue multiplication of 2nd and consequent Terms of q(x)
			iteratorPx = polynomial.listIterator();			
		}
		
		return multiply;
	}
	
	//	Method to differentiate Polynomial
	public Polynomial derivative()
	{
		Polynomial derivativePx = new Polynomial();	
		
		ListIterator<Term> iterator = polynomial.listIterator();
		
			while (iterator.hasNext())
			{
				Term check = (Term) iterator.next();	
				derivativePx.addTerm(new Term(check.getExponent() - 1, check.getCoefficient() * check.getExponent()));
			}
		
		return derivativePx;
	}
	
	//	Overriding the toString() Method of LinkedList to display Polynomials 
	public String toString()
	{
		String display = "";
		String toDisplay = "";
		DecimalFormat decimalFormat = new DecimalFormat();
					  decimalFormat.setDecimalSeparatorAlwaysShown(false);
		
		ListIterator<Term> iterator = polynomial.listIterator();
		
		//	Sorting LinkedList before output
		Collections.sort(polynomial);
		
		while(iterator.hasNext())
		{		
			Term check = (Term) iterator.next();
			
			if (!iterator.hasNext())
			{
				display += (decimalFormat.format(check.getCoefficient())) + "x^" + check.getExponent();
			}

			else
			{
				display += (decimalFormat.format(check.getCoefficient())) + "x^" + check.getExponent() + " + ";
			}		
		}
		
		//	Remove '+' when followed by '-', remove 'x^0', remove 1 before '1x' and replace 'x^1' by 'x'	
		toDisplay = display.replaceAll("([+])(\\s)([-])(\\d)", "$3 $4").replaceAll("x\\^0", "").replaceAll("x\\^1\\s", "x ").replaceAll("x\\^1$", "x")
				   		   .replaceAll("^1x\\s", "x ").replaceAll("^-1x\\s", "-x ").replaceAll("^-1x\\^", "-x^").replaceAll("^1x$", "x").replaceAll("^-1x$", "- x")
				   		   .replaceAll("-1x$", "- x").replaceAll("-1x\\^", "- x^").replaceAll("^$", "0").replaceAll("^1x", "x").replaceAll("\\s1x", " x");
				   	
		return toDisplay;
	}
	
	//	Static method to validate Polynomial entered by user
	public static String validatePolynomial(String polynomial)
	{
		String validate;
		
		//	Remove multiples spaces, '^', '+' & '-', add 1 before x (e.g: x or x^2), convert all int coefficients to double
		//	and add x^0 for digits without x 
		validate = polynomial.replaceAll("([*]+)",  "").replaceAll(" ",  "").replaceAll("([x]+)",  "x").replaceAll("([-])(\\1{1,})", "$1").replaceAll("([\\^])(\\1{1,})", "$1").replaceAll("(\\d)([\\^])", "$1x$2").replaceAll("([+])(\\1{1,})", "$1").replaceAll("([+-])([\\d]+)([+-])", "$1$2x^0$3").replaceAll("(^)([+])(\\d|[-])", "$1$3")
							 .replaceAll("(^)([-]+)(\\d)", "$1-$3").replaceAll("(\\d|[x])([+-]+)$", "$1").replaceAll("([-])([+])", "$1").replaceAll("([+])([-])", "$2").replaceAll("([+-])([\\d]+)$", "$1$2x^0")
							 .replaceAll("([-+])([x])", "$11$2").replaceAll("([x])$", "$1^1").replaceAll("([+-]|^)([\\d]+|[\\d]+[.][\\d]+)([+-]|$)", "$1$2x^0$3").replaceAll("([+|-][\\d]+)([x])", "$1.0$2").replaceAll("([+-]|^|\\d)([x])([+-]|$)", "$1$2^1$3").replaceAll("^([x])", "1.0$1").replaceAll("^([\\d]+)([x])", "$1.0$2");

		//	If user input is incorrect, display error message & ask user to enter new Polynomial for P(x)
		if (!validate.matches("[0-9x+-.\\^]+"))
		{
			//	If wrong input type, print error message & user can enter selection again
			System.out.println("\nError! Enter only digits, dots, mathematical operators except '/' and only letter x!");
			System.out.print("\nPlease enter Polynomial again: ");
		}
	
		return validate;
	}
	
	//	Method to add Terms to Polynomial
	public static Polynomial createPolynomial(String polynomial)
	{
		Polynomial polynomialPQx = new Polynomial();
		
		//	Using Regex to keep only integers from user input
		String a = polynomial.replaceAll("([x\\^])", " ").replaceAll("[+]", " ").replaceAll("([-+][\\d]+[\\.][\\d]+)", " ");
		
		//	Using Regex to keep only doubles from user input
		String b = polynomial.replaceAll("(x\\^[\\d]+)", " ").replaceAll("[+]", " ");
		
		//	Create 2 lists, one for Coefficients and one for Exponents from user Polynomial input.
		//	Then using the 2 lists to add Terms to new Polynomial and return to display
		Scanner scanInt = new Scanner(a);
		Scanner scanDouble = new Scanner(b);
		
		LinkedList<Integer> listInt = new LinkedList<Integer>();
		LinkedList<Double> listDouble = new LinkedList<Double>();
	
			while(scanInt.hasNext())
			{
				if (scanInt.hasNextInt())
				{
					listInt.add(scanInt.nextInt());
				}
		
				else
				{
					scanInt.next();
				}
			}
	
			while(scanDouble.hasNext())
			{
				if (scanDouble.hasNextDouble())
				{
					listDouble.add(scanDouble.nextDouble());
				}
		
				else
				{
					scanDouble.next();
				}
			}
			
		// Close Scanner objects
		scanInt.close();
		scanDouble.close();
		
		//	Using a loop to add Terms to Polynomial object
		ListIterator<Integer> iteratorInt = listInt.listIterator();
		ListIterator<Double> iteratorDouble = listDouble.listIterator();
		
		while (iteratorInt.hasNext() && iteratorDouble.hasNext())
		{
			Integer aX = (Integer) iteratorInt.next();
			Double bX = (Double) iteratorDouble.next();
			
			polynomialPQx.addTerm(new Term(aX, bX));
		}
			
		// Return newly created Polynomial
		return polynomialPQx;
	}
}
