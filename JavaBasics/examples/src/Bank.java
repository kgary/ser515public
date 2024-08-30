import java.util.Vector;	

class Account{public void deposit(int i){}}
class Savings extends Account{public Savings(String name){} public void computeInterest(){}}
class Checking extends Account{public Checking(String name){}}

public class Bank
{
	public static void main(String args[])
	{
		Vector bank = new Vector(3);		// Create vector of 3
		
		bank.addElement(new Savings("Bob"));
		bank.addElement(new Checking("Bob"));	// Heterogeneous data!
		bank.addElement(new Savings("Bob"));
		bank.addElement(new Savings("Bob"));	// Overflow no problem!

		for (int i=0; i < bank.size(); i++)
		{
			Object temp = bank.elementAt(i);
			Account acc = (Account) temp;
			acc.deposit(100);
			if (acc instanceof Savings)
				((Savings) acc).computeInterest();
		}
	}
}
