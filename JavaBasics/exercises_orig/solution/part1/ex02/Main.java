class Main
{
	public static void main(String args[])
	{
		System.out.println("Celsius\t\tFarenheit");
		for (int cel = 0; cel <= 100; cel += 5)
		{
                        int faren = (int) (9.0/5.0 * cel + 32);
			System.out.println(cel + "\t\t" + faren);
		}
		
	}
}
