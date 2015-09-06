package Week01;
// Yannick Decosse 260551160
// CCCS-300-781 Programming Techniques 1
// Instructor: Dr. Malleswara Talla
// Sep 6, 2014

// Display calculation in Dialog Box Method 1

import javax.swing.JOptionPane;

public class ShowCalcInDialogBox {
			
	public static void main(String[] args) {
		int convert;
		
		convert = (35*9)/5 + 32;
				
		JOptionPane.showMessageDialog(null,convert,"Convert Degrees Celcius to Farenheit",JOptionPane.INFORMATION_MESSAGE);

	}

}
