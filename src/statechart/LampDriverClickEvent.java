// for versions which need an actual CE
public final class LampDriverClickEvent {
    private LampDriverClickEvent() {}

      public static void main(String[] args) {
        LampInterface l = new LampIntensityClickEvent();

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

	LampInterface.ClickEvent ce = null;
	try {
	    for (int i = 0; i < clickCount; i++) {
		if (Math.random() > 0.5) ce = LampInterface.ClickEvent.LEFT;
		else ce = LampInterface.ClickEvent.RIGHT;
		
		System.out.print("Click number " + i + ": is a " + ((ce == LampInterface.ClickEvent.LEFT) ? "left click - " : "right click - "));
		
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
