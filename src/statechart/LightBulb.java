public final class LightBulb {
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
    // Note the lack of encapsulated safety in this method. We are relying on the caller to know
    // not to cal this i the case where the wattage could go negative - I no longer own my own fate.
    public void decreaseWatts() {  
	__watts = (__watts - __WATTS_INCREMENT) % __WATTS_MAX;
	// simulate burn out behavior, one every 10 clicks
	if (Math.random() > 0.9) {
	    burnOut();
	}
    }
    public int getWatts() throws LampException {
        if (__burnedOut) {
            throw new LampException("Burned Out in getWatts()");
        }
        return __watts;
    }
    // a lumen for an incandescent bulb is estimated at
    // 20 lumens/watt
    public float getLumens() throws LampException {
	if (__burnedOut) {  // you cannot query a burned out bulb
            throw new LampException("Burned Out in getLumens()");
        }
        return getWatts() / 20.0F;
    }
}
