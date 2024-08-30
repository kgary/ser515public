import java.io.*;

class GraphRead
{
	public static void main(String args[])
	{
		try
		{

//			If we were using Streams...
//			FileInputStream		file = new FileInputStream("graph.txt");
//			InputStreamReader	bridge = new InputStreamReader(file);
//			StreamTokenizer		tokens = new StreamTokenizer(bridge);

			FileReader 			file = new FileReader("graph.txt");
			StreamTokenizer		tokens = new StreamTokenizer(file);

			while (tokens.nextToken() != tokens.TT_EOF)
			{
				int number = (int) tokens.nval;
				tokens.nextToken();
				String label = tokens.sval;
				tokens.nextToken();
				String color = tokens.sval;
				
				System.out.println(number + " * " + label + " * " + color);
			}
		}
		catch (Exception e) {e.printStackTrace();}
	}
}

