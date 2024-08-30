class Main
{
	public static void main(String args[])
	{
		Company company = new Company();

		company.addEmployee(new PartTimeEmployee("Bob", 100, 10000.0));
		company.addEmployee(new FullTimeEmployee("Sue", 200, 20000.0, 20));
		company.addEmployee(new FullTimeEmployee("Sal", 300, 30000.0, 30));
		company.addEmployee(new PartTimeEmployee("Al",  400, 40000.0));
		company.addEmployee(new FullTimeEmployee("Joe", 500, 50000.0, 50));

		company.displayAllEmployees();

		company.deleteEmployee("Bob");
		company.deleteEmployee("Joe");

		System.out.println();
		company.displayAllEmployees();
	}
}