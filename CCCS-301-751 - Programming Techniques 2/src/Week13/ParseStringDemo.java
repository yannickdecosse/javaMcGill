package Week13;

public class ParseStringDemo
{
	public static void main(String[] args)
	{
		char[] inputCSV = {'\"', 'w','o', 'r', 'd', 's', '\"', ',', '\"', 'w','o', 'r', 'd', 's', '\"', ',', '\"', 'w','o', 'r', 'd', 's', '\"', ',', '\"', 'w','o', 'r', 'd', 's', '\"'};
		char[] output1 = new char[inputCSV.length];
		char[] output2 = new char[inputCSV.length];
		char[] output3 = new char[inputCSV.length];
		char[] output4 = new char[inputCSV.length];
		
		parseCSV(inputCSV, output1, output2, output3, output4);
		
		for (char i : output1)
		{
			if (i != '\u0000')
			{
				System.out.print(i);
			}
			
		}
		System.out.println("");
		
		for (char i : output2)
		{
			if (i != '\u0000')
			{
				System.out.print(i);
			}
			
		}
		System.out.println("");
		
		for (char i : output3)
		{
			if (i != '\u0000')
			{
				System.out.print(i);
			}
			
		}
		System.out.println("");
		
		for (char i : output4)
		{
			if (i != '\u0000')
			{
				System.out.print(i);
			}
		}
	}
	
	public static void parseCSV(char[] inputCSV, char[] output1, char[] output2, char[] output3, char[] output4)
	{
		int count = 0;
		int countDoubleQuotes = 0;
		int index, index2;

		index2 = 0;
		
		for (index = 0; index < inputCSV.length; index++)
		{
			if (inputCSV[index] == '\"')
			{
				countDoubleQuotes++;
				continue;
			}
			
			else if (countDoubleQuotes == 2)
			{
				count++;
				countDoubleQuotes = 0;
				index2 = 0;
				continue;
			}
			
			else
			{
				switch(count)
				{
					case 0 : output1[index2] = inputCSV[index];
					break;
					
					case 1 : output2[index2] = inputCSV[index];
					break;
					
					case 2 : output3[index2] = inputCSV[index];
					break;
					
					case 3 : output4[index2] = inputCSV[index];
					break;
				}
				
				index2++;
			}
		}
	}
}
