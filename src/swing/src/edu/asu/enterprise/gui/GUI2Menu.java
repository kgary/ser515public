package edu.asu.enterprise.gui;

import java.awt.*;
import javax.swing.*;

class GUI2Menu {
	public static void main (String args[]) {
		JFrame container = new JFrame();
		container.setSize(250,300);

		JMenuBar mb = new JMenuBar();
		JMenu  file = new JMenu("File");
		file.add("Open");
		file.add("Close");
		file.add("Exit");
		JMenu edit = new JMenu("Edit");
		mb.add(file);
		mb.add(edit);
		
		container.setJMenuBar(mb);

		Container pane = container.getContentPane();
		pane.setLayout(new FlowLayout());

		// Textfield
		pane.add(new JTextField("", 20));
		pane.add(new JTextField("Fill me in"));
		pane.add(new JTextField("Fill me in", 20));

		// Button
		JButton clickMe = new JButton("Click Me");
		pane.add(clickMe);

		// Combo Box
		JComboBox accountType = new JComboBox ();
		accountType.addItem("Checking");
		accountType.addItem("MoneyMarket");
		accountType.addItem("Savings");
		pane.add(accountType);

		ButtonGroup	group = new ButtonGroup();
		JCheckBox	b1 = new JCheckBox("Checking", false);
		JCheckBox	b2 = new JCheckBox("MoneyMarket", false);
		JRadioButton	b3 = new JRadioButton("Savings", true);

		pane.add(b1);	group.add(b1);
		pane.add(b2);	group.add(b2);
		pane.add(b3);	group.add(b3);

		pane.add(new JCheckBox("Interest Bearing", true));
		pane.add(new JRadioButton("Overdraft available", true));

		container.setVisible(true);
	}
}
