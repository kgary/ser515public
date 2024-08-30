abstract class Employee
{

/****
	public Employee()
	{
		name = "NONE";
		salary = 0.0;
		dept = -1;
	}
*/

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
	public PartTimeEmployee (String name, int dept, double salary)
	{
		super(name, dept, salary);
	}

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
	public FullTimeEmployee (String name, int dept, double salary, int options)
	{
		super(name, dept, salary);
		numOfOptions = options;
	}

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
