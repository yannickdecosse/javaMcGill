/*
 * Name:		Yannick Decosse
 * Course ID:	CCCS-301-751 - Programming Techniques 2
 * McGill ID:	260551160
 * Instructor: 	Joseph Vybihal
 * Date:		April 1, 2015
 * 
 * Subject:		Assignment 4: Generics & GUI
 * Details:		Using Generics with a data structure together with Swing to create a multi file airport application
 * File name:	Passenger.java
 * Purpose:		Use Generics and Swing library
 * IDE:			Eclipse v.Luna Standard Edition
 * 
 */

package Question6;

public class Passenger
{
	private Itinerary itinerary;
	private String passengerName;
	private int seatRow;
	private int seatColumn;
	private int planeID;
	
	//	Default no-args constructor
	public Passenger() {};
	
	//	Default constructor
	public Passenger(String nameOfPassenger)
	{
		passengerName = nameOfPassenger;
		itinerary = new Itinerary(passengerName);
	}
	
	//	Set the seat row: must be 1 or 2	
	public void setSeatRow(int row)
	{
		seatRow = row;
	}
	
	//	Set the seat column
	public void setSeatColumn(int col)
	{
		seatColumn = col;
	}
	
	//	Set the Plane ID		
	public void setPlaneID(int id)
	{
		planeID = id;
	}
	
	//	Get the Seat row		
	public int getSeatRow()
	{
		return seatRow;
	}
	
	//	Get the Seat Column	
	public int getseatColumn()
	{
		return seatColumn;
	}
	
	//	Get the Plane ID
	public int getplaneID()
	{
		return planeID;
	}
	
	//	Get the Passenger name
	public String getPassengerName()
	{
		return passengerName;
	}
	
	//	Add new item in Passenger itinerary
	public boolean addItem(String item)
	{
		if (itinerary.add(item))
		{
			return true;
		}
		
		else
		{
			return false;
		}
	}
	
	//	Delete item in Passenger itinerary
	public boolean deleteItem(int index)
	{
		if (itinerary.delete(index))
		{
			return true;
		}
		
		else
		{
			return false;
		}
	}
	
	//	Move item to another position in Passenger itinerary
	public boolean moveItem(int indexFrom, int indexTo)
	{
		if (itinerary.move(indexFrom, indexTo))
		{
			return true;
		}
		
		else
		{
			return false;
		}
	}
	
	//	Get the itinerary object
	public Itinerary getItinerary()
	{
		return itinerary;
	}
}
