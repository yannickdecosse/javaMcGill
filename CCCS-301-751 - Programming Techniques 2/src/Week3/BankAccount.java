package Week3;
/*
	Name:			Yannick Decosse
	McGill ID:		260551160
	Course ID:		CCCS-301-751 - Programming Techniques 2
	Instructor: 	Joseph Vybihal
	Date:			January 19, 2015
	Exercises:		Objects & Classes
 */

class BankAccount
{
	private String accountNumber;
	private double balance;

	BankAccount (String accountNumber, double balance)
	{
		this.accountNumber = accountNumber;
		this.balance = balance;
	}
	
	public double getBalance()
	{
		return balance;
	}
	
	public void deposit(double amount)
	{
		if (amount < 0)
			System.out.println("Enter a amount greater than 0");
		else
			balance += amount;
	}
}