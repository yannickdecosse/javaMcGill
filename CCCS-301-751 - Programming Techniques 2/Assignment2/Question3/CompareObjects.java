/*
 * Name:		Yannick Decosse
 * Course ID:	CCCS-301-751 - Programming Techniques 2
 * McGill ID:	260551160
 * Instructor: 	Joseph Vybihal
 * Date:		March 2, 2015
 * 
 * Subject:		Assignment 3: Polymorphism, Interfaces & Abstract
 * Details:		Full Container class using Object class
 * File name:	CompareObjects.java
 * Purpose:		Using Object class to create Full Container for use in a Bank Account system 
 * IDE:			Eclipse v.Luna Standard Edition
 * 
 */

package Question3;

public interface CompareObjects
{
	//	Method to duplicate the object at index provided and make an 
	//	exact copy in the next available cell of the array using the add()
	//	method of ContainerVer1
	public void duplicate(int index);
	
	//	Method to give any kind of Object the possibility to compare
	//	with another Object to check if they are equal
	public boolean equals(Object o);
}
