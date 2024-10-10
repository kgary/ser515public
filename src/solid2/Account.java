package ser515.smells;

class Account {
    protected float balance = 0.0f;
    private float wdPenalty = 0.0f;
    private float interestBalance = 0.0f;
    private float interestRate = 1.0f;
    
    protected Account(float amt, float wdp, float ib, float ir) {
	balance = amt; wdPenalty = wdp; interestBalance = ib; interestRate = ir;
    }
    public void withdraw (float amount) {
	balance = balance-amount-wdPenalty;
    }
    public void computeInterest() {
	if (balance > interestBalance) {
	    balance = balance * interestRate;
	}
    }
    public String toString() {
	return getClass().getSimpleName() + " account with balance " + balance;
    }
}
