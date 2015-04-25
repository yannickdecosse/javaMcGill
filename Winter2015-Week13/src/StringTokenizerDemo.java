import java.util.StringTokenizer;

class StringTokenizerDemo
{
	static String in = "title	   =Testing StringTokenizer;" + "author	   =Yannick Decosse;" + "publisher=McGill University;" + "copyright=2015;";
	
	public static void main(String args[])
	{
		StringTokenizer st = new StringTokenizer(in, "=;");
		
		while(st.hasMoreTokens())
		{
			String key = st.nextToken();
			String val = st.nextToken();
			System.out.println(key + "\t" + val); 
		} 
	} 
}