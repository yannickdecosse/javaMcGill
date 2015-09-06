package Assignment2;
/*
 * Name:		Yannick Decosse
 * Course ID:	CCCS-301-751 - Programming Techniques 2
 * McGill ID:	260551160
 * Instructor: 	Dr. Hang Lau
 * Date:		February 22, 2015
 * 
 * Subject:		Assignment 2: Time-driven simulation program
 * Details:		Constructing a queuing system implementing a clock as a counter
 * File name:	ServerList.java
 * Purpose:		Queues & Abstract
 * IDE:			Eclipse v.Luna Standard Edition
 * 
 */

public class ServerList 
{
	private int numOfServers;
	private Server[] servers;
	
	//	Default constructor to initialize a list of servers
	public ServerList()
	{
		numOfServers = 1;
		servers = new Server[numOfServers];
	}
	
	//	Constructor to initialize a list of servers specified by num.
	public ServerList(int num)
	{
		numOfServers = num;
		servers = new Server[numOfServers];
		
		for (int i = 0; i < num; i++)
		{
			servers[i] = new Server();
		}
	}
	
	
	//	Method to search the list of servers for a free server, return the ID of a 
	//	free server if found, else return -1.
	public int getFreeServerID() 
	{
		int id = -1;
		
		for (int i = 0; i < servers.length; i++)
		{
			if (servers[i] == null)
			{
				continue;
			}
			
			else if (servers[i].isFree() == true)
			{
				id = i;
			}
		}

		return id;
	}
	
	//	Method to return the number of busy servers.
	public int getNumberOfBusyServers() 
	{
		int busy = 0;
		
		for (int i = 0; i < servers.length; i++)
		{
			if (servers[i] == null)
			{
				continue;
			}
			
			else if (servers[i].isFree() == false)
			{
				busy++;
			}
		}
		
		return busy;
	}
	
	
	//	Method to set a server to "busy".
	//	Postcondition:	To serve the customer specified by cCustomer the server specified by serverID is set
	//					to "busy", and the transaction time is set according to the parameter tTime.
	public void setServerBusy(int serverID, Customer cCustomer, int tTime)
	{
		servers[serverID].setBusy();
		servers[serverID].setCurrentCustomer(cCustomer);
		servers[serverID].setTransactionTime(tTime);
	}
	
	
	//	Method to set a server to "busy".
	//	Postcondition:	To serve the customer specified by Customer, the server specified by serverID is set
	//					to "busy", and the transaction time is set according to the customer’s transaction time.
	public void setServerBusy(int serverID, Customer cCustomer) 
	{
		servers[serverID].setBusy();
		servers[serverID].setCurrentCustomer(cCustomer);
		servers[serverID].setTransactionTime(cCustomer.getTransactionTime());
		
	}
	
	
	//	Method to update the transaction time of each busy server.
	//	Postcondition:	The transaction time of each busy server is decremented by one time unit. 
	//					If the transaction time of a busy server is reduced to zero, 
	//					the server is set to "free" and a message indicating which customer was served, 
	//					together with the customer's departing time, is printed on the screen.
	public void updateServers()
	{
		for (int i = 0; i < servers.length; i++)
		{
			if (servers[i] == null)
			{
				continue;
			}
			
			else if (servers[i].isFree() == false && servers[i].getRemainingTransactionTime() > 0)
			{
				servers[i].decreaseTransactionTime();
				
				if (servers[i].getRemainingTransactionTime() == 0)
				{
					servers[i].setFree();
					System.out.println("Server number " + (i + 1) + " |--> Customer number " + servers[i].getCurrentCustomerNumber()
							+ " departed at clock unit " + (servers[i]. getCurrentCustomerArrivalTime() + servers[i].getCurrentCustomerTransactionTime() + servers[i].getCurrentCustomerWaitingTime()));
				}
			}
		}
	}
}
