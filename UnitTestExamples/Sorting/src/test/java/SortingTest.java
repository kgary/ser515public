import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public abstract class SortingTest {
    ISort<Integer> sortingAlgorithm;

    SortingTest(ISort<Integer> algo) {
        this.sortingAlgorithm = algo;
    }

    @Test
    public void testEmptyArray() {
        Integer[] emptyArray = {};
        this.sortingAlgorithm.sort(emptyArray);
        assertArrayEquals(new Integer[]{}, emptyArray);
    }

    @Test
    public void testSingleElementArray() {
        Integer[] singleElementArray = {5};
        sortingAlgorithm.sort(singleElementArray);
        assertArrayEquals(new Integer[]{5}, singleElementArray);
    }

    @Test
    public void testDuplicateElementArray() {
        Integer[] duplicateArray = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
        sortingAlgorithm.sort(duplicateArray);
        assertArrayEquals(new Integer[]{1, 1, 2, 3, 3, 4, 5, 5, 5, 6, 9}, duplicateArray);
    }

    @Test
    public void testNegativeElementArray() {
        Integer[] negativeArray = {-3, -1, -4, -1, -5, -9, -2, -6, -5, -3, -5};
        sortingAlgorithm.sort(negativeArray);
        assertArrayEquals(new Integer[]{-9, -6, -5, -5, -5, -4, -3, -3, -2, -1, -1}, negativeArray);
    }

    @Test
    public void testEqualElementArray() {
        Integer[] equalArray = {2, 2, 2, 2, 2, 2};
        sortingAlgorithm.sort(equalArray);
        assertArrayEquals(new Integer[]{2, 2, 2, 2, 2, 2}, equalArray);
    }

    @Test
    public void testSortedArray() {
        Integer[] sortedArray = {1, 2, 3, 4, 5, 6};
        sortingAlgorithm.sort(sortedArray);
        assertArrayEquals(new Integer[]{1, 2, 3, 4, 5, 6}, sortedArray);
    }

    @Test
    public void testReverseSortedArray() {
        Integer[] reverseSortedArray = {6, 5, 4, 3, 2, 1};
        sortingAlgorithm.sort(reverseSortedArray);
        assertArrayEquals(new Integer[]{1, 2, 3, 4, 5, 6}, reverseSortedArray);
    }

    @Test
    public void testRandomArray() {
        Integer[] randomArray = {4, 2, 7, 1, 9, 5};
        sortingAlgorithm.sort(randomArray);
        assertArrayEquals(new Integer[]{1, 2, 4, 5, 7, 9}, randomArray);
    }

}
