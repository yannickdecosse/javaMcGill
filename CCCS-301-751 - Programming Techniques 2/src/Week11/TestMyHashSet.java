package Week11;
/*
	Name:			Yannick Decosse
	McGill ID:		260551160
	Course ID:		CCCS-301-751 - Programming Techniques 2
	Instructor: 	Joseph Vybihal
	Date:			March 16, 2015
	Exercises:		Lists, Stacks, Queues, Sets & Maps
 */

public class TestMyHashSet {
  public static void main(String[] args) {
    // Create a MyHashSet
    MySet<String> set = new MyHashSet<String>();
    set.add("Smith");
    set.add("Anderson");
    set.add("Lewis");
    set.add("Cook");
    set.add("Smith");

    System.out.println("Elements in set: " + set);
    System.out.println("Number of elements in set: " + set.size());
    System.out.println("Is Smith in set? " + set.contains("Smith"));

    set.remove("Smith");
    System.out.print("Names in set in uppercase are ");
    for (String s: set)
      System.out.print(s.toUpperCase() + " ");

    set.clear();
    System.out.println("\nElements in set: " + set);
  }
}