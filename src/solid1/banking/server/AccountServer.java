package banking.server;

import java.util.List;
import banking.primitive.core.Account;

public interface AccountServer {

	/** Create a new account object in the server.  Type is either
		"Checking" or "Savings".  Throws IllegalArgumentException otherwise.
	*/
	public void		newAccount(String type, String name, float balance);

	/** Replace the already existing account.  Throws IllegalStateException
		if Account does not exist (this is a stretch, BTW).
	*/
	public void		update(Account account);

	/** Returns Account object or null if not found. */
	public Account	getAccount(String name);

	/** Returns a list of all Accounts inside the server */
	public List<Account>		getAllAccounts();

	/** Returns a list of Accounts whose balance is less than 0 */
	public List<Account>		getOverdrawnAccounts();

	/** Saves the state of the server and terminates the program */
	public void		shutdown();
}
