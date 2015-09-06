package Week01;
// Yannick Decosse 260551160
// CCCS-300-781 Programming Techniques 1
// Instructor: Dr. Malleswara Talla
// Sep 11, 2014

// Converion of seconds into minutes 
import java.util.Scanner;

public class TimeDisplay {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print ("Enter seconds ");
		int seconds = input.nextInt();
		
		int minutes = seconds / 60;
		int minutesRemainder = seconds % 60;
		
		System.out.println("The conversion of " + seconds + " into minutes is " + minutes + " and the remaining seconds is " + minutesRemainder);
	}

}
