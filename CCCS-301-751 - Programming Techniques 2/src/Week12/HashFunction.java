package Week12;
/*
	Name:			Yannick Decosse
	McGill ID:		260551160
	Course ID:		CCCS-301-751 - Programming Techniques 2
	Instructor: 	Joseph Vybihal
	Date:			March 21, 2015
	Exercises:		Hash Function
 */

import java.util.HashMap;
import java.util.Map;

public class HashFunction 
{
	private int hashCode;

	public static void main(String[] args) 
	{
	       Map<HashFunction, Integer> hashTable = new HashMap<HashFunction, Integer>();

	       HashFunction key1 = new HashFunction();
	       HashFunction key2 = new HashFunction();
	       HashFunction key3 = new HashFunction();

	       hashTable.put(key1, 1);
	       hashTable.put(key2, 2);
	       hashTable.put(key3, 2);

	       System.out.println("Size = " + hashTable.size());
	       System.out.println("Value when key1 is searched: " + hashTable.get(key1));
	       System.out.println("Value when key2 is searched: " + hashTable.get(key2));
	       System.out.println("Value when key3 is searched: " + hashTable.get(key3));
	}

	public int hashCode() 
	{
		hashCode= System.identityHashCode(this);
		return hashCode;
	}

	public boolean equals(Object obj) 
	{
		HashFunction other = (HashFunction) obj;
		
		if (this == obj)
		{
			return true;
		}

		else if (obj == null || getClass() != obj.getClass())
		{
			return false;
		}
			
		
		else if (hashCode != other.hashCode)
		{
			return false;
		}
		
		else
		{
			return true;
		}
	}
}