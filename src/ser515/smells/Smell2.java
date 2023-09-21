package ser515.smells;

public class Smell2 {
    public static void main(String[] args) {
	if (args.length < 1) {
	    System.out.println("USAGE: java ser515.smells.Smell2 <amt>");
	    System.exit(0);
	}

	Savings s = new Savings(Float.parseFloat(args[0]));
	Checking c = new Checking(Float.parseFloat(args[0]));

	s.withdraw(100.0f);
	c.withdraw(100.0f);
	System.out.println("Checking, Savings, after $10 withdrawal: " + c + ", " + s);
	s.computeInterest();
	c.computeInterest();
	System.out.println("Checking, Savings, after computing interest: " + c + ", " + s);
	s.withdraw(50.0f);
	c.withdraw(50.0f);
	s.computeInterest();
	c.computeInterest();
	s.withdraw(100.0f);
	c.withdraw(100.0f);
	System.out.println("Checking, Savings, after 2nd $100 withdrawal: " + c + ", " + s);
	s.computeInterest();
	c.computeInterest();
	System.out.println("Checking, Savings, after 2nd computing interest: " + c + ", " + s);
	c.computePenalties();
	System.out.println("Checking after computing penalties: " + c);
    }
}
