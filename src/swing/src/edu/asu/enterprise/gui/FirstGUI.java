package edu.asu.enterprise.gui;

import java.awt.*;      // for FlowLayout
import javax.swing.*;   // Swing components

class FirstGUI
{
	public static void main(String args[])
	{
		JFrame	window = new JFrame();

		window.setTitle("First Frame");
		window.setSize(200, 100);
		window.setLocation(100,100);
		window.setResizable(false);

		Container pane = window.getContentPane();
		pane.setLayout(new FlowLayout());
		JButton press = new JButton("Press Me");
		pane.add(press);

		window.setVisible(true);
	}
}
