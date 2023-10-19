package edu.asu.enterprise.gui;

import java.awt.*;
import javax.swing.*;

class GUI2GridBag {
	public static void main (String args[]) {
		JFrame container = new JFrame();
		container.setSize(300,200);



		Container pane = container.getContentPane();
		pane.setLayout(new GridBagLayout());

		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		// adds in the upper left corner
		pane.add(new JButton("Click Me"), c);
		c.gridx = 1;
		c.gridy = 0;
		c.gridwidth = 2;
		// adds to next 2 columns in first row
		pane.add(new JTextField("Fill me in...", 15), c);

		// add 2 to the last row
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 1; // put back to "normal" after setting to 2 above
		c.fill = GridBagConstraints.BOTH; // fill entire display area
		c.insets = new Insets(10,10,20,20); // external padding
		pane.add(new JButton("OK"), c);
		c.gridx = 2;
		c.gridy = 2;
		pane.add(new JButton("not OK"), c);

		container.setVisible(true);
	}
}
