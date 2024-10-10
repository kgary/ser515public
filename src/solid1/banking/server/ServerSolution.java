package banking.server;

import java.util.*;
import java.io.*;

import banking.primitive.core.*;

class ServerSolution implements AccountServer {

	static String fileName = "accounts.ser";

	List<Account> accountList = new ArrayList<Account>();

	public ServerSolution() {
		File file = new File(fileName);
		ObjectInputStream in = null;
		try {
			if (file.exists()) {
				System.out.println("Reading from file " + fileName + "...");
				in = new ObjectInputStream(new FileInputStream(file));

				Integer sizeI = (Integer) in.readObject();
				int size = sizeI.intValue();
				for (int i=0; i < size; i++) {
					Account acc = (Account) in.readObject();
					accountList.add(acc);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException iexc) {
					iexc.printStackTrace();
				}
			}
		}
	}
	public void newAccount(String type, String name, float balance) {
		Account acc;
		if ("Checking".equals(type)) {
			acc = new Checking(name, balance);

		} else if ("Savings".equals(type)) {
			acc = new Savings(name, balance);

		} else {
			throw new IllegalArgumentException("Bad account type:" + type);
		}
		accountList.add(acc);
	}

	public void update(Account account) {
		int index = findIndex(account.getName());
		if (index < 0) {
			throw new IllegalStateException("Account not found:" + account);
		}

		accountList.remove(index);
		accountList.add(account);
	}

	public Account getAccount(String name) {
		int index = findIndex(name);
		if (index < 0)
			return null;

		return accountList.get(index);
	}

	public List<Account> getAllAccounts() {
		return accountList;
	}

	public List<Account> getOverdrawnAccounts() {
		List<Account> result = new ArrayList<Account>();

		for (int i=0; i < accountList.size(); i++) {
			Account acc = accountList.get(i);
			if (acc.getBalance() < 0) {
				result.add(acc);
			}
		}

		return result;
	}

	public void shutdown() {
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new FileOutputStream(fileName));

			out.writeObject(Integer.valueOf(accountList.size()));
			for (int i=0; i < accountList.size(); i++) {
				out.writeObject(accountList.get(i));
			}
		} catch (Exception e) {
			System.out.println("Could not write file:" + fileName);
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException oexc) {
					oexc.printStackTrace();
				}
			}
		}
	}

	protected int findIndex(String name) {

		for (int i=0; i < accountList.size(); i++) {
			Account acc = accountList.get(i);
			if (name.equals(acc.getName())) {
				return i;
			}
		}
		return -1;
	}
}
