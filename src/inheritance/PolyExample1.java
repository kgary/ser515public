package ser515.inheritance;

class Vehicle {
    public int getTax() {
	return 100;
    }

    public void reg() {
        System.out.println("My tax is " + getTax());
    }
}

class Car extends Vehicle {
    public int getTax() {
        return 250;
    }
}

class Motorcycle extends Vehicle {
    public int getTax() {
        return 500;
    }
}

public class PolyExample1 {
    public static void main(String[] args) {
        foo(new Car());
	foo(new Motorcycle());
        foo(new Vehicle());
    }

    static void foo(Vehicle v) {
       v.reg();
    }
}


