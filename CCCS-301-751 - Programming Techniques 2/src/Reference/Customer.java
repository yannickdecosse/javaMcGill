package Reference;
/**
 * An immutable class that represents a customer
 * of a bank or similar place of business.
 * 
 * @author Frank M. Carrano
 * @version 2.0
 */
public class Customer
{
	private int arrivalTime;
	private int transactionTime;
	private int customerNumber;
	
	public Customer(int arrivalTime, int transactionTime, int customerNumber)
	{
		this.arrivalTime = arrivalTime;
		this.transactionTime = transactionTime;
		this.customerNumber = customerNumber;
	} // end constructor
	
	public int getArrivalTime()
	{
		return arrivalTime;
	} // end getArrivalTime
	
	public int getTransactionTime()
	{
		return transactionTime;
	} // end getTransactionTime
	
	public int getCustomerNumber()
	{
		return customerNumber;
	} // end getCustomerNumber
} // end Customer