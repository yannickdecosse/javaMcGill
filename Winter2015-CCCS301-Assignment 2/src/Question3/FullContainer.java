/*
 * Name:		Yannick Decosse
 * Course ID:	CCCS-301-751 - Programming Techniques 2
 * McGill ID:	260551160
 * Instructor: 	Joseph Vybihal
 * Date:		March 2, 2015
 * 
 * Subject:		Assignment 3: Polymorphism, Interfaces & Abstract
 * Details:		Full Container class using Object class
 * File name:	FullContainer.java
 * Purpose:		Using Object class to create Full Container for use in a Bank Account system 
 * IDE:			Eclipse v.Luna Standard Edition
 * 
 */

package Question3;

public class FullContainer extends ContainerVer1 implements CompareObjects
{
	//	Initialize size to keep track of size of parent's array
	private int size;
	
	FullContainer (int size)
	{
		super(size);
		this.size = size;
	}
	
	//	Overriding find method of ContainerVer1 to find any kind of Object
	@Override
	public int find(Object item)
	{
		//	Initialize pointer to find first cell where item equals to object in cell [pointer]
		int pointer = 0;
		//	Return value is set to -1 by default (value not found)
		int returnValue = -1;
		
		while (pointer < size)
		{
			//	If cell is empty, skip it
			if (super.get(pointer) == null)
			{
				pointer++;
			}

			//	Compare Account number of both objects if item is an instance of BankAccount
			else if (((BankAccount)super.get(pointer)).equals(((BankAccount)item)))
			{
				returnValue = pointer;
				break;
			}
				
			else
			{
				pointer++;
			}
		}
		
		return returnValue;
	}
	
	//	Implement duplicate method from interface CompareObjects
	public void duplicate(int index)
	{
		if (index < 0 || index >= size || super.get(index) == null)
		{
			System.out.println("Sorry: no such account found in our system!");
		}
		
		else if (super.add(super.get(index)))
		{
			System.out.println("The account has been duplicated.");
		}
			
		else if (!super.add(super.get(index)))
		{
			System.out.println("Sorry: System cannot duplicate account. No more spaces available in our system!");
				
		}
	}
	
	//	Implement equals method from interface CompareObjects
	@Override
	public boolean equals(Object o)
	{
		
		if (o == null)
		{
			return false;
		}

		else if (this == o)
		{
			return true;
		}
		
		else
		{
			return false;
		}
	}
}
