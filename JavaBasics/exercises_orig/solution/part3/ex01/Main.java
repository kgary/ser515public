abstract class Employee
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


	public String toString()
	{
		return name;
	}

	
	public void setInfo(String name, int dept, double salary)
	{
		this.name = name;
		this.salary = salary;
		this.dept = dept;
	}

	public String getName()
	{
		return name;
	}

	public int getDept()
	{
		return dept;
	}

	public double getSalary()
	{
		return salary;
	}

	public void display()
	{
		System.out.println("Name: " + name + "  Dept: " + dept + "  Wage: " + salary);
	}

	public void raise(double amount)
	{
		salary = salary + amount;
	}


	public abstract double computeBonus();


	protected int 		dept;
	protected double	salary;
	protected String	name;
}

class PartTimeEmployee extends Employee
{
	public double computeBonus()
	{
		return 0.01 * salary;
	}

	public void display()
	{
		System.out.print("PartTime - ");
		super.display();
	}
}

class FullTimeEmployee extends Employee
{
	public double computeBonus()
	{
		return 0.03 * salary + 100 * numOfOptions;
	}

	public void display()
	{
		System.out.print("FullTime - Options: " + numOfOptions + " ");
		super.display();
	}

	public int getOptions()
	{
		return numOfOptions;
	}

	public void increaseOptions(int number)
	{
		numOfOptions += number;
	}

	private int numOfOptions = 0;
}


class Main
{
	public static void main(String args[])
	{
		Employee list[] = new Employee[5];

		list[0] = new PartTimeEmployee();
		list[1] = new FullTimeEmployee();
		list[2] = new FullTimeEmployee();
		list[3] = new PartTimeEmployee();
		list[4] = new FullTimeEmployee();

		list[0].setInfo("Bob", 100, 10000.0);
		list[1].setInfo("Sue", 200, 20000.0);
		list[2].setInfo("Sal", 300, 30000.0);
		list[3].setInfo("Al",  400, 40000.0);
		list[4].setInfo("Joe", 500, 50000.0);

		for (int i=0; i < list.length; i++)
			list[i].display();

		for (int i=0; i < list.length; i++)
		{
			if (list[i] instanceof FullTimeEmployee)
			{
				FullTimeEmployee temp = (FullTimeEmployee) list[i];
				temp.increaseOptions(100);

				// or ((FullTimeEmployee) list[i]).increaseOptions(100);
			}
		}

		System.out.println();
		for (int i=0; i < list.length; i++)
			list[i].display();

		System.out.println();
		for (int i=0; i < list.length; i++)
			System.out.println(list[i] + " bonus: " + list[i].computeBonus());

	}
}