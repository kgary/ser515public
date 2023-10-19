package edu.asu.enterprise.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI2MenuEvent extends JFrame
    implements ActionListener, ItemListener, WindowListener, 
	       FocusListener, MouseListener, KeyListener
{
    public GUI2MenuEvent()
    {
	JMenuBar mb = new JMenuBar();
	JMenu  file = new JMenu("File");
	JMenuItem miOpen  = new JMenuItem("Open");
	JMenuItem miClose = new JMenuItem("Close");
	JMenuItem miExit  = new JMenuItem("Exit");
	file.add(miOpen);
	file.add(miClose);
	file.add(miExit);
	JMenu edit = new JMenu("Edit");
	mb.add(file);
	mb.add(edit);
	miOpen.addActionListener(this);
	miClose.addActionListener(this);
	miExit.addActionListener(this);
	
	setJMenuBar(mb);
	
	Container pane = getContentPane();
	pane.setLayout(new FlowLayout());
	
	// Textfield
	JTextField jtf1 = new JTextField("", 20);
	JTextField jtf2 = new JTextField("Fill me in");
	JTextField jtf3 = new JTextField("Fill me in", 20);
	pane.add(jtf1);
	pane.add(jtf2);
	pane.add(jtf3);
	jtf1.addKeyListener(this);
	jtf2.addKeyListener(this);
	jtf3.addKeyListener(this);

	// Button
	JButton clickMe = new JButton("Click Me");
	pane.add(clickMe);
	clickMe.addMouseListener(this);
	
	// Combo Box
	JComboBox accountType = new JComboBox ();
	accountType.addItem("Checking");
	accountType.addItem("MoneyMarket");
	accountType.addItem("Savings");
	pane.add(accountType);
	accountType.addItemListener(this);
	
	ButtonGroup	group = new ButtonGroup();
	JCheckBox	b1 = new JCheckBox("Checking", false);
	JCheckBox	b2 = new JCheckBox("MoneyMarket", false);
	JRadioButton	b3 = new JRadioButton("Savings", true);

	pane.add(b1);	group.add(b1);
	pane.add(b2);	group.add(b2);
	pane.add(b3);	group.add(b3);
	b1.addActionListener(this);
	b2.addActionListener(this);
	b3.addActionListener(this);
	
	pane.add(new JCheckBox("Interest Bearing", true));
	pane.add(new JRadioButton("Overdraft available", true));
	
	pane.addFocusListener(this);
	this.addWindowListener(this);
    }

    // ActionListener
    public void actionPerformed(ActionEvent ae)
    {
	System.out.println("Command: " + ae.getActionCommand());
    }

    // ItemListener
    public void itemStateChanged(ItemEvent ie)
    {
	System.out.println("Item Changed to: " + ie.getStateChange());
    }

    // WindowListener
    public void windowClosing(WindowEvent we)
    { System.out.println("Window Closing"); }
    public void windowOpened(WindowEvent we)
    { System.out.println("Window Opened"); }
    public void windowIconified(WindowEvent we)
    { System.out.println("Window Iconified"); }
    public void windowDeiconified(WindowEvent we)
    { System.out.println("Window Deiconified"); }
    public void windowClosed(WindowEvent we)
    { System.out.println("Window Closed"); }
    public void windowActivated(WindowEvent we)
    { System.out.println("Window Activated"); }
    public void windowDeactivated(WindowEvent we)
    { System.out.println("Window Deactivated"); }

    // FocusListener
    public void focusGained(FocusEvent fe)
    { System.out.println("Focus gained"); }
    public void focusLost(FocusEvent fe)
    { System.out.println("Focus lost"); }

    // MouseListener
    public void mousePressed(MouseEvent me)
    { System.out.println("Mouse press at " + me.getX() + ", " + me.getY()); } 
    public void mouseReleased(MouseEvent me)
    { System.out.println("Mouse released at " + me.getX() + ", " + me.getY()); } 
    public void mouseEntered(MouseEvent me)
    { System.out.println("Mouse entered at " + me.getX() + ", " + me.getY()); } 
    public void mouseExited(MouseEvent me)
    { System.out.println("Mouse exited at " + me.getX() + ", " + me.getY()); } 
    public void mouseClicked(MouseEvent me)
    { 
	System.out.println("Mouse clicked at " + me.getX() + ", " + me.getY()); 
	System.out.println("\tclick count: " + me.getClickCount());
    } 

    // KeyListener
    public void keyTyped(KeyEvent ke)
    { }
    public void keyReleased(KeyEvent ke)
    { System.out.println("Released " + ke.getKeyChar()); }
    public void keyPressed(KeyEvent ke)
    { System.out.println("Pressed " + ke.getKeyChar()); }


    public static void main (String args[]) {
	JFrame container = new GUI2MenuEvent();
	container.setSize(250,300);
	container.setVisible(true);
    }
}
