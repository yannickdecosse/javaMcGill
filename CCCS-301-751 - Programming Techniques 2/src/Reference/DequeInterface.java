package Reference;
// 23.15
/**
 * An interface for the ADT deque.
 * 
 * @author Frank M. Carrano
 * @version 2.0
 */
public interface DequeInterface<T>
{
  public void addToFront(T newEntry);
  public void addToBack(T newEntry);
  public T removeFront();
  public T removeBack();
  public T getFront();
  public T getBack();
  public boolean isEmpty();
  public void clear();
} // end DequeInterface