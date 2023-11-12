package ser515.unittest;

public class SimpleSquareRootClass {
    private int x;
    
    public SimpleSquareRootClass(int x) {
	this.x = x;
    }
    // Nobody said you need a main in your source to run a JUnit test against it
    
    public double makeSqrt() {
	return Math.sqrt((x-1) * (x+2));
    }
}
    
