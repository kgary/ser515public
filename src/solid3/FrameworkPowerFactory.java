package ser515.smells;

// Compatible with framework. But really we'd need a factory per type
public class FrameworkPowerFactory implements IFrameworkPowerFactory {
    public FrameworkPowerFactory() {}
    
    public IPower getPower(String whichPower) {
	// so what is the problem here? What happens when I want to extend the set of implementations?
	if (whichPower != null && whichPower.equalsIgnoreCase("cached")) {
	    System.out.println("Using CACHED");
	    return new PowerCached();
	}
	System.out.println("Using SIMPLE");
	return new PowerSimple();
    }
}
