package Assignment1;
import java.util.Scanner;
 
/*
 * Example java source code on the usage of
 * Scanner hasNextInt() method
 * Print int data type only
 */
 
public class ScannerHasNextInt {
 
	public static void main(String[] args) {
		// Declare File object
 
		// initialize the scanner
		Scanner scan = new Scanner("** Int number is 3 sdg  5 srfgewr 129 **");
		// iterate through the tokens
		while(scan.hasNext()){
			// print int tokens
			if(scan.hasNextInt(10)){
				System.out.println("Found Int: "+scan.next());
			}
			else{
				scan.next();
			}
 
		}
		scan.close();
 
	}
}