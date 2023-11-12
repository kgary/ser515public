package ser515.unittest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class SimpleSquareRootTest2 {
	
    @Test
    void testMakeSqrt() {
	// note both are run with one test reporting. If the 1st assert fails next one is not called
	assertEquals(0.0, SimpleSquareRootFunction.makeSqrt(1));  // x-1 = 0
	assertEquals(0.0, SimpleSquareRootFunction.makeSqrt(-1));  // x+2 = 0
    }
    @Test
    void testMakeSqrt2() {
	// what is the problem here?
	assertEquals(Math.sqrt(3), SimpleSquareRootFunction.makeSqrt(2));  // x-1=1, x+2=3, so sqrt of 3 so this is wrong
    }
    
    // or we could try TestAll
    @Test
    void testMakeSqrtZeroAll() {
	// The magic of lambdas. Also showing optional labels. This should pass.
	// we could then create different test methods for each equivalnce class whic iss OK.
	assertAll("Combining all zero tests",
		  () -> assertEquals(0.0, SimpleSquareRootFunction.makeSqrt(1), "Test for x=1"),   // x-1 = 0
		  () -> assertEquals(0.0, SimpleSquareRootFunction.makeSqrt(-2), "Test for x=-2")  // x+2 = 0
		  );
    }

    // this is an alternative that will show one test with 2 subtests (thee repeated tests)
    // ValueSource is an annotation for a sequence of literal values, must be named for the type + s
    // There are other "generators" you can use to parameterize the test, this is the easiest
    @ParameterizedTest
    @ValueSource(ints = {1, -2})
    void testMakeSqrtZeroParam(int x) {
	assertEquals(0.0, SimpleSquareRootFunction.makeSqrt(x));
    }
}
