package Week7;
/*
	Name:			Yannick Decosse
	McGill ID:		260551160
	Course ID:		CCCS-301-751 - Programming Techniques 2
	Instructor: 	Joseph Vybihal
	Date:			February 19, 2015
	Exercises:		Abstracts and Interfaces + Binary Search Trees
 */

import javax.swing.*;

public class DisplayBinaryTree extends JApplet 
{
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DisplayBinaryTree() 
	{
		add(new TreeControl(new BST<Integer>()));
	}
  
	public static void main(String[] args) 
	{
		JFrame frame = new JFrame("DisplayBinaryTree");
		JApplet applet = new DisplayBinaryTree();
		frame.add(applet);
		frame.setSize(500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}