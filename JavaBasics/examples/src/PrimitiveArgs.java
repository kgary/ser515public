class PrimitiveTest
{
	void changeEm(int x, float y)
	{
		System.out.println("changeEm x=" + x + "  y=" + y);
		x = 100;
		y = 12.34F;
		System.out.println("changeEm x=" + x + "  y=" + y);
	}
}


class PrimitiveArgs
{
	public static void main (String args[])
	{
		PrimitiveTest object = new PrimitiveTest();
		int x = 10;
		float y = 1.2F;

		System.out.println("Main x=" + x + "  y=" + y);
		object.changeEm(x, y);
		System.out.println("Main x=" + x + "  y=" + y);
	}
}
