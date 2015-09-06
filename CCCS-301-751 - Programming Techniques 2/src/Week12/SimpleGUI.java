package Week12;
/*
	Name:			Yannick Decosse
	McGill ID:		260551160
	Course ID:		CCCS-301-751 - Programming Techniques 2
	Instructor: 	Joseph Vybihal
	Date:			March 21, 2015
	Exercises:		GUI
 */

import javax.swing.JOptionPane;

public class SimpleGUI
{
	public static void main(String[] args) 
	{
		int convertFirst = 0;
		int convertSecond = 0;
		
		String first = JOptionPane.showInputDialog("Enter first number: ");
		String second = JOptionPane.showInputDialog("Enter second number: ");
		
		convertFirst = Integer.parseInt(first);
		convertSecond = Integer.parseInt(second);
		
		JOptionPane.showMessageDialog(null, "The sum of first and second is " + (convertFirst + convertSecond), "Sum of Two Integers", JOptionPane.PLAIN_MESSAGE);
		int output = JOptionPane.showConfirmDialog(null, "The sum of first and second is " + (convertFirst + convertSecond), "Sum of Two Integers", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
		
		if(output == JOptionPane.YES_OPTION)
		{
			JOptionPane.showMessageDialog(null, "YES OPTION CHOSEN", "YES OPTION", JOptionPane.PLAIN_MESSAGE);
        }
		
		else if(output == JOptionPane.NO_OPTION)
		{
			JOptionPane.showMessageDialog(null, "NO OPTION CHOSEN", "NO OPTION", JOptionPane.PLAIN_MESSAGE);
        }
		
		else if(output == JOptionPane.CANCEL_OPTION)
		{
			JOptionPane.showMessageDialog(null, "CANCEL OPTION CHOSEN", "CANCEL OPTION", JOptionPane.PLAIN_MESSAGE);
        }
		
		JOptionPane.showMessageDialog(null, "The sum of first and second is " + (convertFirst + convertSecond), "Sum of Two Integers", JOptionPane.WARNING_MESSAGE);
		JOptionPane.showMessageDialog(null, "The sum of first and second is " + (convertFirst + convertSecond), "Sum of Two Integers", JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showMessageDialog(null, "The sum of first and second is " + (convertFirst + convertSecond), "Sum of Two Integers", JOptionPane.ERROR_MESSAGE);
	}
}
