package Week10;
/*
	Name:			Yannick Decosse
	McGill ID:		260551160
	Course ID:		CCCS-301-751 - Programming Techniques 2
	Instructor: 	Joseph Vybihal
	Date:			March14, 2015
	Exercises:		GUI & Event Programming
 */

import javax.swing.*;

public class MyFrameWithComponents {
  public static void main(String[] args) {
    JFrame frame = new JFrame("MyFrameWithComponents");

    // Add a button into the frame
    JButton jbtOK = new JButton("OK");
    frame.add(jbtOK);

    frame.setSize(400, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setVisible(true);
  }
}
