class Adder
{
	public double add(double x, double y)
	{
		System.out.println("Add double");
		return x + y;
	}

	public int add(int x, int y)
	{
		System.out.println("Add int");
		return x + y;
	}
}

class Main
{
	public static void main(String args[])
	{
		Adder object = new Adder();

		System.out.println(object.add(10.0,20.0));
		System.out.println(object.add(10,20));
		System.out.println(object.add(10.0F,20.0F));
	}
}
