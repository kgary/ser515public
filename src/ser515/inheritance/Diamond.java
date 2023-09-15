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

public class Diamond implements Spades, Hearts, Clubs {
    public static void main(String[] args) {
	Diamond d = new Diamond();
	System.out.println("Add is " + d.add(10));
    }
}
