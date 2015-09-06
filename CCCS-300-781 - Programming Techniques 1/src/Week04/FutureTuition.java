package Week04;
// Yannick Decosse 260551160
// CCCS-300-781 Programming Techniques 1
// Instructor: Dr. Malleswara Talla
// Sep 25, 2014

// Calculate Double a sum with While Loop

public class FutureTuition {
  public static void main(String[] args) { 
    double tuition = 10000;   // Year 0
    int year = 0;
    while (tuition < 20000) {
      tuition = tuition * 1.07;
      year++;
    }
  
    System.out.println("Tuition will be doubled in " 
      + year + " years");
    System.out.printf("Tuition will be $%.2f in %1d years",  
      tuition, year);
  }
}