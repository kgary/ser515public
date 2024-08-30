class Main
{
	public static void main(String args[])
	{
		int		commaCount = 0;
		int		dollarCount = 0;
		int 	carriageCount = 0;
		char	ch;

		ch = Console.readChar();
		while (ch != '#')
		{
			switch (ch)
			{
				case ',':	commaCount++;
							break;
				case '$':	dollarCount++;
							break;
				case '\n':	carriageCount++;
							break;
			}
			ch = Console.readChar();
		}

		System.out.println("Commas:\t\t" + commaCount);
		System.out.println("Dollars:\t" + dollarCount);
		System.out.println("Returns:\t" + carriageCount);
	}
}