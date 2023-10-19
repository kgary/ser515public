
class LightBulbException extends Exception {
    public LightBulbException(String msg) {
    super(msg);
    }
}

class LightBulb {
    private static final int __WATTS_INCREMENT = 20;
    private static final int __WATTS_MAX = 60;

    private int __watts;
    private boolean __burnedOut;

    LightBulb() {
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
    public int getWatts() throws LightBulbException {
        if (__burnedOut) {
            throw new LightBulbException("Burned Out in getWatts()");
        }
        return __watts;
    }
    // a lumen for an incandescent bulb is estimated at
    // 20 lumens/watt
    public float getLumens() throws LightBulbException {
	if (__burnedOut) {  // you cannot query a burned out bulb
            throw new LightBulbException("Burned Out in getLumens()");
        }
        return getWatts() / 20.0F;
    }
}

public class LampSM2 {
    private LightBulb __lightBulb;

    // Composition relationship
    public LampSM2() {
        __lightBulb = new LightBulb();
    }

    public void click() {
        try {
            __lightBulb.increaseWatts();
            System.out.println("The light bulb is now at wattage: " + __lightBulb.getWatts());
        }
        catch (LightBulbException exc) {
	    System.out.println("The Lamp just burned out, changing the Light Bulb");
            exc.printStackTrace();
        }
    }
    // Which is the best way to deal with the exception?
    public boolean isLampOff() throws Exception {
	try {
	    return __lightBulb.getLumens() == 0.0F;
	} catch (LightBulbException le) {
	    System.out.println("Trying to ask a burned out light bulb if it is OFF");
	    throw new Exception(le);
	}
    }
    public boolean isLampLow() throws LightBulbException {
	return __lightBulb.getLumens() == 1.0F;
    }
    public boolean isLampHigh() {
	try {
	    return __lightBulb.getLumens() > 1.0F;
	} catch (LightBulbException le) {
	    System.out.println("Trying to ask a burned out light bulb if it is HIGH");
	    return false;
	}
    }

    public static void main(String[] args) {
        LampSM2 l = new LampSM2();

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
            l.click();

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
            catch (LightBulbException le) {
                System.out.println(" Caught LightBulbException: " + le.getMessage());
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
