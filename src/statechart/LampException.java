package statechart;

public class LampException extends Exception {
    LampException(String msg) {
	    super(msg);
    }
    LampException(Exception e) {
	super (e);
    }
}
