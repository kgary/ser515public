import java.util.HashMap;
import java.util.Map;

class Company
{
	Map<String, Employee> employees = new HashMap<>();

	public void addEmployee(Employee e)
	{
		if (employeeExists(e.getName())) {
			System.out.println("User with same name already exists.");
		}
		else {
			employees.put(e.getName(), e);
		}
	}

	public void deleteEmployee(String name)
	{
		if (employeeExists(name)) {
			employees.remove(name);
		}
		else {
			System.out.println("No employee found");
		}
	}

	public void displayAllEmployees()
	{
		for (String key : employees.keySet())
		{
			Employee temp = employees.get(key);
			temp.display();
		}
	}

	private boolean employeeExists(String name) {
		return employees.containsKey(name);
	}
}
