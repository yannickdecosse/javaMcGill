/*
 * Name:		Yannick Decosse
 * Course ID:	CCCS-301-751 - Programming Techniques 2
 * McGill ID:	260551160
 * Instructor: 	Joseph Vybihal
 * Date:		February 27, 2015
 * 
 * Subject:		Assignment 3: Polymorphism, Interfaces & Abstract
 * Details:		Basic Container class using Object
 * File name:	ContainerVer1.java
 * Purpose:		Using Object class to create a container implementation
 * IDE:			Eclipse v.Luna Standard Edition
 * 
 */

package Question2;

public class ContainerVer1 
{
	private Object[] array;
	
	ContainerVer1() {}
	
	ContainerVer1(int size)
	{
		array = new Object[size];
	}
	
	public boolean add(Object item)
	{
		//	Initialize pointer to find first available null space in array
		int pointer = -1;
		
		//	Find first available space in array by reverse traversing
		for (int i = array.length - 1; i >= 0 ; i--)
		{
			if (array[i] == null)
			{
				pointer = i;
			}
		}
		
		if (pointer >= 0)
		{
			array[pointer] = item;
			
			return true;
		}
		
		else
		{
			return false;
		}
	}
	
	public Object get(int index)
	{
		if (index < 0 || index >= array.length)
		{
			return null;
		}
		
		else
		{
			return array[index];
		}
	}
	
	public boolean delete(int index)
	{
		if (index < 0 || index >= array.length)
		{
			return false;
		}
		
		else
		{
			array[index] = null;
			
			return true;
		}
	}
	
	public int find(Object item)
	{
		//	Initialize pointer to find first cell where item equals to object in cell [pointer]
		int pointer = 0;
		//	Return value is set to -1 by default (value not found)
		int returnValue = -1;
		
		while (pointer < array.length)
		{
			//	If cell is empty, skip it
			if (array[pointer] == null)
			{
				pointer++;
			}
			
			else if (((String)array[pointer]).equals(((String)item)))
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
	
	public boolean isMember(Object item)
	{		
		if (this.find(item) >= 0)
		{
			return true;
		}
		
		else
		{
			return false;
		}
	}
}
