package ser515.smells;

import java.util.Map;
import java.util.HashMap;

// This code will return the 1st argument to the power of all subsequent arguments
// This is the best. You would add polish like bounded caching to avoid memory overflow, and
// I would factor the Caching part into a helper class or method at least. But yes this from a runtime
// perspective probably gives us the best solution for powers.
public class Smell1IsThisBest {
    private static Map<Integer, Map<Integer, Integer>> __cache = new HashMap<Integer, Map<Integer, Integer>>();
    public static void main(String[] args) {
	if (args.length < 2) {
	    System.out.println("Usage: java ser515.smells.Smell1ThisBest <num> <pow>+");
	    System.exit(-1);
	}
	int num = Integer.parseInt(args[0]);
	for (int j=1; j < args.length; j++) {
	    System.out.println("The " + args[j] + "th power of " + num + " is " + toPower(num, Integer.parseInt(args[j]))); 
	}
    }
    // resolves the inefficiency in AlmostBest
    private static int toPower(int n, int pow) {
	Map<Integer, Integer> entry = __cache.get(n);
	
	if (entry == null) {
	    entry = new HashMap<Integer, Integer>();
	}
	return toCachedPower(entry, n, pow);
    }
    // The contract here is we know there is a cache entry so no check required (DBC)
    private static int toCachedPower(Map<Integer, Integer> e, int n, int pow) {
	Integer res = null; 
	if (pow == 0) {
	    res = 1;
	} else {
	    res = e.get(pow);
	    if (res != null) {
		return res;
	    } else {
		res = n * toCachedPower(e, n, pow-1);
		e.put(pow, res); // saves each intermediate result in the cache
	    }
	}
	return res;
    }
}
