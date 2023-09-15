package ser515.inheritance;

public class Adder
{
	public double add(double x, double y)
	{
		System.out.print("Add double: ");
		return x + y;
	}
	public int add(int x, int y)
	{
		System.out.print("Add int: ");
		return x + y;
	}
	public static void main(String args[])
	{
		Adder object = new Adder();

		System.out.println(object.add(10.0,20.0));
		System.out.println(object.add(10,20));
		System.out.println(object.add(10.0F,20.0F));
		System.out.println(object.add(10.0F,20));
		System.out.println(object.add(10,20.0F));
	}
}
