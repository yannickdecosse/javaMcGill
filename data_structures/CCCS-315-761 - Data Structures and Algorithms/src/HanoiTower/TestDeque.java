package HanoiTower;
/*
	Name:			Yannick Decosse
	McGill ID:		260551160
	Course ID:		CCCS-301-751 - Programming Techniques 2
	Instructor: 	Dr. Hang Lau
	Date:			February 12, 2015
	Exercises:		Deque
 */

import java.util.ArrayDeque;

public class TestDeque 
{
	public static void main(String[] args) 
	{
		// Create ArrayDeque with three elements.
		ArrayDeque<Integer> deque = new ArrayDeque<>();
		deque.push(10);
		deque.push(500);
		deque.push(1000);

		// Peek to get the top item, but do not remove it.
		//int peekResult = deque.peek();
		System.out.println(deque.peek());

		// Call pop on the Deque.
		int popResult = deque.pop();
		System.out.println(popResult);

		// Pop again.
		popResult = deque.pop();
		System.out.println(popResult);

	}
}
