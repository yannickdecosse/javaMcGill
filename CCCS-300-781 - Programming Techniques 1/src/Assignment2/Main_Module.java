package Assignment2;
/*	Assignment 2
	Written by: Yannick Decosse (260551160)
	Purpose: Selections and Loops
	Class: CCCS 300
	Instructor: Dr. Malleswara Talla
	Date: Oct 1, 2014

	Subject: 	This program will generate sales for each month until sales for all 12 months are recorded
				or as soon as the limit >= $100,000 is reached. For each month, the user has the choice
				to accept sales or reject sales. As soon as the monthly commission limit of $15,000 or more 
				is reached, the system move to the next month, or if the user reject or cancel a transaction.
				The commission is calculated at the end of monthly transactions, and has 3 rates based on 
				value of monthly sales (first $10,000 at 10%, next $20,000 at 15%, and 20% above $30,000.01
				of sales. When transactions of all 12 months is done, or if yearly target is reached, 
				the system stop and quit with an end message.
				
				   The program use loops and selections, and the switch function to name the months.
*/

import javax.swing.JOptionPane;

public class Main_Module {
	public static void main(String[] args) {
		
		int month = 1;
		double yearly_commission = 0;
		
		System.out.println("*****************************************************");
		System.out.println("          SUPERDISCOUNT SALES RECORD SYSTEM          ");
		System.out.println("*****************************************************\n");
		System.out.println("           Welcome to the system, Yannick.           \n");
		System.out.println("  -------------------------------------------------  \n");
		
		do {			
			switch (month) {// Change month after transactions stop or monthly limit is reached
			case 1: System.out.println("SALES FOR JANUARY");
				break;
			case 2: System.out.println("SALES FOR FEBRUARY");
				break;
			case 3: System.out.println("SALES FOR MARCH");
				break;
			case 4: System.out.println("SALES FOR APRIL");
				break;
			case 5: System.out.println("SALES FOR MAY");
				break;
			case 7: System.out.println("SALES FOR JUNE");
				break;
			case 6: System.out.println("SALES FOR JULY");
				break;
			case 8: System.out.println("SALES FOR AUGUST");
				break;
			case 9: System.out.println("SALES FOR SEPTEMBER");
				break;
			case 10: System.out.println("SALES FOR OCTOBER");
				break;
			case 11: System.out.println("SALES FOR NOVEMBER");
				break;
			case 12: System.out.println("SALES FOR DECEMBER");
				break;
			default : System.out.println("ERROR");
			}
			
			double transaction_total = 0;
			int count = 1;
			int choice = 0;
			
			while (choice == JOptionPane.YES_OPTION && transaction_total < 85000.01) {// Add Sales to system until answer is "NO" or "CANCEL" or monthly commission limit is reached
				choice = JOptionPane.showConfirmDialog(null,"Record a new transaction?","Please make a choice",JOptionPane.YES_NO_CANCEL_OPTION);
				
				if (choice !=JOptionPane.YES_OPTION) {
					System.out.println("Transaction cancelled.");// Go to next month
				}
					else if (choice == JOptionPane.YES_OPTION) {
						System.out.println("SuperDiscount Sales Record System - Inv No. " + count);
						double transaction = Math.random() * 50000.0;// Generate Random Sales up to $50,000
				
						int tchoice = JOptionPane.showConfirmDialog(null, "The transaction amount to $" + (double)Math.round(transaction *100)/100 + ". Accept transaction?","Confirm Transaction",JOptionPane.YES_NO_CANCEL_OPTION);
							if (tchoice == JOptionPane.YES_OPTION) {
								System.out.println("Thank you for the sales of $" + (double)Math.round(transaction *100)/100);
								transaction_total += transaction;// add transaction to monthly sales
								count++;// Increment number of sales per month until limit is reached
							}
							else
								System.out.println("Transaction discarded.");
					}
			}
			double monthly_commission = 0;// Calculate monthly commission
			
				if (transaction_total <= 10000.0) { // If Monthly Sales is less or equal to $10,000.00
					monthly_commission = transaction_total*0.1;
				}
				else if (transaction_total <= 30000.0 ) {// If Monthly Sales is less or equal to $30,000.00
					monthly_commission = (transaction_total-10000.0)*0.15 + 1000.0;
				}
				else if (transaction_total >= 30000.01 ) {// If Monthly Sales is greater than $30,000.01
					monthly_commission = (transaction_total-30000.0)*0.2 + 4000.0;
				}
			
			System.out.println("Your total commission for the month is " + (double)Math.round(monthly_commission*100)/100);
			System.out.println("Thank you.\n");
			
			yearly_commission += monthly_commission;// add Monthly Sales to Total Commission
			month++;// change month
		}
		while (month < 13 && yearly_commission < 100000.0);// Continue loop until 12 months or yearly limit is reached
		
		System.out.println("Your earnings for the year is: $" + (double)Math.round(yearly_commission*100)/100 + "\n");
			
		if (yearly_commission > 100000.0){// when yearly limit is reached
				JOptionPane.showMessageDialog(null, "Congratulations. You win a trip to Honolulu, Hawaii!", "YOU ARE THE LUCKY WINNER",JOptionPane.INFORMATION_MESSAGE);// Display Winner message
			}
		
		System.out.println("Thank you and goodbye.\n");//Goodbye message and stop loop
		System.out.println("*****************************************************");
		System.out.println("                    SYSTEM CLOSED                    ");
		System.out.println("*****************************************************");
	}
}

