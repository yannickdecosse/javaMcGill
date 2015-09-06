package Week02;
// Yannick Decosse 260551160
// CCCS-300-781 Programming Techniques 1
// Instructor: Dr. Malleswara Talla
// Sep 16, 2014

// Misc Math Calculations

public class MathsCals {

	public static void main(String[] args) {
		System.out.println(Math.pow(2, 3));
		// Displays 8.0
		System.out.println(Math.pow(4, 0.5));
		// Displays 2.0
		System.out.println(Math.pow(2.5, 2));
		// Displays 6.25
		System.out.println(Math.pow(2.5, -2));
		// Displays 0.16
		int x = 2;
		int y = 1;
		int a = 5;
		int b = 7;
		int c = 3;
		
		double e = (3+4*x)/5;
		double f = 10*(y-5)*(a+b+c)/x;
		double g = 9*(4/x + (9+x)/y);
		System.out.println(e - f + g);
		System.out.println(""+e+""+f+""+g);
		System.out.println(3*5/5+6*5/8-2);
	}

}
