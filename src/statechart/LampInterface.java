package statechart;

public interface LampInterface {
    public enum ClickEvent { LEFT, RIGHT }
    public enum Intensity { OFF, LOW, HIGH, BURNOUT }
    public enum EventType { LOWER, HIGHER, BLOWN }
    
    public void click(ClickEvent ce) throws LampException;
    public boolean isLampOff() throws LampException;
    public boolean isLampLow() throws LampException;
    public boolean isLampHigh() throws LampException;
}
