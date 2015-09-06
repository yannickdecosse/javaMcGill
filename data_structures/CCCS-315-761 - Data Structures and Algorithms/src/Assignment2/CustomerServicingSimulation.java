package Assignment2;
/*
 * Name:		Yannick Decosse
 * Course ID:	CCCS-301-751 - Programming Techniques 2
 * McGill ID:	260551160
 * Instructor: 	Dr. Hang Lau
 * Date:		February 28, 2015
 * 
 * Subject:		Assignment 2: Time-driven simulation program
 * Details:		Constructing a queuing system implementing a clock as a counter
 * File name:	CustomerServicingSimulation.java
 * Purpose:		Queues & Abstract
 * IDE:			Eclipse v.Luna Standard Edition
 * 
 */

import java.io.IOException;
import java.util.Scanner;

public class CustomerServicingSimulation
{
	private static int simulationTime;
	private static int numberOfServers;
	private static int transactionTime;
	private static int timeBetweenCustomerArrival;
	
	public static void main(String[] args) throws IOException
	{
		setSimulationParameters();
		runSimulation();
	}
		
	public static void setSimulationParameters()
	{
		Scanner userChoice = new Scanner(System.in);
		
		//	Create a header when running program
		System.out.println("\n----------------------------------------------------------------------------------------------------------");
		System.out.println("                                 Customer Servicing Simulation Program");
		System.out.println("----------------------------------------------------------------------------------------------------------\n");
		
		//	ENTER SIMULATION TIME
		//	-----------------------------------------------------------------------------------------------------------------------------
		//	Read in and store the simulation time.
		System.out.print("\nPlease enter the Simulation Time: ");
		
		//	Validating input from user
		while (!userChoice.hasNext("[0-9]+"))
		{
			System.out.println("\nError! Enter only integers.");
			System.out.print("\nPlease enter the Simulation Time: ");
			userChoice.next();
		}
		simulationTime = Integer.parseInt(userChoice.next());
		
		//	ENTER NUMBER OF SERVERS	
		//	-----------------------------------------------------------------------------------------------------------------------------	
		//	Read in and store the number of servers.
		System.out.print("\nPlease enter the number of Servers: ");
		
		//	Validating input from user
		while (!userChoice.hasNext("[0-9]+"))
		{
			System.out.println("\nError! Enter only integers.");
			System.out.print("\nPlease enter the number of Servers: ");
			userChoice.next();
		}
		numberOfServers = Integer.parseInt(userChoice.next());
		
		//	ENTER TRANSACTION TIME	
		//	-----------------------------------------------------------------------------------------------------------------------------	
		//	Read in and store the transaction time.
		System.out.print("\nPlease enter the Transaction time: ");
		
		//	Validating input from user
		while (!userChoice.hasNext("[0-9]+"))
		{
			System.out.println("\nError! Enter only integers.");
			System.out.print("\nPlease enter the Transaction time: ");
			userChoice.next();
		}
		transactionTime = Integer.parseInt(userChoice.next());
		
		//	ENTER TIME BETWEEN CUSTOMER ARRIVALS	
		//	-----------------------------------------------------------------------------------------------------------------------------	
		//	Read in and store the time between customer arrivals.
		System.out.print("\nPlease enter the time between customer arrivals: ");
		
		//	Validating input from user
		while (!userChoice.hasNext("[0-9]+"))
		{
			System.out.println("\nError! Enter only integers.");
			System.out.print("\nPlease enter the time between customer arrivals: ");
			userChoice.next();
		}
		timeBetweenCustomerArrival = Integer.parseInt(userChoice.next());	
		
		//	Closing Scanner object
		userChoice.close();		
	}
		
	public static boolean isCustomerArrived(double arvTimeDiff)
	{
		double value;
		value = (double)(Math.random());
		
		return (value > Math.exp(- 1.0/arvTimeDiff));
	}
		
