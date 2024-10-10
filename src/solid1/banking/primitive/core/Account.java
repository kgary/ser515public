package banking.primitive.core;

import banking.primitive.*;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public abstract class Account implements Asset
{
	protected float balance =0.0F;
	protected String name;

	public Account(String n)
	{
		name = n;
	}

	public Account(String n, float b)
	{
		name = n;
		balance = b;
	}

	public void display()
	{
	    //JOptionPane.showMessageDialog(null, "Account " + name + " has $" + balance);
	    String s = (String)JOptionPane.showInputDialog(null,
							   "Account " + name + " has $" + balance,
							   name,
							   JOptionPane.PLAIN_MESSAGE,
							   null,
							   null,
							   "withdraw 50");
	    try {
		if (s == null) return;
		
		String[] inputs = s.trim().split(" ");

		if (inputs.length == 1 && inputs[0].isEmpty())
		    return;
		else if (inputs.length % 2 == 1)
		    JOptionPane.showMessageDialog(null, "Invalid number of inputs");
		else {  // format is "op1 val1 op2 val2 ..."
		    for (int i = 0; i < inputs.length; i +=2) {
			Float sf = Float.parseFloat(inputs[i+1]);
			if (inputs[i].equalsIgnoreCase("withdraw"))
			    withdraw(sf);
			else if (inputs[i].equalsIgnoreCase("deposit"))
			    deposit(new DepositParameter(sf));
			else
			    JOptionPane.showMessageDialog(null, "Unable to process operation " + inputs[i]);
		    }
		}
	    } catch (Exception exc) {
		JOptionPane.showMessageDialog(null, "Unable to process value " + s);
	    }
	}

	public String getName()
	{
		return name;
	}

	public float getBalance()
	{
		return balance;
	}
	
	public abstract void deposit(DepositParameter parameterObject);
	public abstract void withdraw(float amount);

    public String toString() {
    	return "Account " + name + " has $" + balance +"\n";
    }
}
