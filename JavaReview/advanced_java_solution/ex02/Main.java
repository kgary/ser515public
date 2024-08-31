import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String args[]) {
        List<Integer> numbers = new ArrayList<>();
        int size;
        final int[] sum = {0}; // lambda expressions require variables that are effectively final

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of values: ");
        size = scanner.nextInt();

        System.out.println("Enter " + size + " integers, one per line:");
        for (int i = 0; i < size; i++)
            numbers.add(scanner.nextInt());

        numbers.forEach(num -> sum[0] += num);
        System.out.println("Sum of the array elements is " + sum[0]);

        double avg = (double) sum[0] / (double) size;
        System.out.println("Average is " + avg);
    }
}