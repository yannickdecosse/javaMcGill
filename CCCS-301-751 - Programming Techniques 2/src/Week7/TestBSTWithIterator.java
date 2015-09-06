package Week7;
/*
	Name:			Yannick Decosse
	McGill ID:		260551160
	Course ID:		CCCS-301-751 - Programming Techniques 2
	Instructor: 	Joseph Vybihal
	Date:			February 19, 2015
	Exercises:		Abstracts and Interfaces + Binary Search Trees
 */

public class TestBSTWithIterator 
{
  public static void main(String[] args) 
  {
    BST<String> tree = new BST<String>();
    tree.insert("George");
    tree.insert("Michael");
    tree.insert("Tom");
    tree.insert("Adam");
    tree.insert("Jones");
    tree.insert("Peter");
    tree.insert("Daniel");
    
    for (String s: tree)
      System.out.print(s.toUpperCase() + " ");
  }
}
