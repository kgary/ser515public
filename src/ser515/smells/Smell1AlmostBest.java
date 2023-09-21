package ser515.smells;

import java.util.Map;
import java.util.HashMap;

// This code will return the 1st argument to the power of all subsequent arguments
// This one caches our results for later reuse
public class Smell1AlmostBest {
    private static Map<Integer, Map<Integer, Integer>> __cache = new HashMap<Integer, Map<Integer, Integer>>();
    public static void main(String[] args) {
	if (args.length < 2) {
	    System.out.println("Usage: java ser515.smells.Smell1AlmostBest <num> <pow>+");
	    System.exit(-1);
	}
	int num = Integer.parseInt(args[0]);
	for (int j=1; j < args.length; j++) {
	    System.out.println("The " + args[j] + "th power of " + num + " is " + toPower(num, Integer.parseInt(args[j]))); 
	}
    }
    // What is the inefficiency here?
    private static int toPower(int n, int pow) {
	Map<Integer, Integer> entry = __cache.get(n);
	Integer res = null;
	if (entry != null) {
	    res = entry.get(pow);
	    if (res == null) {
		res = calcPower(n, pow);
		entry.put(pow, res);
	    }
	} else {
	    res = calcPower(n, pow);
	    entry = new HashMap<Integer, Integer>();
	    entry.put(pow, res);
	    __cache.put(n, entry);
	}
	return res;
    }
    private static int calcPower(int n, int pow) {
	if (pow == 0) return 1;
	int res = 1;
	for (int i = 0; i < pow; res *= n, i++) ;;;
	return res;
    }
}
