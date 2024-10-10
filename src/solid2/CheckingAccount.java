package ser515.smells;

class CheckingAccount extends Account {
    private float balance = 0.0f;
    private int numTransactions = 0;

    CheckingAccount(float amt) {
	super(amt, 2, 900.0f, 1.05f);
    }
    public void withdraw (float amount) {
	super.withdraw(amount);
	numTransactions++;
    }
    public void computeInterest() {
	super.computeInterest();
	numTransactions++;
    }
    public void computePenalties() {
	if (numTransactions > 2) 
	    balance = balance - 10.0f; // 10 charge
    }
    public String toString() {
	return super.toString() + numTransactions + " transactions";
    }
}
