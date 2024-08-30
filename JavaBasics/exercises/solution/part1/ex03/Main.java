import java.util.Scanner;

class Main
{
	public static void main(String args[])
	{
		String 	name;
		double	payRate;
		double 	hoursWorked;
		double	pay;

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter employee name: ");
		name = scanner.next();
		System.out.println("Enter pay rate: ");
		payRate = scanner.nextDouble();
		System.out.println("Enter hours worked: ");
		hoursWorked = scanner.nextDouble();

		while (!name.equals("DONE") && payRate > 0)
		{
			if (hoursWorked <= 40)
				pay = payRate*hoursWorked;
			else
				pay = payRate*40 + payRate*(hoursWorked-40)*1.5;
		
			System.out.println("Paycheck for " + name + " is $" + pay + "\n");

			System.out.println("Enter employee name: ");
			name = scanner.next();
			System.out.println("Enter pay rate: ");
			payRate = scanner.nextDouble();
			System.out.println("Enter hours worked: ");
			hoursWorked = scanner.nextDouble();
		}

		scanner.close();
	}
}
