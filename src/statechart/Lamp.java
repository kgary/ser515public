
public class Lamp implements LampInterface {
    private LightBulb __lightBulb;

    // Composition relationship
    public Lamp() {
        __lightBulb = new LightBulb();
    }

    public void click(ClickEvent ce) throws LampException {
        __lightBulb.increaseWatts();
        System.out.println("The light bulb is now at wattage: " + __lightBulb.getWatts());
    }

    public boolean isLampOff() throws LampException {
        return __lightBulb.getLumens() == 0.0F;
    }

    public boolean isLampLow() throws LampException {
        return __lightBulb.getLumens() == 1.0F;
    }
    public boolean isLampHigh() throws LampException {
        try {
            return __lightBulb.getLumens() > 1.0F;
        }
        catch (Exception le) {  // why catch an Exception and not a LampException?
            le.printStackTrace();
            if (Math.random() < 0.9) {
                // 90 % of the time replace the light bulb
                __lightBulb = new LightBulb();
                return isLampHigh();
            }
            // if we are burned out or malfunctioning
            throw new LampException(le);
        }
    }
}
