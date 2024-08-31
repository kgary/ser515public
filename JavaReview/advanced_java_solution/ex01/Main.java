import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String args[]) {
        List<Integer> numbers = new ArrayList<>();
        int size;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of values: ");
        size = scanner.nextInt();

        System.out.println("Enter " + size + " integers, one per line:");
        for (int i = 0; i < size; i++)
            numbers.add(scanner.nextInt());

        int max = numbers.stream()
                .max(Comparator.naturalOrder()).orElse(Integer.MAX_VALUE);
        int min = numbers.stream()
                .min(Comparator.naturalOrder()).orElse(Integer.MIN_VALUE);

        System.out.println("Min value is " + min + " and max value is " + max);
        scanner.close();
    }
}