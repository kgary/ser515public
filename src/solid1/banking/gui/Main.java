package banking.gui;

import javax.swing.JFrame;

/**
 * main method for running the program.
 * @author kevinagary
 *
 */
final class Main {
	private Main() {
	}

	public static void main(final String[] args) throws Exception {

		if (args.length != 1) {
			System.out.println("Usage: java banking.gui.Main <property file>");
			System.exit(1);
		}

		String propertyFile = args[0];
		JFrame frame = new MainFrame(propertyFile);
		frame.setVisible(true);

	}
}
