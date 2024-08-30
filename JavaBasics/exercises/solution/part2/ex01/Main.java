class Employee
{
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
		System.out.println("Name: "+name+"  Dept: "+dept+"  Wage: "+salary);
	}

	private int 	dept;
	private double	salary;
	private String	name;
}


class Main
{
	public static void main(String args[])
	{
		// Manipulate one Employee
		Employee p = new Employee();

		p.setInfo("Bob", 1000, 20000.0);
		p.display();
		System.out.println(p.computeBonus());


		// Manipulate an array of Employees
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

	}
}
