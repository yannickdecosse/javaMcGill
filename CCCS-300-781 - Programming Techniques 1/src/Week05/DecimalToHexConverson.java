package Week05;
// Yannick Decosse 260551160
// CCCS-300-781 Programming Techniques 1
// Instructor: Dr. Malleswara Talla
// Oct 2, 2014

// Methods: Decimal to Hexadecimal Conversion

import java.util.Scanner;

public class DecimalToHexConverson {
  /** Main method */
  public static void main(String[] args) {
    // Create a Scanner
    Scanner input = new Scanner(System.in);

    // Prompt the user to enter a decimal integer
    System.out.print("Enter a decimal number: ");
    int decimal = input.nextInt();

    System.out.println("The hex number for decimal " + 
      decimal + " is " + decimalToHex(decimal));
  }
  
  /** Convert a decimal to a hex as a string */
  public static String decimalToHex(int decimal) {
    String hex = "";
    
    while (decimal != 0) {
      int hexValue = decimal % 16; 
      hex = toHexChar(hexValue) + hex;
      decimal = decimal / 16;
    }
    
    return hex;
  }
  
  /** Convert an integer to a single hex digit in a character */
  public static char toHexChar(int hexValue) {
    if (hexValue <= 9 && hexValue >= 0)
      return (char)(hexValue + '0');
    else  // hexValue <= 15 && hexValue >= 10
      return (char)(hexValue - 10 + 'A');
  }
}