package edu.asu.enterprise.gui;

import java.awt.*;
import javax.swing.*;

class GUI2Null {
	public static void main (String args[]) {
		JFrame container = new JFrame();
		container.setSize(300,200);

		Container pane = container.getContentPane();
		pane.setLayout(null);

		JButton clickMe = new JButton("Click Me");
		pane.add(clickMe);

		JTextField fillMe = new JTextField("Fill me in...", 15);
		pane.add(fillMe);

		// set position and size
		clickMe.setBounds(10, 10, 90, 20);
		fillMe.setBounds(40, 70, 190, 50);

		container.setVisible(true);
	}
}
