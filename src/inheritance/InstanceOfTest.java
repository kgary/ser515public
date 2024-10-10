package inheritance;

interface A {
  public int getX();
  public int getY();
}
abstract class AAbstractClass implements A {
    private int y;
    
    protected AAbstractClass(int y) {
        this.y = y;
    }    
    public abstract int getX();
    
    public int getY() {
        return y;
    }
}
class AClass extends AAbstractClass {
  private int x;

  AClass(int num1, int num2) { 
      super(num2);
      x = num1; 
  }
  public int getX()
  { return x; }
}
class BClass implements A {
    private int x;
    private int y;
    
    BClass(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() { return x; }
    public int getY() { return y; }
}
public class InstanceOfTest {
  public static void main(String[] args) {
    A var = new AClass(5, 10);
    System.out.println("X: " + var.getX() + ", Y: " + var.getY());
    if (var instanceof A) System.out.println("Yes, var is an instance of A");
    if (var instanceof AAbstractClass) System.out.println("Yes, var is an instance of AAbstractClass");
    if (var instanceof AClass) System.out.println("Yes, var is an instance of AClass");
    if (var instanceof BClass) System.out.println("Yes, var is an instance of BClass");

    var = new BClass(15, 100);
    System.out.println("X: " + var.getX() + ", Y: " + var.getY());
    if (var instanceof A) System.out.println("Yes, var is an instance of A");
    if (var instanceof AAbstractClass) System.out.println("Yes, var is an instance of AAbstractClass");
    if (var instanceof AClass) System.out.println("Yes, var is an instance of AClass");
    if (var instanceof BClass) System.out.println("Yes, var is an instance of BClass");
  }
}


