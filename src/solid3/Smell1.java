package ser515.smells;

// This code will return the 1st argument to the power of all subsequent arguments
// Does this code smell? If so, why? What best programming practice does it violate?
public class Smell1 {
    public static void main(String[] args) {
	if (args.length < 2) {
	    System.out.println("Usage: java ser515.smells.Smell1 <num> <pow>+");
	    System.exit(-1);
	}
	int num = Integer.parseInt(args[0]);
	int tot = 1;
	for (int j = 1; j < args.length; j++) {
	    System.out.print("The " + args[j] + "th power of " + num + " is ");
	    for (int i = 0; i < Integer.parseInt(args[j]); tot *=num, i++) {
	    }
	    System.out.println(tot);
	    tot = 1;
	}
    }
}
