package statechart;

import java.util.Properties;

public final class LampDriver {
    public static void main(String[] args) {

	// Need a -D on invocation line
	String lampClass = System.getProperty("lamp");
	if (lampClass == null || args.length < 1) {
	    System.out.println("USAGE: java LampDriver -Dlamp=<class> <eventcount>");
	    System.exit(0);
	}
	LampInterface l = null;
	Class c = null;
	try {
	    c = Class.forName(lampClass);
	    l = (LampInterface)c.newInstance();
	} catch (Throwable t) {
	    System.out.println("Unable to load class " + lampClass);
	    System.exit(0);
	}

        int clickCount = 0;

        try {
            clickCount = Integer.parseInt(args[0]);
        }
        catch (ArrayIndexOutOfBoundsException arrayExc) {
            arrayExc.printStackTrace();
            System.out.println("Captured an array index OB exception");
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Captured some other exception: " +
                               e.getClass().getName() + " " + e.getMessage());
        }

        for (int i = 0; i < clickCount; i++) {
            System.out.print("Click number " + i + ": ");

            try {
		l.click(LampInterface.ClickEvent.RIGHT);
              if (l.isLampHigh()) {
                    System.out.println(" The Lamp is on HIGH");
                }
               else if (l.isLampLow()) {
                    System.out.println(" The Lamp is on LOW");
                }
                else if (l.isLampOff()) {
                    System.out.println(" The Lamp is OFF");
                }
            }
            catch (LampException le) {
                System.out.println(" Caught LampException: " + le.getMessage());
            }
            catch (Exception exc) {
                System.out.println(" Caught Exception: " + exc.getMessage());
                Throwable t = exc.getCause();
                if (t != null) {
                    System.out.println(" \tCaused by " + t.getMessage());
                }
            }
        }
    }
}
