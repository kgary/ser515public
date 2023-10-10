class LampException extends Exception {
    LampException(String msg) {
	super(msg);
    }
}

public class LampSM1 {
    enum Intensity { OFF, LOW, HIGH, BURNOUT }

    private Intensity __intensity;

    public LampSM1() {
	__intensity = Intensity.OFF;
    }

    public void click() throws LampException {
	if (Math.random() > 0.9) {
	    __intensity = Intensity.BURNOUT;
	    throw new LampException("Lamp burned out");  // why is it useful to throw an exception here?
	}

	if (__intensity == Intensity.BURNOUT) return;  // immutable

	if (__intensity == Intensity.OFF) __intensity = Intensity.LOW;
	else if (__intensity == Intensity.LOW) __intensity = Intensity.HIGH;
	else if (__intensity == Intensity.HIGH) __intensity = Intensity.OFF;  // must be HIGH
    }
    public boolean isLampOff() {
        return __intensity == Intensity.OFF;
    }
    public boolean isLampLow() {
	return __intensity == Intensity.LOW;
    }
    public boolean isLampHigh() {
	return __intensity == Intensity.HIGH;
    }

    public static void main(String[] args) {
        LampSM1 l = new LampSM1();

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

	try {
	    for (int i = 0; i < clickCount; i++) {
		System.out.print("Click number " + i + ": ");
		l.click();
		
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
        } catch (Exception exc) {
	    System.out.println(" Caught Exception: " + exc.getMessage());
	    Throwable t = exc.getCause();
	    if (t != null) {
		System.out.println(" \tCaused by " + t.getMessage());
	    }
	}
    }
}
