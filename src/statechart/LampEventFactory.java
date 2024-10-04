// Let's use polymorphism via tagging types to get rid of
// almost all of our conditionals on click events
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

// this class knows about the concrete types. We could abstract this out too!
public class LampEventFactory {
    static LampEvent getNextEvent() {
	double r = Math.random();
	if (r > 0.75) return new LeftClickEvent();
	if (r > 0.5) return new RightClickEvent();
	if (r > 0.25) return new AlexaLowerEvent();
	return new AlexaHigherEvent();
    }
}
