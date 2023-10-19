package ser515.smells;

import java.util.Arrays;

// These interfaces are intended to define entry points that
// components compatible with this mock framework would implement.
// In this mock implementation we would not have this source, we
// would only have the binaries and a process by which to start.
// The first interface is what is "run", the second interface
// is called first to allow you to provide a local way to configure
interface IFrameworkComponent  {
    public void runMe(IPower thePower, String num, String[] powers);
}
interface IFrameworkPowerFactory {
    public IPower getPower(String componentType);
}

// This simple mock framework inverts control (IoC) by owning the main thread
// and spawning threads to invoke behaviors under a contract. The primary behavior
// is "runMe" above, but we also have a contract on creating the runMe component
// via a factory. Note this example also does a simple form of DI by injecting
// the IPower implementation into the component, which it does per method
// invocation (which iss very unusual) as you would use other forms of injection
// (constructor, setter) for more stateful and reusable objects.

// Obviously) the framework wouldn't know the types of the client code
// (FrameworkPowerFactory and Smell1TheBestFactorySimpleComponent), instead you
// would expect one of the following:
//   1. An external configuration file (Spring used to rely on XML files)
//   2. Annotations on the client codde instead of interface types (Spring does this now)
//   3. If sticking with interfaces, you can write code to scan for client code that
//      implements those interfaces and if found automagically invoke them.
// But yeah, as a class example I didn't do all that. If you do it please submit a PR!

public class Smell1Framework {
    public static void main(String args[]) {
	// this simple framework will run all of the components
	// implementing FrameworkComponentInterface it is told about
	// via a multivalued property named "components"
	if (args.length < 2) {
	    System.out.println("Usage: java -Dcomponents=[list of simple/cached] ser515.smells.Smell1Framework <num> <pow>+");
	    System.exit(-1);
	}
	String[] components = System.getProperty("components").split(",");
	IFrameworkComponent theComponent = null;
	IFrameworkPowerFactory theFactory = new FrameworkPowerFactory();
	// for each component, create a Thread and run
	for (String c : components) {
	    IPower thePower = theFactory.getPower(c);
	    new Thread(() -> { new Smell1TheBestFactorySimpleComponent().runMe(thePower, args[0], Arrays.copyOfRange(args, 1, args.length)); }).start();
	}
    }
}
