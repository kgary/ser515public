class StaticExample
{
	public static void main(String args[])
	{
		Point p1 = new Point(0, 0);
		Point p2 = new Point(1,1);

		System.out.println("point count = " + p1.currentCount());

		p1 = new Point(3, 4);

		System.out.println("point count = " + Point.currentCount());
		p1.print();

		System.out.println();
		System.gc();
		System.runFinalization();

		System.out.println("point count = " + Point.currentCount());
		p1.print();
		p2.print();
	}
}

class Point
{
	Point (int initX, int initY)
	{
		x = initX;
		y = initY;
		count++;
	}

	public void finalize ()
	{
		count--;
	}

	// Static method cannot access non-static x and y
	public static int currentCount () 
	{
		return count;
	} 

	// Non-static method can access static count
	public void print ()
	{ 
		System.out.println ("(" + count + ") x=" + x + " y=" + y);
	}

	private static int count = 0;	// must be initialized at declaration
	private int x, y;
}