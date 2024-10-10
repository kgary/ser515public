package ser515.smells;

class Checking {
    private float balance = 0.0f;
    private int numTransactions = 0;

    Checking(float amt) {
	balance = amt;
    }
    public void withdraw (float amount) {
	balance = balance-amount-2.0f; // 2 charge
	numTransactions++;
    }
    public void computeInterest() {
	if (balance > 700.0f && numTransactions < 5) {
	    balance = balance * 1.1F;
	    numTransactions++;
	}
    }
    public void computePenalties() {
	if (numTransactions > 3) 
	    balance = balance - 10.0f; // 10 charge
    }
    public String toString() {
	return "Checking account with balance " + balance + " and " + numTransactions + " transactions";
    }
}
