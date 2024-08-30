class Main
{
	public static void main(String args[])
	{
		Company acme = new Company();

		Employee e1 = new Employee("Joe", 400, 10000.0);
		acme.addEmployee(e1);
		Employee e2 = new Employee("Bill", 600, 20000.0);
		acme.addEmployee(e2);
		acme.addEmployee(new Employee("Ann", 500, 30000.0));
		acme.addEmployee(new Employee("Sue", 700, 40000.0));

		acme.displayAll();
		System.out.println("Bonus cost is $" + acme.totalBonus());

		System.out.println();
		Employee temp = acme.getEmployee("Ann");
		temp.display();
		System.out.println(temp.getName() + " has a bonus of " + temp.computeBonus());
	}
}