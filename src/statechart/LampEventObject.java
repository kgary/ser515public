package statechart;

public class LampEventObject {
    private LightBulb __lightBulb;

    // Composition relationship
    public LampEventObject() {
        __lightBulb = new LightBulb();
    }

    public void eventHandler(LampEvent le) {
        try {
	    if (le instanceof LowerLampEvent)  __lightBulb.increaseWatts();
	    if (le instanceof HigherLampEvent)  __lightBulb.decreaseWatts();
            System.out.println("The light bulb is now at wattage: " + __lightBulb.getWatts());
        }
        catch (LampException exc) {
	    System.out.println("The Lamp just burned out, changing the Light Bulb");
        }
    }
    // Which is the best way to deal with the exception?
    public boolean isLampOff() throws LampException {
	try {
	    return __lightBulb.getLumens() == 0.0F;
	} catch (LampException le) {
	    System.out.println("Trying to ask a burned out light bulb if it is OFF");
	    throw new LampException(le);
	}
    }
    public boolean isLampLow() throws LampException {
	return __lightBulb.getLumens() == 1.0F;
    }
    public boolean isLampHigh() {
	try {
	    return __lightBulb.getLumens() > 1.0F;
	} catch (LampException le) {
	    System.out.println("Trying to ask a burned out light bulb if it is HIGH");
	    return false;
	}
    }

    public static void main(String[] args) {
        LampEventObject l = new LampEventObject();

        int eventCount = 0;

        try {
            eventCount = Integer.parseInt(args[0]);
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
	
	LampEvent le = null;
        for (int i = 0; i < eventCount; i++) {
	    le = LampEventFactory.getNextEvent();
	    System.out.print("Event number " + i + ": is a " + le);
	    
	    l.eventHandler(le);

            try {
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
            catch (LampException lex) {
                System.out.println(" Caught LampException: " + lex.getMessage());
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
