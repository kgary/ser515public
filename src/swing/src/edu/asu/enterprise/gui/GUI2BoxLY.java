package edu.asu.enterprise.gui;

import java.awt.*;
import javax.swing.*;

class GUI2BoxLY {
	public static void main (String args[]) {
		JFrame container = new JFrame();
		container.setSize(300,200);

		Container pane = container.getContentPane();
		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
		pane.add(new JButton("Click Me"));
		pane.add(new JTextField("Fill me in...", 15));

		container.setVisible(true);
	}
}
