class LampException extends Exception {
    LampException(String msg) {
	super(msg);
    }
}

public class LampSM1_3 {
    enum Intensity { OFF, LOW, HIGH, BURNOUT }
    enum ClickEvent { LEFT, RIGHT }
    
    private Intensity __intensity;

    public LampSM1_3() {
	__intensity = Intensity.OFF;
    }

    // Our conditonal logic is getting gnarly now
    public void click(ClickEvent ce) throws LampException {
	if (Math.random() > 0.9) {
	    if (ce == ClickEvent.LEFT  && __intensity != Intensity.OFF ||
		ce == ClickEvent.RIGHT && __intensity != Intensity.HIGH) {
		__intensity = Intensity.BURNOUT;
		throw new LampException("Lamp burned out");  // why is it useful to throw an exception here?
	    }
	}

	if (__intensity == Intensity.BURNOUT) return;  // immutable

	if (ce == ClickEvent.LEFT) {
	    if (__intensity == Intensity.LOW) __intensity = Intensity.OFF;
	    else if (__intensity == Intensity.HIGH) __intensity = Intensity.LOW;  // must be HIGH
	} else {  // must be right
	    if (__intensity == Intensity.LOW) __intensity = Intensity.HIGH;
	    else if (__intensity == Intensity.OFF) __intensity = Intensity.LOW;
	}
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
        LampSM1_3 l = new LampSM1_3();

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
	try {
	    for (int i = 0; i < clickCount; i++) {
		if (Math.random() > 0.5) ce = ClickEvent.LEFT;
		else ce = ClickEvent.RIGHT;
		
		System.out.print("Click number " + i + ": is a " + ((ce == ClickEvent.LEFT) ? "left click - " : "right click - "));
		
		l.click(ce);
		
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
