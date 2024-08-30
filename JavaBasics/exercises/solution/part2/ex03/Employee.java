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

	public double computeBonus()
	{
		double bonus;

		if (dept < 1000)
			bonus = salary * 0.01;
		else
			bonus = salary * 0.05;

		return bonus;
	}

	public void display()
	{
		System.out.println("Name: " + name + "  Dept: " + dept + "  Wage: " + salary);
	}

	private int 	dept;
	private double	salary;
	private String	name;
}
