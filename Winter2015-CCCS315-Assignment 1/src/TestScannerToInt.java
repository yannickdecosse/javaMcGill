import java.util.Scanner;
import java.util.LinkedList;

public class TestScannerToInt
{
	public static void main(String[] args)
	{
		String s = "-2.0 x ^ 1 - 1.0 x ^ 0 + 2.125 x ^ 12";
		String t = " 1  0  12";
		
		Scanner scan = new Scanner(s);
		Scanner text = new Scanner(t);
		Scanner scanDouble = new Scanner(s);
		LinkedList<Integer> test = new LinkedList<Integer>();
		
		
		while(scan.hasNext() && scanDouble.hasNext())
		{
			if (scan.hasNextInt())
			{
			System.out.print(scan.nextInt() + " ");
			test.add(text.nextInt());
			}
			
			else
			{
				scan.next();
			}
			
			if (scanDouble.hasNextDouble())
			{
				//if ((scanDouble.nextDouble() % 1) != 0)
				//{
					
					System.out.print(scanDouble.nextDouble() + " ");

					
					
				//}
			
			}
			
			else
			{
				scanDouble.next();
			}
		}
		
		scan.close();
		scanDouble.close();
		
		System.out.println("TheEnd...");
		System.out.println(test);

	}

}
