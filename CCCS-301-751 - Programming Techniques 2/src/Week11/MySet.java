package Week11;
/*
	Name:			Yannick Decosse
	McGill ID:		260551160
	Course ID:		CCCS-301-751 - Programming Techniques 2
	Instructor: 	Joseph Vybihal
	Date:			March 16, 2015
	Exercises:		Lists, Stacks, Queues, Sets & Maps
 */

public interface MySet<E> extends java.lang.Iterable<E> {
  /** Remove all elements from this set */
  public void clear();
  
  /** Return true if the element is in the set */
  public boolean contains(E e);
  
  /** Add an element to the set */
  public boolean add(E e);

  /** Remove the element from the set */
  public boolean remove(E e);

  /** Return true if the set contains no elements */
  public boolean isEmpty();

  /** Return the number of elements in the set */
  public int size();

  /** Return an iterator for the elements in this set */
  public java.util.Iterator iterator();
}
