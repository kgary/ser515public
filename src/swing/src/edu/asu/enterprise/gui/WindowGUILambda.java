package edu.asu.enterprise.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class WindowGUILambda extends JFrame
{
    JTextField text;
    public WindowGUILambda()
    {
	Container pane = getContentPane();
	pane.setLayout(new FlowLayout());
	
	text = new JTextField("", 10);
	JButton submit = new JButton("Submit");
	pane.add(text);
	pane.add(submit);
	
	// lambda instead of anonymous inner class
	submit.addActionListener(ae -> System.out.println(text.getText() +"*"+ text.getSelectedText()));

	// create inner class object
	addWindowListener(new MyWindowAdapter());  
    }
    
    public static void main(String args[])
    {
	JFrame f = new WindowGUI();
	f.setSize(400,100);
	f.setVisible(true);
    }
    
    private class MyWindowAdapter extends WindowAdapter
    {	
	public void windowClosing (WindowEvent we)
	{ 
	    System.out.println("Your text was " + text.getText());
	    System.exit(0); 
	}
    }
}  // end of class WindowGUI
