package Week04;
// Yannick Decosse 260551160
// CCCS-300-781 Programming Techniques 1
// Instructor: Dr. Malleswara Talla
// Sep 25, 2014

// Using while Loop with JOptionPane	

import javax.swing.JOptionPane;

public class SentinelValueUsingConfirmationDialog {
  public static void main(String[] args) {
    int sum = 0;

    // Keep reading data until the user answers No
    int option = 0;
    while (option == JOptionPane.YES_OPTION) {
      // Read the next data
      String dataString = JOptionPane.showInputDialog(
        "Enter an integer: ");
      int data = Integer.parseInt(dataString);

      sum += data;

      option = JOptionPane.showConfirmDialog(null, "Continue?");
    }

    JOptionPane.showMessageDialog(null, "The sum is " + sum);
  }
}