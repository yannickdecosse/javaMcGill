package Week11;
// Yannick Decosse 260551160
// CCCS-300-781 Programming Techniques 1
// Instructor: Dr. Malleswara Talla
// Nov 13, 2014
// Thinking in Objects : Test Stack of Integers

public class TestStackOfIntegers {
  public static void main(String[] args) {
    StackOfIntegers stack = new StackOfIntegers();
    
    for (int i = 0; i < 10; i++)
      stack.push(i);
    
    while (!stack.empty())
      System.out.print(stack.pop() + " ");  
  }
}