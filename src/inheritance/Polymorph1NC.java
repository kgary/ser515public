package ser515.inheritance;

public class Polymorph1NC {
    private static int _count = 0;

    public static int getCount()
    { return ++_count; }

    public static void main(String[] args) {
	Root rootRef = new Root();
	rootRef.print();  // 1

	rootRef = new RootSub();
	rootRef.print();  // 2

	rootRef = new RootDesc();
	rootRef.print();  // 3

	RootSub  rootSubRef  = (RootSub)rootRef;  // refers to desc
	RootDesc rootDescRef = (RootDesc)rootRef; // refers to desc too
	rootSubRef.print();  // 4
	rootDescRef.print(); // 5

	rootSubRef = new RootSub();
	rootRef = rootSubRef;
	rootRef.print();   // 6

	((RootSub)rootRef).printExt(); // 7

	rootRef = new RootSubSibling();
	rootRef.print();  // 8

	if (rootRef instanceof RootSub)	 {  // 9
	    rootRef = new Root();
	    ((RootSub)rootRef).printExt();
	}
	else System.out.println(Polymorph1NC.getCount() + ":\trootRef is not a RootSub");

	rootRef = new RootSub();
	if (rootRef instanceof RootSub)
	    ((RootSub)rootRef).printExt();  // 10

	rootRef = new RootDesc();
	if (rootRef instanceof RootSub) {
		((RootSub)rootRef).printExt();  // 11
		((RootSub)rootRef).print();     // 12
	    }
    }
}


