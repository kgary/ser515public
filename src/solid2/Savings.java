package ser515.smells;

class Savings {
    private float balance = 0.0f;
    private float initialBalance = 0.0f;
    
    Savings(float amt) {
	balance = amt;
	initialBalance = amt;
    }
    public void withdraw (float amount) {
	balance = balance-amount-2; // $2 charge
    }
    public void computeInterest() {
	if (balance > 500.0f)
	    balance = balance * 1.05F;
    }
    public void computeReward() {
	if (balance > initialBalance) balance += 25.0f;
    }
    public String toString() {
	return "Savings account with balance " + balance;
    }
}
