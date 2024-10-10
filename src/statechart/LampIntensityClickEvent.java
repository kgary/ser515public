package statechart;

public class LampIntensityClickEvent implements LampInterface {
    private Intensity __intensity;

    public LampIntensityClickEvent() {
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
