package ser515.inheritance;

interface Clubs {
    default int add(int num) { return num+10; }
}
interface Spades {
    default int add(int num) { return num+20; }
}
interface Hearts {
    default int add(int num) { return num+30; }
}

class DiamondImpl implements Clubs, Spades, Hearts {
    public int add(int num) {
        return num+5;
    }
}
public class Diamond2 extends DiamondImpl {
    public static void main(String[] args) {
	    Diamond2 d = new Diamond2();
	    System.out.println("Add is " + d.add(10));
    }
}
