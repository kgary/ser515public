package ser515.smells;

public class Smell2Better {
    public static void main(String[] args) {
	if (args.length < 1) {
	    System.out.println("USAGE: java ser515.smells.smell2 <amt>");
	    System.exit(0);
	}

	Account s = new SavingsAccount(Float.parseFloat(args[0]));
	Account c = new CheckingAccount(Float.parseFloat(args[0]));

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
	// still gotta cast
	((CheckingAccount)c).computePenalties();
	System.out.println("Checking after computing penalties: " + c);
	((SavingsAccount)s).computeReward();
	System.out.println("Savings after computing reward: " + s);
    }
}
