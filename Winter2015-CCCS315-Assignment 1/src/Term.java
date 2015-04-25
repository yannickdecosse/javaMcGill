/*
	Name:			Yannick Decosse
	McGill ID:		260551160
	Course ID:		CCCS-315-761 - Data Structures & Algorithms
	Instructor: 	Dr. Hang Lau
	Date:			January 23, 2015
	Subject:		Assignment 1: Multiplication & derivative of polynomials
	IDE:			Eclipse v.Luna Standard Edition
	Git:			Yes
*/

public class Term implements Comparable<Term>
{
	private int exponent;
	private double coefficient;
	
	public Term()
	{
		exponent = 1;
		coefficient = 1.0;	
	}
	
	public Term(int exponent, double coefficient)
	{
		
		this.exponent = exponent;
		this.coefficient = coefficient;
	}
	
	public int getExponent()
	{
		return exponent;
	}
	
	public double getCoefficient()
	{
		return coefficient;
	}
	
	public void setExponent(int exponent)
	{
		this.exponent = exponent;
	}
	
	public void setCoefficient(double coefficient)
	{
		this.coefficient = coefficient;
	}
	
	//	Using compareTo with exponent variable to sort Terms in ascending order
	@Override
    public int compareTo(Term a) {
        return this.exponent > a.getExponent() ? 1 : (this.exponent < a.getExponent() ? -1 : 0);
    }
}