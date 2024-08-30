import java.util.Scanner;

class Main
{
	public static void main(String args[])
	{
		String line;

		Scanner scanner = new Scanner(System.in);

		line = scanner.nextLine();
		while (!line.equals("END"))
		{
			String first	= line.substring(0,10);
			String state	= line.substring(10,12);
			String last		= line.substring(12,22);
			String zip		= line.substring(22,27);
			String city		= line.substring(27,37);
			String address	= line.substring(37);

			first = first.replace('*', ' ').trim();
			last = last.replace('*', ' ').trim();
			city = city.replace('*', ' ').trim();
			address = address.replace('*', ' ').trim();

			state = state.toUpperCase();

			if (last.lastIndexOf("witz") == -1)
			{
				System.out.println(last + ", " + first);
				System.out.println(address);
				System.out.println(city + ", " + state + " " + zip);
				System.out.println();
			}

			line = scanner.nextLine();
		}
		scanner.close();
	}
}