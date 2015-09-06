package Week11;
/*
	Name:			Yannick Decosse
	McGill ID:		260551160
	Course ID:		CCCS-301-751 - Programming Techniques 2
	Instructor: 	Joseph Vybihal
	Date:			March 16, 2015
	Exercises:		Lists, Stacks, Queues, Sets & Maps
 */

public class MyPriorityQueue<E extends Comparable<E>> {
  private Heap<E> heap = new Heap<E>();

  public void enqueue(E newObject) {
    heap.add(newObject);
  }

  public E dequeue() {
    return heap.remove();
  }

  public int getSize() {
    return heap.getSize();
  }
}
