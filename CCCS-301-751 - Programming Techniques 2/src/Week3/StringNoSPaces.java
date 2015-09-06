package Week3;
/*
	Name:			Yannick Decosse
	McGill ID:		260551160
	Course ID:		CCCS-301-751 - Programming Techniques 2
	Instructor: 	Joseph Vybihal
	Date:			January 19, 2015
	Exercises:		Regex, Matcher & Pattern
 */

import java.util.LinkedList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class StringNoSPaces
{
	public static void main(String[] args)
	{
		String s = " 3.2x^3  ++2.23 x ^2 ---2.0x   +7.125";
		
		System.out.println(s);
	
		// Remove all in string
		String t = s.replaceAll("\\s", "");
		String u = t.replaceAll("x\\^", " ");
		String v = t.replaceAll("[x]([+-])", "x^1$1");
		String w = t.replaceAll("[+]+", "+");
		String x = w.replaceAll("[-]+", "-");
		System.out.println(t);
		System.out.println(t.length());
		System.out.println(v);
		System.out.println(w);
		System.out.println(x);
		
		char[] array = x.toCharArray();
		
		for (char j : array)
			System.out.print(j);
			System.out.println("\n");
		
		for (int i = 0; i < array.length; i++)
		{
			if (array[i] == 'x')
				array[i] = '1';
		}
		
		System.out.println(x);
		
		LinkedList<String> separate = new LinkedList<String>();
		LinkedList<String> numbers = new LinkedList<String>();
		LinkedList<String> exponent = new LinkedList<String>();
		
		// Group Terms
		Pattern a = Pattern.compile("\\d+\\.\\d+x\\^\\d");
		Matcher b = a.matcher(v);
		while (b.find())
		{
			separate.add(b.group());
		}
		for (int i = 0; i < separate.size(); i++)
		{
			System.out.print(separate.get(i) + " ");
		}
		System.out.print("\n");
		
		// Coefficient
		Pattern p = Pattern.compile("\\d+\\.\\d+");
		Matcher m = p.matcher(v);
		while (m.find())
		{
			numbers.add(m.group());
		}
		for (int i = 0; i < numbers.size(); i++)
		{
			System.out.print(numbers.get(i) + " ");
		}
		System.out.print("\n");
		
		// Exponent
		Pattern q = Pattern.compile("\\^(\\d)");
		Matcher r = q.matcher(v);
		while (r.find())
		{
			exponent.add(r.group(1));
		}
		for (int i = 0; i < exponent.size(); i++)
		{
			System.out.print(exponent.get(i) + " ");
		}
		
		System.out.println("\n");
		System.out.println((double)Math.round((+3.1+-3.0) * 10000) / 10000);
		
		int[] test = {1, 2, 3, 4};
		for (int print : test) { System.out.print(print + " ");};
		
	}
}
