package banking.server;


public class AccountServerFactory {

	public AccountServerFactory() {
	}

	public AccountServer getAccountServer() {
		return new ServerSolution();
	}
}