	public static void runSimulation()
	{
		//	Declare and initialize the variables such as the simulation parameters, customer number, clock,
		//	total and average waiting times, number of customers arrived, number of customers served,
		//	number of customers left in the waiting queue, number of customers left with the servers, 
		//	the	waiting queue, a list of servers
		
		ServerList listOfServers = new ServerList(numberOfServers);
		WaitingCustomerQueue queue = new WaitingCustomerQueue();
		
		int customerNumber = 1;
		int totalWaitingTime = 0;
		double averageWaitingTime = 0;
		int customersArrived = 0;
		int customersServed = 0;
		int customersLeftInQueue = 0;
		int customersLeftInServers = 0;
		
		//	Empty space before results
		System.out.println("\n----------------------------------------------------------------------------------------------------------\n");
		
		for (int clock = 1; clock <= simulationTime; clock++)
		{
			//	Update the server list to decrement the transaction time of each busy server by one time unit.
			listOfServers.updateServers();
			
			//	If the customer’s queue is nonempty, increment the waiting time of each customer by one time unit.
			if (!queue.isEmpty())
			{
				queue.updateWaitingQueue();
			}
			
			if (isCustomerArrived(timeBetweenCustomerArrival))
			{
				//	A customer just arrives, increment the number of customers by 1 and add the new
				//	customer to the queue.
				customersArrived++;
				queue.enqueue(new Customer(customerNumber, clock, 0, transactionTime));
				
				//	Output the following message to the screen:
				//	"Customer number XXX arrived at time unit YYY”
				System.out.println("Customer number " + customerNumber + " arrived at time unit " + clock);
				customerNumber++;
			}
			
			//	If a server is free and the customers’ queue is nonempty then remove a customer from the
			//	front of the queue and send the customer to the free server.
			if (listOfServers.getFreeServerID() > -1 && queue.isEmpty() == false)
			{
				customersServed++;
				totalWaitingTime += (clock - ((Customer)queue.peekFront()).getArrivalTime());
				listOfServers.setServerBusy(listOfServers.getFreeServerID(), ((Customer)queue.peekFront()));
				queue.dequeue();
			}
		}
		
		customersLeftInServers = listOfServers.getNumberOfBusyServers();
		customersLeftInQueue = queue.getQueueElements();
		averageWaitingTime = ((double)totalWaitingTime / customersServed);
		
		/*
		Print the following summary results of the simulation to the screen:
		"Simulation ran for XXX time units”
		"Number of servers: XXX”
		"Average transaction time: XXX”
		"Average arrival time difference between customers: XXX”
		"Total wait time of all customers: XXX”
		"Number of customers who completed a transaction: XXX”
		"Number of customers left in the servers: XXX”
		"Number of customers left in the queue: XXX”
		"Average wait time: XXX”
		"************** END SIMULATION *************"
		 */
		
		System.out.println("\n----------------------------------------------------------------------------------------------------------");
		System.out.println("Simulation ran for " + simulationTime + " time units.");				
		System.out.println("Number of servers:  " + numberOfServers);
		System.out.println("Average transaction time:  " + ((customersArrived * transactionTime) / customersArrived));
		System.out.println("Average arrival time difference between customers:  " + ((customersArrived * timeBetweenCustomerArrival) / customersArrived));
		System.out.println("Total wait time of all customers:  " + totalWaitingTime);
		System.out.println("Number of customers who arrived:  " + customersArrived);		
		System.out.println("Number of customers who completed a transaction:  " + (customersServed - customersLeftInServers));
		System.out.println("Number of customers left in the servers:  " + customersLeftInServers);
		System.out.println("Number of customers left in the queue:  " + customersLeftInQueue);
		System.out.printf("Average wait time:  %.2f", averageWaitingTime);
		System.out.println("\n----------------------------------------------------------------------------------------------------------");

		//	Create a footer when stopping program
		System.out.println("\n\n----------------------------------------------------------------------------------------------------------");
		System.out.println("                               Simulation terminated... Thank you!                               ");
		System.out.println("----------------------------------------------------------------------------------------------------------");
	}
}

