package edu.asu.enterprise.gui;

import java.awt.*;
import javax.swing.*;

class GUI2Dialog {
	public static void main (String args[]) {

	    int choice = JOptionPane.NO_OPTION;

	    while (choice == JOptionPane.NO_OPTION)
		{
		    choice = JOptionPane.showConfirmDialog(null, 
							   "Do you like this dialog? ",
							   "Dialog Title",
							   JOptionPane.YES_NO_OPTION);
		    if (choice == JOptionPane.YES_OPTION)
			System.out.println("Great, you like it!");
		    else if (choice == JOptionPane.NO_OPTION)
			System.out.println("Aw, you don't like it  :(");
		}

	}
}
