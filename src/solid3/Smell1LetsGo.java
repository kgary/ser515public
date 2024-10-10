package ser515.smells;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.lang.reflect.Method;

// BEHOLD THE POWER OF JAVA GENERICS, REFLECTION, AND RECURSION!!!
// Can you refactor this to apply the Template+Strategy patterns for expressive efficiency?
public class Smell1LetsGo {
    private static Map<String, Map<Integer, Map<Integer, Integer>>> __cacheOfCaches = new HashMap<String, Map<Integer, Map<Integer, Integer>>>();

    public static void main(String[] args) {
	List<String> operations = new ArrayList<>(List.of("ack", "pow", "summation"));
	for (String func : operations) {
	    __cacheOfCaches.put(func, new HashMap<Integer, Map<Integer, Integer>>());
	}

	if (args.length < 3 || !operations.contains(args[0])) {
	    System.out.println("Usage: java ser515.smells.Smell1LetsGo <op> <num> <pow>+");
	    System.exit(-1);
	}
	Method method = null;
	Integer result = null;
	try {
	    // Let's find the method associated with <op>
	    Class thisClass = Smell1LetsGo.class;
	    method = thisClass.getDeclaredMethod(args[0], Integer.class, Integer.class, Map.class);
	    method.setAccessible(true);
	} catch(Throwable t) {
	    System.out.println("Unable to identify function " + args[0]);
	    System.exit(-1);
	}

	int num = Integer.parseInt(args[1]);
	for (int j=2; j < args.length; j++) {
	    try {
		result = (Integer)method.invoke(null, num, Integer.parseInt(args[j]), __cacheOfCaches.get(args[0]));
	    } catch (Throwable t2) {
		System.out.println("Unable to call " + args[0] + " on " + args[j]);
		break;
	    }
	    System.out.println("The " + args[0] + " of " + args[j] + " on " + num + " is " + result);
	}
    }

    /*
      QUESTION FOR THE BELOW: How could you refactor and make concise using the Template and Strategy patterns?
    */
 
    private static int pow(Integer n, Integer pow, Map<Integer, Map<Integer, Integer>> cache) {
	Map<Integer, Integer> entry = cache.get(n);
	
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
    // A(m, n) => 𝐴(0,𝑛)=n+1  if m==0
    // A(m-1,1) if n==0,  
    // otherwise = 𝐴(𝑚−1,𝐴(𝑚,𝑛−1)
    private static int ack(Integer n, Integer a, Map<Integer, Map<Integer, Integer>> cache) {
	Map<Integer, Integer> entry = cache.get(n);
	
	if (entry == null) {
	    entry = new HashMap<Integer, Integer>();
	}
	return toCachedAckermann(entry, n, a);
    }
    // The contract here is we know there is a cache entry so no check required (DBC)
    private static int toCachedAckermann(Map<Integer, Integer> e, int n, int a) {
	Integer res = null;
	Integer resa = null;
	if (n == 0) {
	    res = a+1;
	} else if (a == 0) {
	    res = ack(n-1, 1, __cacheOfCaches.get("ack")); 
	} else {
	    resa = e.get(a-1);
	    if (resa == null) {
		resa = toCachedAckermann(e, n, a-1);
		e.put(a-1, resa);
	    }
	    res = ack(n-1, resa, __cacheOfCaches.get("ack")); // I can't call cached version here - why?
	}
	e.put(a-1, res);
	return res;
    }
    private static int summation(Integer n, Integer s, Map<Integer, Map<Integer, Integer>> cache) {
	Map<Integer, Integer> entry = cache.get(n);
	
	if (entry == null) {
	    entry = new HashMap<Integer, Integer>();
	}
	return toCachedSum(entry, n, s);
    }
    // The contract here is we know there is a cache entry so no check required (DBC)
    private static int toCachedSum(Map<Integer, Integer> e, int n, int s) {
	Integer res = null; 
	if (s == 0) {
	    res = 0;
	} else {
	    res = e.get(s);
	    if (res != null) {
		return res;
	    } else {
		res = n + toCachedSum(e, n, s-1);
		e.put(s, res); // saves each intermediate result in the cache
	    }
	}
	return res;
    }
}
