import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

class Company
{
	List<Employee> employees = new ArrayList<>();

	public void addEmployee(Employee a)
	{
		employees.add(a);
	}

	public void deleteEmployee(String name)
	{
		for (int i=0; i < employees.size(); i++)
		{
			Employee temp = employees.get(i);
			if (temp.getName().equals(name))
				employees.remove(temp);
		}
	}

	public void displayAllEmployees()
	{
		for (int i=0; i < employees.size(); i++)
		{
			Employee temp = employees.get(i);
			temp.display();
		}
	}
}
