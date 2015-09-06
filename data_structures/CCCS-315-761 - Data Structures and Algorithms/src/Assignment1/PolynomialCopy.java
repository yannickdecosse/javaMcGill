package Assignment1;
/*
	Name:			Yannick Decosse
	McGill ID:		260551160
	Course ID:		CCCS-315-761 - Data Structures & Algorithms
	Instructor: 	Dr. Hang Lau
	Date:			January 23, 2015
	Subject:		Assignment 1: Multiplication & derivative of polynomials
	IDE:			Eclipse v.Luna Standard Edition
*/

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.ListIterator;

public class PolynomialCopy
{
	private LinkedList<Term> polynomial;
	
	public PolynomialCopy()
	{
		polynomial = new LinkedList<Term>();
	}
	
	//	Copy constructor
	public PolynomialCopy(PolynomialCopy q)
	{
		this.polynomial = q.polynomial;
	}
	
	public void addTerm(Term t)
	{	
		//	Add first term to polynomial;
		if (t.getCoefficient() == 0) {
            return;
        }

		/*
		//	Check if a term with same exponent already exist using an Iterator to traverse the List.
		//	If yes, add new Term to existing Term. Else add in ascending order.
		ListIterator<Term> iterator = polynomial.listIterator();
		
		while (iterator.hasNext())
		{
			Term check = (Term) iterator.next();
			
			if (t.getExponent() == check.getExponent())
			{
				if ((t.getCoefficient() + check.getCoefficient()) != 0)
				{
					check.setCoefficient( t.getCoefficient() + check.getCoefficient());
				}
				
				else
				{
					//	If when adding both Terms Coefficient is 0, remove Term
					iterator.remove();
				}
			}
			
			//	Put Term in ascending order
			if (t.getExponent() > check.getExponent())
			{
				iterator.next();
				iterator.add(t);
			}
			
			if (t.getExponent() < check.getExponent())
			{
				iterator.previous();
				iterator.add(t);
			}
			//	If Term with Exponent e does not already exist or is not greater than existing Terms
			
		}*/
		/*
		ListIterator<Term> iterator = polynomial.listIterator();

		while (iterator.hasNext())
		{
			Term check = (Term) iterator.next();
			
			if (t.getExponent() > check.getExponent())
			{
				iterator.next();
				iterator.add(t);
			}
			
			else
			{
				iterator.add(t);
			}
		}*/
		
		
		ListIterator<Term> iterator = polynomial.listIterator();
		
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

			if (counterCheck == 0)
			{
				polynomial.add(t);
			}
			
			else
			{
				return;
			}


		
		/*
		ListIterator<Term> iterator = polynomial.listIterator();
		
		int counterSame = 0;
		int counterGreater = 0;
		int counterLess = 0;
		Term removeT = t;
		
		if (!iterator.hasNext())
		{
			iterator.add(t);
		}
		

			while (iterator.hasNext())
			{
				Term check = (Term) iterator.next();
				
				//	Check if Term entered has the same exponent as another Term already entered
				if (t.getExponent() == check.getExponent())
				{
					counterSame = iterator.nextIndex();
					t.setCoefficient(t.getCoefficient() + check.getCoefficient());
					removeT = check;
					
						if (t.getCoefficient() == 0)
						{
							return;
						}
					
				}
				

				
				if (t.getExponent() > check.getExponent() && iterator.hasNext())
				{
					counterGreater = iterator.nextIndex();
				}

				
				else
				{
				
					if (t.getExponent() > check.getExponent())
					{
						counterGreater = iterator.nextIndex();
					}
				}
				
			}				
		
		if (counterSame != 0)
		{
			polynomial.remove(removeT);
			polynomial.set(counterSame - 1, t);
		}
		else
		{
			if (counterGreater != 0)
			{
				polynomial.add(counterGreater - 1, t);
			}
		}*/
	}
	
	//	Method to multily two Polynomials
	public Polynomial multiply(Polynomial q)
	{
		Polynomial multiply = new Polynomial();
		
		return multiply;
	}
	
	//	Method to return derivative of Polynomial
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
	
	//	Overriding the toString() Method of LinkedList to display polynomials 
	public String toString()
	{
		String display = "";
		String toDisplay = "";
		
		ListIterator<Term> iterator = polynomial.listIterator();
		
		//	Sorting LinkedList before output
		Collections.sort(polynomial);
		
		while(iterator.hasNext())
		{		
			Term check = (Term) iterator.next();
			
			if (!iterator.hasNext())
			{
				display = display + check.getCoefficient() + "x^" + check.getExponent();
			}

			else
			{
				display = display + check.getCoefficient() + "x^" + check.getExponent() + " + ";
			}
			
		}
		
		//	Remove '+' when followed by '-', remove 'x^0' and replace 'x^1' by 'x'	
		toDisplay = display.replaceAll("([+])(\\s)([-])(\\d)", "$3 $4")				  
				   		   .replaceAll("x\\^1\\s", "x ")
				   		   .replaceAll("x\\^1$", "x")
				   		   .replaceAll("x\\^0", "");
				   	
		return toDisplay;
	}
	
	//	Static method to validate Polynomial entered by user
	public static String validatePolynomial(String polynomial)
	{
		String validate;
		
		//	Remove multiples spaces, '^', '+' & '-', add 1 before x (ex: x or x^2), convert all int coefficients to double
		//	and add x^0 for digits without x 
		validate = polynomial.replaceAll("([*]+)",  "")
							 .replaceAll(" ",  "")
							 .replaceAll("([x]+)",  "x")
							 .replaceAll("([-])(\\1{1,})", "$1")
							 .replaceAll("([\\^])(\\1{1,})", "$1")
							 .replaceAll("(\\d)([\\^])", "$1x$2")
							 .replaceAll("([+])(\\1{1,})", "$1")
							 .replaceAll("([+-])(\\d)([+-])", "$1$2x^0$3")
							 .replaceAll("(^)([+])(\\d|[-])", "$1$3")
							 .replaceAll("(^)([-]+)(\\d)", "$1-$3")
							 .replaceAll("(\\d|[x])([+-]+)$", "$1")
							 .replaceAll("([-])([+])", "$1")
							 .replaceAll("([+])([-])", "$2")
							 .replaceAll("([+-])(\\d)$", "$1$2x^0")
							 .replaceAll("([-+])([x])", "$11$2")
							 .replaceAll("([x])$", "$1^1")
							 .replaceAll("([+-]|^)(\\d|[\\d]+[.][\\d]+)([+-]|$)", "$1$2x^0$3")
							 .replaceAll("([+|-][\\d]+)([x])", "$1.0$2")
							 .replaceAll("([+-]|^|\\d)([x])([+-]|$)", "$1$2^1$3")
							 .replaceAll("^([x])", "1.0$1")
							 .replaceAll("^([\\d]+)([x])", "$1.0$2");

		//	If user input is incorrect, display error message & ask user to enter new Polynomial for P(x)
		if (!validate.matches("[0-9x+-.\\^]+"))
		{
			//	If wrong input type, print error message & user can enter selection again
			System.out.println("\nError! Enter only digits, dots, mathematical operators except '/' and only letter x!");
			System.out.print("\nPlease enter Polynomial again: ");
		}
		
		return validate;
	}
	
	//	Set Comparator for exponent between Terms in Polynomial Linked List
	public static class ByExponent implements Comparator<Term> {

        @Override
        public int compare(Term a, Term b) {
        	return a.getExponent() > b.getExponent() ? 1 : (a.getExponent() < b.getExponent() ? -1 : 0);
        }
    }
}
