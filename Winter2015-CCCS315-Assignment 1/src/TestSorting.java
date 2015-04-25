import java.util.Scanner;
import java.util.LinkedList;

public class TestSorting
{
	public static void main(String[] args)
	{
		Polynomial test = new Polynomial();
		
		Term a = new Term(12, 12.0);
		Term b = new Term(1, -4.0);
		Term c = new Term(12, 5.6);
		Term d = new Term(2, -7.0);
		Term e = new Term(6, 1.0);
		Term f = new Term(0, 2.0);
		Term g = new Term(3, 4.4);
		
		test.addTerm(a);
		test.addTerm(b);
		test.addTerm(c);
		test.addTerm(d);
		test.addTerm(e);
		test.addTerm(f);
		test.addTerm(g);
				
		System.out.println(test);
		
		String t = "-2.0x^0-4.0x^1-6.0x^2+4.4x^3+17.6x^12";
		String s = t.replaceAll("([x\\^])", " ")
					.replaceAll("[+]", " ")
					.replaceAll("([-+][\\d]+[\\.][\\d]+)", " ");
		
		String u = t.replaceAll("(x\\^[\\d]+)", " ")
				.replaceAll("[+]", " ");
		
		Scanner scanInt = new Scanner(s);
		Scanner scanDouble = new Scanner(u);
		
		System.out.println(s);
		
		LinkedList<Integer> listInt = new LinkedList<Integer>();
		
		while(scanInt.hasNext())
		{
			if (scanInt.hasNextInt())
			{
			listInt.add(scanInt.nextInt());
			}
			
			else
			{
				scanInt.next();
			}
		}
		
		System.out.println(listInt);
		
		System.out.println(u);
		
		LinkedList<Double> listDouble = new LinkedList<Double>();
		
		while(scanDouble.hasNext())
		{
			if (scanDouble.hasNextDouble())
			{
			listDouble.add(scanDouble.nextDouble());
			}
			
			else
			{
				scanDouble.next();
			}
		}
		
		System.out.println(listDouble);
		
		scanInt.close();
		scanDouble.close();
	}
	
	
	
}
