package ser515.smells;

// Modified version of Smell1TheBestFactory to support the new framework IoC
public class Smell1TheBestFactorySimpleComponent implements IFrameworkComponent {

    public void runMe(IPower thePower, String numStr, String[] powers) {
	int num = Integer.parseInt(numStr);
	for (int j=0; j < powers.length; j++) {
	    System.out.println("The " + powers[j] + "th power of " + num + " is " + thePower.toPower(num, Integer.parseInt(powers[j])));
	}
    }
}
