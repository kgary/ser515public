package ser515.unittest;

import java.util.Scanner;

public class SimpleSquareRootFunctionCLI {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        if (args.length != 1) {
            System.out.println("USAGE: java SimpleSquareRootFunction <X>, where X is the number of times to run");
            System.exit(0);
        }
        try {
            for (int i = 0; i < Integer.parseInt(args[0]); i++) {
                int x = in.nextInt();
                System.out.println("The value of the square root of the product is: " + makeSqrt(x));
            }
        } finally {
            in.close();
        }
    }

	public static double makeSqrt(int x) {
		return Math.sqrt((x - 1) * (x + 2));
	}

	public static int squareMe(int x) {
		return x * x;
	}
}
