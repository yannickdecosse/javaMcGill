package Week05;
/*	Assignment 2
	Written by: Yannick Decosse (260551160)
	Purpose: Selections and Loops
	Class: CCCS 300
	Instructor: Dr. Malleswara Talla
	Date: Oct 1, 2014
*/

/*	
*/
// ------------------------------------------------------------------------------------------------------------------------------------------

import javax.swing.JOptionPane;

public class TestAssignment {
	public static void main(String[] args) {
		double transaction_total = 0;
		int count = 1;
		int choice = 0;
		
		while (choice == JOptionPane.YES_OPTION && transaction_total < 85000.01) {// Add Sales to system until answer is "NO" or "CANCEL" or monthly commission limit is reached
			choice = JOptionPane.showConfirmDialog(null,"Record a new transaction?","Please make a choice",JOptionPane.YES_NO_CANCEL_OPTION);
			
			if (choice !=JOptionPane.YES_OPTION) {
				System.out.println("Transaction cancelled.");
			}
				else if (choice == JOptionPane.YES_OPTION) {
					System.out.println("SuperDiscount Sales Record System - Inv No. " + count);
					double transaction = Math.random() * 50000.0;// Generate Random Sales up to $50,000
			
					int tchoice = JOptionPane.showConfirmDialog(null, "The transaction amount to $" + (double)Math.round(transaction *100)/100 + ". Accept transaction?","Confirm Transaction",JOptionPane.YES_NO_CANCEL_OPTION);
						if (tchoice == JOptionPane.YES_OPTION) {
							System.out.println("Thank you for the sales of $" + (double)Math.round(transaction *100)/100);
							transaction_total += transaction;
							count++;
						}
						else
							System.out.println("Transaction discarded.");
				}
		}
		double monthly_commission = 0;// Calculate monthly commission
		
		if (transaction_total <= 10000.0) { // If Monthly Sales is less or equal to $10,000.00
			monthly_commission = transaction_total*0.1;
		}
		else if (transaction_total >= 10000.01 && transaction_total <= 30000.0 ) {// If Monthly Sales is less or equal to $30,000.00
			monthly_commission = (transaction_total-10000.0)*0.15 + 1000.0;
		}
		else if (transaction_total >= 30000.01 ) {// If Monthly Sales is greater than $30,000.01
			monthly_commission = (transaction_total-30000.0)*0.2 + 4000.0;
		}
		
		System.out.println("Your total commission for the month is " + (double)Math.round(monthly_commission*100)/100);
		System.out.println("Thank you.\n\n");
	}

}
