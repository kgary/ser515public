public class SortingAlgorithmFactory {
    public static ISort<Integer> createSortingAlgorithm(String algorithmName) {
        if (algorithmName.equalsIgnoreCase("bubble")) {
            return new BubbleSort<>();
        } else if (algorithmName.equalsIgnoreCase("quick")) {
            return new QuickSort<>();
        } else {
            throw new IllegalArgumentException("Invalid sorting algorithm name.");
        }
    }
}
