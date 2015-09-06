package Assignment4;
import java.util.Scanner;

/*
	Name:			Yannick Decosse
	McGill ID:		260551160
	Course ID:		CCCS-300-781 Programming Techniques 1
	Instructor: 	Dr. Malleswara Talla
	Date:			November 18, 2014
	Assignment 4:	Understanding and using Classes, Objects, Methods & Constructors
 */

public class Account {
	
	/* Set up variables */
	private static double annualInterestRate;
	private static int nextAccountNb = 300;
	private int accountNb;
	private String f_name;
	private String l_name;
	private double balance;
	private java.util.Date dateCreated = new java.util.Date();
	
	/* Default Constructor */
	public Account() {
		dateCreated = new java.util.Date();
	}
	
	/* Create Account constructor with specified First Name, Last Name & initial balance */
	public Account (String f_name, String l_name, double balance) {
		this.f_name = f_name;
		this.l_name = l_name;
		this.balance = balance;
	}
	
	/* Accessor  for first name */
	public String getFirstName() {
		return f_name;
	}
	
	/* Accessor  for last name */
	public String getLastName() {
		return l_name;
	}
	
	/* Mutator  for current balance */
	public double getCurrentBalance() {
		return (int)(balance * 100) / 100.0;
	}
	
	/* Mutator  to set current annual interest rate  */
	public static void setAnnualInterestRate(double rate) {
		annualInterestRate  = rate;
	}
	
	/* Accessor  for annual interest rate */
	public double getAnnualInterestRate() {
		return annualInterestRate;
	}
	
	/* Mutator  for current account number */
	public void setAccountNumber(int accountNb) {
		this.accountNb = accountNb;
	}
	
	/* Accessor  for next account number */
	public static double getNextAccountNumber() {
		return nextAccountNb++;
	}
	
	/* Accessor  for date of account creation */
	public java.util.Date getDate() {
		return dateCreated;
	}
	
	/* Calculate monthly interest rate */
	public double getMonthlyInterestRate() {
	    double monthlyInterestRate = annualInterestRate / 1200;
	    return monthlyInterestRate;    
	}

	/* Display newly created account */
	public void displayNewlyCreatedAccount() {
		setAccountNumber(nextAccountNb);
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("                   YOUR ACCOUNT DETAILS ARE AS FOLLOWS:                   ");
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("\nYour name is " + f_name + " " + l_name);
		System.out.println("Your account number is " + accountNb);
		System.out.println("Your current balance is $" + balance);
		System.out.println("The current interest rate is " + annualInterestRate + "%");
		System.out.println("The monthly interest amount for this balance is $" + getMonthlyInterestRate()*balance);
		System.out.println("This account is created on " + getDate());
		System.out.println("\n--------------------------------------------------------------------------");
		getNextAccountNumber();
	}
	
	/* Deposit amount in account */
	public void deposit(double amount) {
		System.out.println("Amount deposited is $" + amount);
		balance += (int)(amount * 100) / 100.0;
	}
	
	/* Withdraw amount from account unless amount is greater than balance, then refuse */
	public void withdrawal(double amount) {
		
		/* Checking if amount withdrawn is possible */
		if (amount > balance)
			System.out.println ("Sorry: you do not have sufficient funds in your account!");
		else {
			System.out.println("Amount withdrawn is $" + amount);
			balance -= (int)(amount * 100) / 100.0;
		}
	}
	
	/* Options to deposit funds, withdraw funds or quit system */
	public void transactions() {
		Scanner key = new Scanner(System.in);
		Scanner customer = new Scanner(System.in);
		
		try {
		
			boolean validate = false;
		
			do {

				System.out.print("\nPlease make your choice - Enter 0 for Deposit, 1 for Withdrawal & 2 to quit: ");
					while (!customer.hasNext("[0||1||2]")) {
						System.out.print("\nError! Enter 0 for Deposit, 1 for Withdrawal & 2 to quit: ");
						customer.next();
					}
		
					/* Convert customer input to integer after validation*/
					String choice = customer.next();
					int intChoice = Integer.parseInt(choice);
		
						if (intChoice == 0) {
							System.out.print("\nEnter amount to deposit: $");
								while (!key.hasNextDouble()) {
									System.out.print("\nError! please enter digits only: ");
									key.next();
								}
								deposit(key.nextDouble());
								validate = true;
						}
						else
							if (intChoice == 1) {
								System.out.print("\nEnter amount to withdraw: $");
									while (!key.hasNextDouble()) {
										System.out.print("\nError! please enter digits only: ");
										key.next();
									}
									withdrawal(key.nextDouble());
									validate = true;
							}
							else
								break;
			} // Close Do loop
			while (validate);
			}
			finally {
				key.close();
				customer.close();
			}
		
		/* Display closing message */
		System.out.println("\n--------------------------------------------------------------------------");
		System.out.print("---                      * Your new balance is $" + getCurrentBalance() + " *               ---");
		System.out.println("\n---                            * GOODBYE *                             ---");
		System.out.println("--------------------------------------------------------------------------");
	}
		    
}
