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