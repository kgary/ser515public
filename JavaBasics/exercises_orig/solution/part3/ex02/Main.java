class Main
{
	public static void main(String args[])
	{
		Employee list[] = new Employee[5];

		list[0] = new PartTimeEmployee("Bob", 100, 10000.0);
		list[1] = new FullTimeEmployee("Sue", 200, 20000.0, 20);
		list[2] = new FullTimeEmployee("Sal", 300, 30000.0, 30);
		list[3] = new PartTimeEmployee("Al",  400, 40000.0);
		list[4] = new FullTimeEmployee("Joe", 500, 50000.0, 50);

		for (int i=0; i < list.length; i++)
			list[i].display();

		for (int i=0; i < list.length; i++)
			if (list[i] instanceof FullTimeEmployee)
				((FullTimeEmployee) list[i]).increaseOptions(100);

		System.out.println();
		for (int i=0; i < list.length; i++)
			list[i].display();

		System.out.println();
		for (int i=0; i < list.length; i++)
			System.out.println(list[i] + " bonus: " + list[i].computeBonus());

	}
}