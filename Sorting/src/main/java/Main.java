import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String sortingAlgorithmName = System.getProperty("factory");
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the array
        System.out.print("Enter the array elements separated by spaces: ");
        String input = scanner.nextLine();
        String[] elements = input.split(" ");

        // Convert the user input to an array of integers
        Integer[] intArray = new Integer[elements.length];
        for (int i = 0; i < elements.length; i++) {
            intArray[i] = Integer.parseInt(elements[i]);
        }

        ISort<Integer> sortingAlgorithm;
        if (sortingAlgorithmName != null) {
            sortingAlgorithm = SortingAlgorithmFactory.createSortingAlgorithm(sortingAlgorithmName);
        } else {
            System.out.println("Sorting algorithm not specified. Using Bubble Sort by default.");
            sortingAlgorithm = SortingAlgorithmFactory.createSortingAlgorithm("bubble");
        }

        // Sort the array using the chosen algorithm
        sortingAlgorithm.sort(intArray);
        System.out.println("Sorted array using the " + sortingAlgorithmName + " sort algorithm: " + Arrays.toString(intArray));

        scanner.close();
    }
}
