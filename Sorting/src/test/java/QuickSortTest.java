import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class QuickSortTest extends SortingTest{

    QuickSortTest() {
        super(SortingAlgorithmFactory.createSortingAlgorithm("quick"));
    }

    @Test
    @DisplayName("Test Quick Sort")
    public void testInstance() {
        assert(sortingAlgorithm instanceof QuickSort<Integer>);
    }
}

