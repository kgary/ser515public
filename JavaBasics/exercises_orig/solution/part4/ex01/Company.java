import java.util.Vector;

class Company
{
	Vector employees = new Vector(5);

	public void addEmployee(Employee a)
	{
		employees.addElement(a);
	}

	public void deleteEmployee(String name)
	{
		for (int i=0; i < employees.size(); i++)
		{
			Employee temp = (Employee) employees.elementAt(i);
			if (temp.getName().equals(name))
				employees.removeElement(temp);
		}
	}

	public void displayAllEmployees()
	{
		for (int i=0; i < employees.size(); i++)
		{
			Employee temp = (Employee) employees.elementAt(i);
			temp.display();
		}
	}
}
