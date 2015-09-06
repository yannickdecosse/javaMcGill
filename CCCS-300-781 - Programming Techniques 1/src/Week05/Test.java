package Week05;
// Yannick Decosse 260551160
// CCCS-300-781 Programming Techniques 1
// Instructor: Dr. Malleswara Talla
// Oct 2, 2014

// Methods: Test Max

public class Test {
  /** Main method */
  public static void main(String[] args) {
    int i = 5;
    int j = 2;
    int k = max(i, j);
    System.out.println("The maximum between " + i +
      " and " + j + " is " + k);
    
    System.out.println(5%2*3+4);
    
    String Str = new String("Welcome to Tutorialspoint.com");

    System.out.print("Return Value :" );
    System.out.println(Str.substring(10) );

    System.out.print("Return Value :" );
    System.out.println(Str.substring(10,15) );
    
    int a = 0;
    int b = 10;
    int c = a | b;
    
    System.out.println(c);
    System.out.println(6 / 10 % 7);
  }

  /** Return the max between two numbers */
  public static int max(int num1, int num2) {
    int result;

    if (num1 > num2)
      result = num1;
    else
      result = num2;

    return result;
  }
}
