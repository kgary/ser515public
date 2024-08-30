class Company
{
	public void addEmployee(Employee e)
	{
		employees[size] = e;
		size++;
	}

	public Employee getEmployee(String name)
	{
		boolean	found = false;
		int		i = 0;

		while (!found && i < size)
			if (employees[i].getName().equals(name))
				found = true;
			else
				i = i + 1;

		if (found)
			return employees[i];
		else
			return null;
	}

	public void displayAll()
	{
		for (int i=0; i < size; i++)
			employees[i].display();
	}
	
	public double totalBonus()
	{
		double total = 0.0;
		for (int i=0; i < size; i++)
			total = total + employees[i].computeBonus();

		return total;
	}

	private Employee employees[] = new Employee[10];
	private int size = 0;
}
