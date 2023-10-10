import static java.util.Map.entry;
import java.util.*;

class LampException extends Exception {
    LampException(String msg) {
	super(msg);
    }
}

// let's objectify everything
// events - taken from 2_4_5
interface LampEvent {}
interface LowerLampEvent extends LampEvent {}
interface HigherLampEvent extends LampEvent {}

class BlownLampEvent implements LampEvent {
    public String toString() { return "Light Bulb Blown Event. "; }
}

class LeftClickEvent implements LowerLampEvent {
    LeftClickEvent() { super(); }
    public String toString() { return "Knob Left-Turn-Click Event. "; }
}
class RightClickEvent implements HigherLampEvent {
    RightClickEvent() { super(); }
    public String toString() { return "Knob Right-Turn-Click Event. "; }
}
class AlexaLowerEvent implements LowerLampEvent {
    AlexaLowerEvent() { super(); }
    public String toString() { return "Alexa Lower Event. "; }
}
class AlexaHigherEvent implements HigherLampEvent {
    AlexaHigherEvent() { super(); }
    public String toString() { return "Alexa Higher Event. "; }
}

// States - factor up from enums
interface LampState {
    void entryAction();
    void exitAction();
    Transition handleEvent(LowerLampEvent e);
    Transition handleEvent(HigherLampEvent e);
    Transition handleEvent(BlownLampEvent e);
    // we won't include the internal running activity with RTC semantics - Lamps don't need it
}
abstract class ALampState implements LampState {
    protected String label;
    protected ALampState(String l) {
	label = l;
    }
    public void entryAction() {
	System.out.println("Entering the " + label + " state");
    }
    public void exitAction() {
	System.out.println("Exiting the " + label + " state");
    }
    public abstract Transition handleEvent(LowerLampEvent e);
    public abstract Transition handleEvent(HigherLampEvent e);
    public Transition handleEvent(BlownLampEvent e) {
	return new Transition(this, e, new BurnedOutLampState());
    }
}
class OffLampState extends ALampState implements LampState {
    OffLampState() { super("OFF"); }
    public Transition handleEvent(LowerLampEvent e) {
	return new Transition(this, e, new OffLampState());
    }
    public Transition handleEvent(HigherLampEvent e) {
	return new Transition(this, e, new LowLampState());
    }
}
class LowLampState extends ALampState implements LampState {
    LowLampState() { super("LOW"); }
    public Transition handleEvent(LowerLampEvent e) {
	return new Transition(this, e, new OffLampState());
    }
    public Transition handleEvent(HigherLampEvent e) {
	return new Transition(this, e, new HighLampState());
    }
}
class HighLampState extends ALampState implements LampState {
    HighLampState() { super("HIGH"); }
    public Transition handleEvent(LowerLampEvent e) {
	return new Transition(this, e, new LowLampState());
    }
    public Transition handleEvent(HigherLampEvent e) {
	return new Transition(this, e, new HighLampState());
    }
}
class BurnedOutLampState extends ALampState implements LampState {
    BurnedOutLampState() { super("BURNED OUT"); }
    public Transition handleEvent(LowerLampEvent e) {
	return new Transition(this, e, this);
    }
    public Transition handleEvent(HigherLampEvent e) {
	return new Transition(this, e, this);
    }
}

// A Transition connects states through events
final class Transition {
    LampEvent event;
    LampState sourceState;
    LampState targetState;
    
    Transition(LampState s, LampEvent e, LampState t) {
	event = e;
	sourceState = s;
	targetState = t;
    }
    private boolean guard() {  // this is a mock, normally we would abstract this as well
	return Math.random() > 0.2;
    }
    LampState fire() {  // this has RTC semantics so we can mock return the new LampState
	if (guard()) {
	    System.out.println("Firing a transition based on event " + event + " to new state " + targetState);
	    return targetState;
	} else {
	    System.out.println("Guard condition failed based on event " + event + ", staying in state " + sourceState);
	    return sourceState;
	}
    }
}

public class LampSM7 extends ALampState {  // looks weird but this is the State Pattern
    // effectively the object is a single state at the top-level, with nested substates
    LampSM7() { super("LAMP"); }
    
    // The lamp now really just runs the SM
    LampState __currentState = new OffLampState();

    // these now just shadow the __currentState
    public Transition handleEvent(LowerLampEvent e) {
	Transition rval =__currentState.handleEvent(e);
	if (rval != null) __currentState = rval.fire();
	return rval;
    }
    public Transition handleEvent(HigherLampEvent e) {
	Transition rval =__currentState.handleEvent(e);
	if (rval != null) __currentState = rval.fire();
	return rval;
    }
    public Transition handleEvent(BlownLampEvent e) {
	Transition rval =__currentState.handleEvent(e);
	if (rval != null) __currentState = rval.fire();
	return rval;
    }

    public static void main(String[] args) {
        LampSM7 l = new LampSM7();

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
		// this is just a hacky way, normally we would be an event stream generator
		double r = Math.random();
		if (r > 0.9) l.handleEvent(new LeftClickEvent());
		if (r > 0.65) l.handleEvent(new RightClickEvent());
		if (r > 0.45) l.handleEvent(new AlexaLowerEvent());
		if (r > 0.25) l.handleEvent(new AlexaHigherEvent());

		System.out.println("The current state is now " + l.__currentState);
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
