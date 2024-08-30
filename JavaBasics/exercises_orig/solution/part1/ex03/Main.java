class Main
{
	public static void main(String args[])
	{
		String 	name;
		double	payRate;
		double 	hoursWorked;
		double	pay;

		name = Console.readString("Enter employee name: ");
		payRate = Console.readDouble("Enter pay rate: ");
		hoursWorked = Console.readDouble("Enter hours worked: ");

		while (!name.equals("DONE") && payRate > 0)
		{
			if (hoursWorked <= 40)
				pay = payRate*hoursWorked;
			else
				pay = payRate*40 + payRate*(hoursWorked-40)*1.5;
		
			System.out.println("Paycheck for " + name + " is $" + pay + "\n");

			name = Console.readString("Enter employee name: ");
			payRate = Console.readDouble("Enter pay rate: ");
			hoursWorked = Console.readDouble("Enter hours worked: ");
		}
	}
}