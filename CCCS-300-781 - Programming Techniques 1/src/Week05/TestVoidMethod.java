package Week05;
// Yannick Decosse 260551160
// CCCS-300-781 Programming Techniques 1
// Instructor: Dr. Malleswara Talla
// Oct 2, 2014

// Methods: Test Void Method

public class TestVoidMethod {
  public static void main(String[] args) {
    System.out.print("The grade is ");
    printGrade(78.5);

    System.out.print("The grade is ");
    printGrade(59.5);
  }

  public static void printGrade(double score) {
    if (score >= 90.0) {
      System.out.println('A');
    } 
    else if (score >= 80.0) {
      System.out.println('B');
    } 
    else if (score >= 70.0) {
      System.out.println('C');
    } 
    else if (score >= 60.0) {
      System.out.println('D');
    } 
    else {
      System.out.println('F');
    }
  }
}