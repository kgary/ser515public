package ser515.smells;

class SavingsAccount extends Account {
    private float initialBalance = 0.0f;

    SavingsAccount(float amt) {
	super(amt, 2, 800.0f, 1.25f);
	initialBalance = amt;
    }
    public void computeReward() {
	if (balance > initialBalance) balance += 25.0f;
    }
}
