public class LampTwoWayClick implements LampInterface {
    private LightBulb __lightBulb;

    // Composition relationship
    public LampTwoWayClick() {
        __lightBulb = new LightBulb();
    }

    public void click(ClickEvent ce) throws LampException {
	if (ce == ClickEvent.RIGHT) __lightBulb.increaseWatts();
	if (ce == ClickEvent.LEFT) __lightBulb.decreaseWatts();
	System.out.println("The light bulb is now at wattage: " + __lightBulb.getWatts());
    }
    // Which is the best way to deal with the exception?
    public boolean isLampOff() throws LampException {
	return __lightBulb.getLumens() == 0.0F;
    }
    public boolean isLampLow() throws LampException {
	return __lightBulb.getLumens() == 1.0F;
    }
    public boolean isLampHigh() throws LampException {
	return __lightBulb.getLumens() > 1.0F;
    }
}
