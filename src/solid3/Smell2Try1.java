package ser515.smells;

public class Smell2Try1 {
    public static void main(String[] args) {
	if (args.length < 1) {
	    System.out.println("USAGE: java ser515.smells.Smell2Try1 <amt>");
	    System.exit(0);
	}

	// Sure, this means you don't have to "know" the types of s and c
	Object s = new Savings(Float.parseFloat(args[0]));
	Object c = new Checking(Float.parseFloat(args[0]));

	// but do we really want to write code like this?
	if (s instanceof Savings)  ((Savings)s).withdraw(100.0f);
	if (c instanceof Checking) ((Checking)c).withdraw(100.0f);
	System.out.println("Checking, Savings, after $100 withdrawal: " + c + ", " + s);
	if (s instanceof Savings)  ((Savings)s).computeInterest();
	if (c instanceof Checking) ((Checking)c).computeInterest();
	System.out.println("Checking, Savings, after computing interest: " + c + ", " + s);
	if (s instanceof Savings)  ((Savings)s).withdraw(50.0f);
	if (c instanceof Checking) ((Checking)c).withdraw(50.0f);
	if (s instanceof Savings)  ((Savings)s).computeInterest();
	if (c instanceof Checking) ((Checking)c).computeInterest();
	if (s instanceof Savings)  ((Savings)s).withdraw(100.0f);
	if (c instanceof Checking) ((Checking)c).withdraw(100.0f);
	System.out.println("Checking, Savings, after 2nd $100 withdrawal: " + c + ", " + s);
	if (s instanceof Savings)  ((Savings)s).computeInterest();
	if (c instanceof Checking) ((Checking)c).computeInterest();
	System.out.println("Checking, Savings, after 2nd computing interest: " + c + ", " + s);
	if (c instanceof Checking) ((Checking)c).computePenalties();
	System.out.println("Checking after computing penalties: " + c);
    }
}
