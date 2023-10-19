package edu.asu.enterprise.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class GUI2Card implements ItemListener {
    private JPanel cards = null;

    // from the Swing demo
    public void addComponentToPane(Container pane, String panel1, String panel2) {
        //Put the JComboBox in a JPanel to get a nicer look.
        JPanel comboBoxPane = new JPanel(); //use FlowLayout
        String comboBoxItems[] = { panel1, panel2 };
        JComboBox cb = new JComboBox(comboBoxItems);
        cb.setEditable(false);
        cb.addItemListener(this);
        comboBoxPane.add(cb);

        //Create the "cards".
        JPanel card1 = new JPanel();
        card1.add(new JButton("Button 1"));
        card1.add(new JButton("Button 2"));
        card1.add(new JButton("Button 3"));

        JPanel card2 = new JPanel();
        card2.add(new JTextField("TextField", 20));

        //Create the panel that contains the "cards".
        cards = new JPanel(new CardLayout());
        cards.add(card1, panel1);
        cards.add(card2, panel2);

        pane.add(comboBoxPane, BorderLayout.PAGE_START);
        pane.add(cards, BorderLayout.CENTER);
    }

    public void itemStateChanged(ItemEvent evt) {
        CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, (String)evt.getItem());
    }

    public static void main (String args[]) {
	JFrame container = new JFrame();

	GUI2Card thisCard = new GUI2Card();

	Container pane = container.getContentPane();

	if (args.length == 2)
	    thisCard.addComponentToPane(pane, args[0], args[1]);
	else
	    thisCard.addComponentToPane(pane, "panel1", "panel2");

	container.pack();
	container.setVisible(true);
    }
}
