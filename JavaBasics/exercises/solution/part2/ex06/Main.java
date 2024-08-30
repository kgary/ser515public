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

class Employee
{
	public Employee()
	{
		name = "NONE";
		salary = 0.0;
		dept = -1;
	}

	public Employee (String name, int dept, double salary)
	{
		setInfo(name, dept, salary);
	}

	
	public static void setLogFile(PrintStream newFile)
	{
		logFile = newFile;
	}

	public void setInfo(String name, int dept, double salary)
	{
		logFile.println("Setting info for " + this);
		this.name = name;
		this.salary = salary;
		this.dept = dept;
	}

	public double computeBonus()
	{
		logFile.println("Computing bonus for " + this);
		double bonus;

		if (dept < 1000)
			bonus = salary * 0.01;
		else
			bonus = salary * 0.05;

		return bonus;
	}

	public void display()
	{
		logFile.println("Displaying info for " + this);
		System.out.println("Name: " + name + "  Dept: " + dept + "  Wage: " + salary);
	}

	public String toString()
	{
		return name;
	}

	private int 	dept;
	private double	salary;
	private String	name;

	private static PrintStream logFile;
}
