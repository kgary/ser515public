package banking.primitive.core;

import banking.primitive.*;

@SuppressWarnings("serial")
public class Savings extends Account implements InterestBearing {
	private int numWithdraws = 0;

	public Savings(String name) {
		super(name);
	}

	public Savings(String name, float balance) {
		super(name, balance);
	}

	public void display() {
		super.display();
	}

	public void deposit(DepositParameter parameterObject) {
		balance = balance + parameterObject.amount - 0.50F;
	}

	public void withdraw(float amount) {
		balance = balance - amount;
		numWithdraws++;
		if (numWithdraws > 3)
			balance = balance - 1;
	}

	public void accrueInterest() {
		balance = balance * 1.001F;
	}

	public String toString() {
	    return "Sav:" + getName() + ":" + getBalance() + "\n";
	}
}
