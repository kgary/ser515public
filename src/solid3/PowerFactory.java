package ser515.smells;

public class PowerFactory {
    private PowerFactory() {}

    public static IPower getPower() {
	String whichPower = System.getProperty("power"); // normally you would validate the property
	// so what is the problemhere? What happens when I want to extend the set of implementations?
	if (whichPower != null && whichPower.equalsIgnoreCase("cached")) {
	    System.out.println("Using CACHED");
	    return new PowerCached();
	}
	System.out.println("Using SIMPLE");
	return new PowerSimple();
    }
}
