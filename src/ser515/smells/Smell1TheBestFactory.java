package ser515.smells;

// This code will return the 1st argument to the power of all subsequent arguments
// This is the best, with a Factory to manage lifecycles and decoupling
public class Smell1TheBestFactory {

    public static void main(String[] args) {
	if (args.length < 2) {
	    System.out.println("Usage: java -Dpower=[simple|cached] ser515.smells.Smell1TheBestFactory <num> <pow>+");
	    System.exit(-1);
	}

	// Now the client (this main program) doesn't have to know how many implementations there are
	// or which one to choose, this can be externally configured, no new compile
	IPower thePower = PowerFactory.getPower();
	int num = Integer.parseInt(args[0]);
	for (int j=1; j < args.length; j++) {
	    System.out.println("The " + args[j] + "th power of " + num + " is " + thePower.toPower(num, Integer.parseInt(args[j])));	    
	}
    }
}
