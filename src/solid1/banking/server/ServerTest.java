package banking.server;

import java.util.*;

import banking.primitive.core.Account;
import banking.primitive.core.Savings;

class ServerTest {
	public static void main(String args[]) {

		AccountServer server = new AccountServerFactory().getAccountServer();
		
		List<Account> initialTest = server.getAllAccounts();
		if (initialTest.size() > 0) {
			System.out.println("Server not empty");
			System.out.println(initialTest);
			System.exit(0);
		}

		server.newAccount("Savings",	"Bob", 	100F);
		server.newAccount("Savings",	"Sue", 	200F);
		server.newAccount("Checking",	"Al", 	0F);

		System.out.println("All accounts: " + server.getAllAccounts());

		Account acc = server.getAccount("Bob");
		System.out.println("Bob:" + acc);
		acc.withdraw(200);
		server.update(acc);
		System.out.println("All accounts: " + server.getAllAccounts());
		System.out.println("Overdrawn accounts: " + server.getOverdrawnAccounts());
		
		System.out.println("NOONE: " + server.getAccount("NOONE"));

		try {
			server.newAccount("FooBar", "Bob", 0F);
			System.out.println("***Bad type failed");
		} catch (IllegalArgumentException e) {
			System.out.println("Passed bad type:" + e.getMessage());
		} catch (Exception e) {
			System.out.println("***Bad type failed with wrong exception:" + e);
		}

		try {
			server.update (new Savings("Joe"));
			System.out.println("***Update nonexistant failed");
		} catch (IllegalStateException e) {
			System.out.println("Passed update nonexistant:" + e.getMessage());
		} catch (Exception e) {
			System.out.println("***Update existing failed with wrong exception:" + e);
		}

		server.shutdown();
	}
}
