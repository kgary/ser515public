package ser515.unittest;

import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SelectClasses;

// The suite will aggregate tests acrosss test classes
@Suite
@SelectClasses( { SimpleSquareRootTest.class, SimpleSquareRootClassTest.class } )
class SimpleSquareRootTestSuite {
    // nothing to do here!
}
