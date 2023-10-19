
class LightBulb2_4Exception extends Exception {
    public LightBulb2_4Exception(String msg) {
    super(msg);
    }
}

class LightBulb2_4 {
    private static final int __WATTS_INCREMENT = 20;
    private static final int __WATTS_MAX = 60;

    private int __watts;
    private boolean __burnedOut;

    LightBulb2_4() {
        __watts = 0;
        __burnedOut = false;
    }
    private void burnOut() {
        __burnedOut = true;
        System.out.println("You just burned out the bulb!");
    }
    public void increaseWatts() {
        __watts = (__watts + __WATTS_INCREMENT) % __WATTS_MAX;
        // simulate burn out behavior, one every 10 clicks
        if (Math.random() > 0.9) {
            burnOut();
        }
    }
    // Note the lack of encapsulated safety in this method. We are relying on the caller to know
    // not to cal this i the case where the wattage could go negative - I no longer own my own fate.
    public void decreaseWatts() {  
	__watts = (__watts - __WATTS_INCREMENT) % __WATTS_MAX;
	// simulate burn out behavior, one every 10 clicks
	if (Math.random() > 0.9) {
	    burnOut();
	}
    }
    public int getWatts() throws LightBulb2_4Exception {
        if (__burnedOut) {
            throw new LightBulb2_4Exception("Burned Out in getWatts()");
        }
        return __watts;
    }
    // a lumen for an incandescent bulb is estimated at
    // 20 lumens/watt
    public float getLumens() throws LightBulb2_4Exception {
	if (__burnedOut) {  // you cannot query a burned out bulb
            throw new LightBulb2_4Exception("Burned Out in getLumens()");
        }
        return getWatts() / 20.0F;
    }
}

public class LampSM2_4 {
    enum ClickEvent { LEFT, RIGHT }
    private LightBulb2_4 __lightBulb;

    // Composition relationship
    public LampSM2_4() {
        __lightBulb = new LightBulb2_4();
    }

    public void click(ClickEvent ce) {
        try {
	    if (ce == ClickEvent.RIGHT) __lightBulb.increaseWatts();
	    if (ce == ClickEvent.LEFTT) __lightBulb.decreaseWatts();
            System.out.println("The light bulb is now at wattage: " + __lightBulb.getWatts());
        }
        catch (LightBulb2_4Exception exc) {
	    System.out.println("The Lamp just burned out, changing the Light Bulb");
            exc.printStackTrace();
        }
    }
    // Which is the best way to deal with the exception?
    public boolean isLampOff() throws Exception {
	try {
	    return __lightBulb.getLumens() == 0.0F;
	} catch (LightBulb2_4Exception le) {
	    System.out.println("Trying to ask a burned out light bulb if it is OFF");
	    throw new Exception(le);
	}
    }
    public boolean isLampLow() throws LightBulb2_4Exception {
	return __lightBulb.getLumens() == 1.0F;
    }
    public boolean isLampHigh() {
	try {
	    return __lightBulb.getLumens() > 1.0F;
	} catch (LightBulb2_4Exception le) {
	    System.out.println("Trying to ask a burned out light bulb if it is HIGH");
	    return false;
	}
    }

    public static void main(String[] args) {
        LampSM2_4 l = new LampSM2_4();

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
	
	ClickEvent ce = null;
        for (int i = 0; i < clickCount; i++) {
	    // same as LampSM1_3
	    if (Math.random() > 0.5) ce = ClickEvent.LEFT;
	    else ce = ClickEvent.RIGHT;
	    
	    System.out.print("Click number " + i + ": is a " + ((ce == ClickEvent.LEFT) ? "left click - " : "right click - "));
	    
	    l.click(ce);

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
            catch (LightBulb2_4Exception le) {
                System.out.println(" Caught LightBulb2_4Exception: " + le.getMessage());
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
