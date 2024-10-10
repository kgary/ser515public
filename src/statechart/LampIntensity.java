package statechart;

public class LampIntensity implements LampInterface {
    private Intensity __intensity;

    public LampIntensity() {
	    __intensity = Intensity.OFF;
    }

    public void click(ClickEvent ce) throws LampException {
	    if (Math.random() > 0.9) {
	        __intensity = Intensity.BURNOUT;
	        throw new LampException("Lamp burned out");  // why is it useful to throw an exception here?
	    }

	    if (__intensity == Intensity.BURNOUT) return;  // immutable

	    if (__intensity == Intensity.OFF) __intensity = Intensity.LOW;
	    else if (__intensity == Intensity.LOW) __intensity = Intensity.HIGH;
	    else if (__intensity == Intensity.HIGH) __intensity = Intensity.OFF;  // must be HIGH
    }
    public boolean isLampOff() throws LampException {
        return __intensity == Intensity.OFF;
    }
    public boolean isLampLow() throws LampException {
	    return __intensity == Intensity.LOW;
    }
    public boolean isLampHigh() throws LampException {
	    return __intensity == Intensity.HIGH;
    }
}
