import java.io.*;
class Main
{
	public static void main(String args[])
	{
		Employee.setLogFile(System.out);

		Employee list[] = new Employee[3];

		for (int i = 0; i <list.length; i++)
			list[i] = new Employee();

		list[0].setInfo("Joe", 400, 10000.0);
		list[1].setInfo("Sue", 1400, 20000.0);
		list[2].setInfo("Ann", 500, 30000.0);

		for (int i = 0; i < list.length; i++)
			list[i].display();

		for (int i = 0; i < list.length; i++)
			System.out.println(list[i].computeBonus());
	
		try
		{
			FileOutputStream 	file = new FileOutputStream("out.txt");
			PrintStream 		out = new PrintStream(file);
			Employee.setLogFile(out);

			for (int i = 0; i < list.length; i++)
				list[i].display();

			for (int i = 0; i < list.length; i++)
				System.out.println(list[i].computeBonus());
		}
		catch(Exception e) {e.printStackTrace();}
	}
}
