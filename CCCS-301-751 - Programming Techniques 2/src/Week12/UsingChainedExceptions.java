package Week12;
/*
	Name:			Yannick Decosse
	McGill ID:		260551160
	Course ID:		CCCS-301-751 - Programming Techniques 2
	Instructor: 	Joseph Vybihal
	Date:			March 21, 2015
	Exercises:		Exception Handlings
 */

public class UsingChainedExceptions
{
	public static void main(String[] args)
	{
		try
		{
			method1();
		}
		
		//	exception thrown from method1
		catch (Exception exception)
		{
			exception.printStackTrace();
		}
	}
	
	public static void method1() throws Exception
	{
		try
		{
			method2();
		}
		
		//	exception thrown from method2
		catch (Exception exception)
		{
			throw new Exception("Exception thrown in method1", exception);
		}
	}
	
	public static void method2() throws Exception
	{
		try
		{
			method3();
		}
		
		//	exception thrown from method3
		catch (Exception exception)
		{
			throw new Exception("Exception thrown in method2", exception);
		}
	}
	
	public static void method3() throws Exception
	{
		throw new Exception("Exception thrown in method3");

	}
}
