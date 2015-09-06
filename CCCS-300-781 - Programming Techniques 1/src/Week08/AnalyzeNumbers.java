package Week08;
// Yannick Decosse 260551160
// CCCS-300-781 Programming Techniques 1
// Instructor: Dr. Malleswara Talla
// Oct 21, 2014
// Arrays 1D : Analyze numbers


public class AnalyzeNumbers {
  public static void main(String[] args) {
    final int NUMBER_OF_ELEMENTS = 10;
    double[] numbers = new double[NUMBER_OF_ELEMENTS];
    double sum = 0;

    java.util.Scanner input = new java.util.Scanner(System.in);
    for (int i = 0; i < NUMBER_OF_ELEMENTS; i++) {
      System.out.print("Enter a new number: ");
      numbers[i] = input.nextDouble();
      sum += numbers[i];
    }
    
    double average = sum / NUMBER_OF_ELEMENTS;

    int count = 0; // The number of elements above average
    for (int i = 0; i < NUMBER_OF_ELEMENTS; i++) 
      if (numbers[i] > average)
        count++;

    System.out.println("Average is " + average);
    System.out.println("Number of elements above the average "
      + count);
  }
}