import java.util.Scanner;

class Main
{
	public static void main(String args[])
	{
		int arr[];
		int size;

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number of values: ");
		size = scanner.nextInt();
		arr = new int[size];

		//Read the values
		System.out.println("Enter " + size + " integers, one per line:");
		for (int i = 0; i < arr.length; i++)
			arr[i] = scanner.nextInt();

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
		scanner.close();
	}
}