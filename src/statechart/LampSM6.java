import static java.util.Map.entry;
import java.util.*;

class LampException extends Exception {
    LampException(String msg) {
	super(msg);
    }
}

public class LampSM6 {
    // let's also enum our even types
    enum EventType { LOWER, HIGHER, BLOWN }
    enum Intensity { OFF, LOW, HIGH, BURNOUT }
    private Intensity __intensity;

    // instead of the if statement let's setup a state transition table
    // The table is conceptually 3-tuples: State, Event, New State
    // We will represent as 2 2-tuples:
    Map<Intensity, Map<EventType, Intensity>> __table = new HashMap<Intensity, Map<EventType, Intensity>>();
    
    public LampSM6() {
	__intensity = Intensity.OFF;
	__table.put(Intensity.OFF, Map.ofEntries(entry(EventType.LOWER, Intensity.OFF),
						 entry(EventType.HIGHER, Intensity.LOW),
						 entry(EventType.BLOWN, Intensity.BURNOUT)));
	__table.put(Intensity.LOW, Map.ofEntries(entry(EventType.LOWER, Intensity.OFF),
						 entry(EventType.HIGHER, Intensity.HIGH),
						 entry(EventType.BLOWN, Intensity.BURNOUT)));
	__table.put(Intensity.HIGH, Map.ofEntries(entry(EventType.LOWER, Intensity.LOW),
						  entry(EventType.HIGHER, Intensity.HIGH),
						  entry(EventType.BLOWN, Intensity.BURNOUT)));
	__table.put(Intensity.BURNOUT, Map.ofEntries(entry(EventType.LOWER, Intensity.BURNOUT),
						     entry(EventType.HIGHER, Intensity.BURNOUT),
						     entry(EventType.BLOWN, Intensity.BURNOUT)));
    }

    public void eventHandler(EventType e) throws LampException {
	// if we specified our transition table properly (completely) this can never be NULL
	__intensity = __table.get(__intensity).get(e);
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
    
    // this class knows about the concrete types. We coule abstract this out too!
    class EventFactory {
	static EventType getNextEvent() {
	    double r = Math.random();
	    if (r > 0.9) return EventType.BLOWN;
	    if (r > 0.45) return EventType.HIGHER;
	    return EventType.LOWER;
	}
    }

    public static void main(String[] args) {
        LampSM6 l = new LampSM6();

        int eventCount = 0;

        try {
            eventCount = Integer.parseInt(args[0]);
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
	    for (int i = 0; i < eventCount; i++) {
		EventType et = EventFactory.getNextEvent();
		System.out.print("Event number " + i + " is " + et + " - ");
		l.eventHandler(et);

		if (l.isLampHigh()) {
                    System.out.println(" The Lamp is on HIGH");
                }
		else if (l.isLampLow()) {
                    System.out.println(" The Lamp is on LOW");
                }
                else if (l.isLampOff()) {
                    System.out.println(" The Lamp is OFF");
                } else System.out.println(" The Lamp has BURNED OUT");
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
