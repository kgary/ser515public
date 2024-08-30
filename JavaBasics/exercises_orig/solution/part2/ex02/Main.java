class Employee
{
	// Add constructors, a default and a non-default
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

class Main
{
	public static void main(String args[])
	{
		Employee list[] = new Employee[3];

		list[0] = new Employee("Joe", 400, 10000.0);
		list[1] = new Employee();
		list[2] = new Employee("Ann", 500, 30000.0);

		for (int i = 0; i < list.length; i++)
			list[i].display();

		for (int i = 0; i < list.length; i++)
			System.out.println(list[i].computeBonus());

	}
}