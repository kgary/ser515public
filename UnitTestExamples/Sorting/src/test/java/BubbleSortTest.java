
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BubbleSortTest extends SortingTest {

    BubbleSortTest() {
        super(SortingAlgorithmFactory.createSortingAlgorithm("bubble"));
    }

    @Test
    @DisplayName("Test Bubble Sort")
    public void testInstance() {
        assert(sortingAlgorithm instanceof BubbleSort<Integer>);
    }
}