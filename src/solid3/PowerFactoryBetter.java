package ser515.smells;

public class PowerFactoryBetter {
    private PowerFactoryBetter() {}

    public static IPower getPower() {
	String whichPower = System.getProperty("power"); // normally you would validate the property
	// now treat the property value like a classname
	try {
	    Class powerClass = Class.forName(whichPower);
	    return (IPower)powerClass.newInstance();  // need a cast because forInstance returns Object
	} catch (Throwable t) {
	    // we'll talk better exception handling later!
	    System.out.println("Unable to create an instance of " + whichPower + ", returning simple instead");
	    // when you use this kind of pattern, you can handle failure different ways, including providing a fallback
	    return new PowerSimple();
	}
    }
}
