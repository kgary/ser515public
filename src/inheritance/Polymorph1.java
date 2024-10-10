package ser515.inheritance;

/**
   Polymorph1 demonstrates the ability to assign an
   ancestor OR to a descendant object type.
*/
public class Polymorph1
{
    private static int _count = 0;

    public static int getCount()
    { return ++_count; }

    public static void main(String[] args)
    {
	// Reference to the root class of the hierarchy
	Root rootRef = new Root();

	rootRef.print();  // 1

	// Now change the reference to refer to an object
	// that subclasses Root
	rootRef = new RootSub();

	rootRef.print();  // 2

	// Now change the reference to refer to an object
	// that subclasses RootSub (a descendant of Root)
	rootRef = new RootDesc();

	rootRef.print();  // 3

	// the following assignments are all legal, as are
	// the method invocations

	// when assigning an object reference to the value of another
	// object reference that is of an ancestor type, you must
	// downward cast the ancestor object reference
	RootSub  rootSubRef  = (RootSub)rootRef;  // refers to desc
	RootDesc rootDescRef = (RootDesc)rootRef; // refers to desc too

	// Note how these two use the print() method in the subclass
	rootSubRef.print();  // 4
	rootDescRef.print(); // 5

	// Now let's create a RootSub object
	rootSubRef = new RootSub();

	// and try to assign the ancestor OR type to it
	rootRef = rootSubRef;

	rootRef.print();   // 6

	// OK, that worked fine. But what if we try to use the
	// extensions in RootSub? This line bombs on compile!
	// rootRef.printExt();  

	// but this one won't because of the cast!
	((RootSub)rootRef).printExt(); // 7

	// but what if you cast downward to the wrong type?
	rootRef = new RootSubSibling();
	rootRef.print();  // 8

	// this bombs at runtime! downward cast to the wrong type
	//((RootSub)rootRef).printExt();

	// to safeguard, put in an instanceof check
	if (rootRef instanceof RootSub)	 {
		rootRef = new Root();
	    ((RootSub)rootRef).printExt();  // will not execute
	}
	else {
		System.out.println("rootRef is not a RootSub");
	}

	rootRef = new RootSub();
	if (rootRef instanceof RootSub)
	    ((RootSub)rootRef).printExt();  // 9 will execute

	rootRef = new RootDesc();
	if (rootRef instanceof RootSub)
	    {
		// will also execute, since RootDesc is-a RootSub
		((RootSub)rootRef).printExt();  // 10
		// note how the cast does nothing here, still binds to RootDesc
		((RootSub)rootRef).print();     // 11
	    }
    }
}


