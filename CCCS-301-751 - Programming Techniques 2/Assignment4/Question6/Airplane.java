/*
 * Name:		Yannick Decosse
 * Course ID:	CCCS-301-751 - Programming Techniques 2
 * McGill ID:	260551160
 * Instructor: 	Joseph Vybihal
 * Date:		April 1, 2015
 * 
 * Subject:		Assignment 4: Generics & GUI
 * Details:		Using Generics with a data structure together with Swing to create a multi file airport application
 * File name:	Airplane.java
 * Purpose:		Use Generics and Swing library
 * IDE:			Eclipse v.Luna Standard Edition
 * 
 */

package Question6;

import java.util.Arrays;

public class Airplane
{
	private Queue<Passenger> passengers;
	private int planeID;
	private boolean[][] seats;
	
	//	Default no-args constructor
	public Airplane() {};
	
	//	Default constructor
	public Airplane(int id, int size)
	{
		planeID = id;
		seats = new boolean[2][size];
		//	Setting all seats to false
		for (boolean[] row : seats)
		{
			Arrays.fill(row, false);
		}
		passengers = new Queue<Passenger>();
	}
	
	//	Enter a passenger in airplane
	public void setPassenger(Passenger newPassenger)
	{
		passengers.enqueue(newPassenger);
	}
	
	//	Set state of seat
	public void setSeat(int seatRow, int seatColumn)
	{
		if (seatRow < 0 || seatRow >= seats.length)
		{
			return;
		}
		
		else if (seatColumn < 0 || seatColumn >= seats[seatRow].length)
		{
			return;
		}
		
		else
		{
			seats[seatRow][seatColumn] = true;
		}
	}	
	
	//	Get state of seat
	public boolean getSeat(int seatRow, int seatColumn)
	{
		if (seatRow < 0 || seatRow >= seats.length)
		{
			return true;
		}
		
		else if (seatColumn < 0 || seatColumn >= seats[seatRow].length)
		{
			return true;
		}
		
		else
		{
			return seats[seatRow][seatColumn];
		}
	}
	
	//	Get plane id
	public int getPlaneID()
	{
		return planeID;
	}
	
	//	Get first passenger in queue
	public Passenger getPassenger()
	{
		return passengers.dequeue();
	}
}