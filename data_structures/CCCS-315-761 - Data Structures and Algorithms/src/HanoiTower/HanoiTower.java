package HanoiTower;
/*
	Name:			Yannick Decosse
	McGill ID:		260551160
	Course ID:		CCCS-301-751 - Programming Techniques 2
	Instructor: 	Dr. Hang Lau
	Date:			February 1, 2015
	Exercises:		Recursion
 */

public class HanoiTower
{
	public static String hanoi(int nDisks, int fromPeg, int toPeg) 
	{ 
		int helpPeg; 
		String Sol1, Sol2, myStep, mySol;
	
		if (nDisks == 1) 	 
			return fromPeg + " -> " + toPeg + "\n"; 
	
		else 
		{ 
			helpPeg = 6 - fromPeg - toPeg; // fromPeg + helpPeg + toPeg = 6 
			Sol1 = hanoi(nDisks-1, fromPeg, helpPeg); 	 
			myStep = fromPeg + " -> " + toPeg + "\n"; 	 
			Sol2 = hanoi(nDisks-1, helpPeg, toPeg); 
			mySol = Sol1 + myStep + Sol2; // + = String concatenation ! 
		
			return mySol; 
		}
	}

	public static void main (String[] args) 
	{ 
		int n = 10; 
		String StepsToSolution; 
		StepsToSolution = hanoi(n, 1, 3); 
		
		System.out.println(StepsToSolution); 
	}
}