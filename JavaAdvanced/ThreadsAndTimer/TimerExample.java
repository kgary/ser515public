import java.util.*;

class TimerExample {
    public static void main(String args[]) {
	try {
	    Timer timer = new Timer();
	    
	    timer.schedule(new MyTask(1), 4000);
	    timer.schedule(new MyTask(2), 2000);
	    
	    for (int i=0; i < 5; i++) {
		System.out.println("tick " + i); Thread.sleep(1000);
	    }

	    //Periodic tasks
	    timer.scheduleAtFixedRate(new MyTask(3), 0, 500);
	    timer.scheduleAtFixedRate(new MyTask(4), 0, 300);
	    for (int i=0; i < 11; i++) {
		System.out.println("tick " + i); Thread.sleep(100);
	    }
	    
	    timer.cancel();
	} catch (Throwable t) {
	    t.printStackTrace();
	}
    }
}


class MyTask extends TimerTask {

    int id;
    public MyTask(int myId) {id = myId;}
    public void run() {
        System.out.println("Executed #" + id);
    }
}
