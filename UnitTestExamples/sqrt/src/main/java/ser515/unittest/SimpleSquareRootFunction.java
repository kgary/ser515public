package ser515.unittest;

public class SimpleSquareRootFunction {
    public static void main(String[] args) {
	if (args.length != 1) {
	    System.out.println("USAGE: java SimpleSquareRootFunction <X>, where X is an integer");
	    System.exit(0);
	}
	System.out.println("The value of the square root of the product is: " + makeSqrt(Integer.parseInt(args[0])));
    }
    
    public static double makeSqrt(int x) {
	return Math.sqrt((x-1) * (x+2));
    }

    public static int squareMe(int x) {
	return x*x;
    }
}
    
