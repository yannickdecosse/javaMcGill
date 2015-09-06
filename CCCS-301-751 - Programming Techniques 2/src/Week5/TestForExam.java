package Week5;

public class TestForExam
{
	private int x = 8;
	int y, z;
	
	public int getX()
	{
		return x;
	}
	
	public void test()
	{
		int x = 5;
		System.out.println("x is " + x);
	}
	
	public static void main(String[] args)
	{
		TestForExam b = new TestForExam();
		System.out.println(b.x);
		b.test();
	}
}
