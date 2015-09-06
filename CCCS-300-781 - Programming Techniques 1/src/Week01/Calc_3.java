package Week01;
// Yannick Decosse 260551160
// CCCS-300-781 Programming Techniques 1
// Instructor: Dr. Malleswara Talla
// Sep 6, 2014

// Display calculation in Dialog Box Method 1
import javax.swing.JOptionPane;

public class Calc_3 {
			
	public static void main(String[] args) {
		double radius;
		double area;
		
		radius = 10;		
		area = radius*radius*3.14159;
				
		JOptionPane.showMessageDialog(null,(area),"Area of a circle",JOptionPane.INFORMATION_MESSAGE);

	}

}
