class Main
{
	public static void main(String args[])
	{
		int arr[];
		int size;

		size = Console.readInt("Enter the number of values :");
		arr = new int[size];

		//Read the values
		System.out.println("Enter " + size + " integers, one per line:");
		for (int i = 0; i < arr.length; i++)
			arr[i] = Console.readInt();

		//Compute the average value
		int sum = 0;
		for (int i = 0; i < arr.length; i++)
			sum += arr[i];
		System.out.println("Average is " + sum/arr.length);

		
		//Find the min and max values
		int min = arr[0];
		int max = arr[0];
		for (int i = 1; i < arr.length; i++)
		{
			if (arr[i] < min)
				min = arr[i];
			else if (arr[i] > max)
				max = arr[i];
		}
		System.out.println("Min value is " + min + " and max value is " + max);
	}
}