class LightBulb2_4_5Exception extends Exception {
    public LightBulb2_4_5Exception(String msg) {
    super(msg);
    }
}
// Let's also use polymorphism via tagging types to get rid of
// almost all of our conditionals on click events
interface LampEvent {}
interface LowerLampEvent extends LampEvent {}
interface HigherLampEvent extends LampEvent {}

class LeftClickEvent implements LowerLampEvent {
    LeftClickEvent() { super(); }
    public String toString() { return "Knob Left-Turn-Click Event. "; }
}
class RightClickEvent implements HigherLampEvent {
    RightClickEvent() { super(); }
    public String toString() { return "Knob Right-Turn-Click Event. "; }
}
class AlexaLowerEvent implements LowerLampEvent {
    AlexaLowerEvent() { super(); }
    public String toString() { return "Alexa Lower Event. "; }
}
class AlexaHigherEvent implements HigherLampEvent {
    AlexaHigherEvent() { super(); }
    public String toString() { return "Alexa Higher Event. "; }
}

// this class knows about the concrete types. We could abstract this out too!
class LampEventFactory {
    static LampEvent getNextEvent() {
	double r = Math.random();
	if (r > 0.75) return new LeftClickEvent();
	if (r > 0.5) return new RightClickEvent();
	if (r > 0.25) return new AlexaLowerEvent();
	return new AlexaHigherEvent();
    }
}

class LightBulb2_4_5 {
    private static final int __WATTS_INCREMENT = 20;
    private static final int __WATTS_MAX = 60;

    private int __watts;
    private boolean __burnedOut;

    LightBulb2_4_5() {
        __watts = 0;
        __burnedOut = false;
    }
    private void burnOut() {
        __burnedOut = true;
        System.out.println("You just burned out the bulb!");
    }
    // Note how tenous our code is based on the watts increment and max values.
    // we had to change this implementation as it is state-aware implicitly through the mod operator
    public void increaseWatts() {
	if (__watts < __WATTS_MAX)  __watts = (__watts + __WATTS_INCREMENT);
        // simulate burn out behavior, one every 10 clicks
        if (Math.random() > 0.9) {
            burnOut();
        }
    }
    // new behavior
    public void decreaseWatts() {
	if (__watts > 0.0F) 
	    __watts = (__watts - __WATTS_INCREMENT);
	// simulate burn out behavior, one every 10 clicks
	if (Math.random() > 0.9) {
	    burnOut();
	}
    }
    public int getWatts() throws LightBulb2_4_5Exception {
        if (__burnedOut) {
            throw new LightBulb2_4_5Exception("Burned Out in getWatts()");
        }
        return __watts;
    }
    // a lumen for an incandescent bulb is estimated at
    // 20 lumens/watt
    public float getLumens() throws LightBulb2_4_5Exception {
	if (__burnedOut) {  // you cannot query a burned out bulb
            throw new LightBulb2_4_5Exception("Burned Out in getLumens()");
        }
        return getWatts() / 20.0F;
    }
}

public class LampSM2_4_5 {
    private LightBulb2_4_5 __lightBulb;

    // Composition relationship
    public LampSM2_4_5() {
        __lightBulb = new LightBulb2_4_5();
    }

    public void eventHandler(LampEvent le) {
        try {
	    if (le instanceof LowerLampEvent)  __lightBulb.increaseWatts();
	    if (le instanceof HigherLampEvent)  __lightBulb.decreaseWatts();
            System.out.println("The light bulb is now at wattage: " + __lightBulb.getWatts());
        }
        catch (LightBulb2_4_5Exception exc) {
	    System.out.println("The Lamp just burned out, changing the Light Bulb");
        }
    }
    // Which is the best way to deal with the exception?
    public boolean isLampOff() throws Exception {
	try {
	    return __lightBulb.getLumens() == 0.0F;
	} catch (LightBulb2_4_5Exception le) {
	    System.out.println("Trying to ask a burned out light bulb if it is OFF");
	    throw new Exception(le);
	}
    }
    public boolean isLampLow() throws LightBulb2_4_5Exception {
	return __lightBulb.getLumens() == 1.0F;
    }
    public boolean isLampHigh() {
	try {
	    return __lightBulb.getLumens() > 1.0F;
	} catch (LightBulb2_4_5Exception le) {
	    System.out.println("Trying to ask a burned out light bulb if it is HIGH");
	    return false;
	}
    }

    public static void main(String[] args) {
        LampSM2_4_5 l = new LampSM2_4_5();

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
            catch (LightBulb2_4_5Exception lex) {
                System.out.println(" Caught LightBulb2_4_5Exception: " + lex.getMessage());
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
