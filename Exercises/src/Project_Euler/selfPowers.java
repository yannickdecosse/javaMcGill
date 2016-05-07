package Project_Euler;
/**
	Name:			Yannick Decosse
	McGill ID:		260551160
	Course ID:	-	
	Instructor: 	-
	Date:				May 4, 2016
	Subject:		Calculating a series of self powers numbers up to 1,000
 **/

/*	Import Libraries */
import java.math.BigInteger;

public class selfPowers {

	public static void main(String[] args) {
		/* Initialize variables */
		BigInteger sum = BigInteger.valueOf(0);
		int counter;
		
		for (counter = 1; counter < 1001; counter++) {
			BigInteger calc = BigInteger.valueOf(counter);
			BigInteger power = calc.pow(counter);
			sum = sum.add(power);
		}
		
		
		System.out.println(sum.toString().substring(sum.toString().length()-10, sum.toString().length()));
		
	}

}
