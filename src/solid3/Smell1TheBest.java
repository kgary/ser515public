package ser515.smells;
  
// This code will return the 1st argument to the power of all subsequent arguments
// This is the best. You would add polish like bounded caching to avoid memory overflow, and
// I would factor the Caching part into a helper class or method at least. But yes this from a runtime
// perspective probably gives us the best solution for powers.
public class Smell1TheBest {

    public static void main(String[] args) {
	if (args.length < 2) {
	    System.out.println("Usage: java ser515.smells.Smell1TheBest <num> <pow>+");
	    System.exit(-1);
	}

	// What is the problem here? What happens when I want to change the power implementation?
	IPower simplePower = new PowerSimple();
	//IPower cachedPower = new PowerCached();
	
	int num = Integer.parseInt(args[0]);
	for (int j=1; j < args.length; j++) {
	    System.out.println("SIMPLE: The " + args[j] + "th power of " + num + " is " + simplePower.toPower(num, Integer.parseInt(args[j])));
	    //System.out.println("CACHED: The " + args[j] + "th power of " + num + " is " + cachedPower.toPower(num, Integer.parseInt(args[j]))); 
	}
    }
}
