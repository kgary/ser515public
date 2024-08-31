class Transaction extends Thread {
    Account account;
    int id;

    public Transaction(int id, Account account) {
        super("Transaction #" + id);
        this.account = account;
        this.id = id;
    }

    public void run() {
        System.out.println("Transaction started #" + id);
        for (int i = 0; i < 3; i++) {
            account.deposit(id*i);
        }
    }

    public static void main(String args[]) throws InterruptedException {
        Account account = new Account();

        for (int i=1; i <= 3; i++) {
            Transaction trans = new Transaction(i, account);
            trans.start();
        }
        Thread.sleep(8000);
        System.out.println("Balance is " + account.getBalance());
    }
}

class Account {
    int     numTransactions = 0;
    int     balance = 0;

    public synchronized void deposit(int amount) {
        balance += amount;
        numTransactions++;
    }

    public synchronized int getBalance() {
        return balance;
    }
}
