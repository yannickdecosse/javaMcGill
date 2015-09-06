package Week7;
/*
	Name:			Yannick Decosse
	McGill ID:		260551160
	Course ID:		CCCS-301-751 - Programming Techniques 2
	Instructor: 	Joseph Vybihal
	Date:			February 19, 2015
	Exercises:		Abstracts and Interfaces
 */

public abstract class AbstractTree<E> implements Tree<E> 
{
  @Override /** Inorder traversal from the root*/
  public void inorder() 
  {}

  @Override /** Postorder traversal from the root */
  public void postorder() 
  {}

  @Override /** Preorder traversal from the root */
  public void preorder() 
  {}

  @Override /** Return true if the tree is empty */
  public boolean isEmpty() 
  {
	  return getSize() == 0;
  }
//
//  @Override /** Return an iterator for the tree */
//  public java.util.Iterator<E> iterator() {
//    return null;
//  }
}
