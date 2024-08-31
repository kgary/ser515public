class ThreadGroups {
    public static void main(String args[]) throws Exception {

        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);

        ThreadGroup aGroup = new ThreadGroup("A");
        aGroup.setMaxPriority(5);
        ThreadGroup bGroup = new ThreadGroup("B");
        bGroup.setMaxPriority(5);

        for (int i=1; i <= 3; i++) {
            Thread p = new Thread(aGroup, new Proc(i, "A"));
            p.start();
            p = new Thread(bGroup, new Proc(i*5, "B"));
            p.start();
        }

	Thread[] aGroupArray = new Thread[aGroup.activeCount()];
	int aSize = aGroup.enumerate(aGroupArray);
	for (int i = 0; i < aSize; i++) {
	    System.out.println("A Group thread " + i + ", id:  " + aGroupArray[i].getId());
	}
	Thread[] bGroupArray = new Thread[bGroup.activeCount()];
	int bSize = bGroup.enumerate(bGroupArray);
	for (int i = 0; i < bSize; i++) {
	    System.out.println("B Group thread " + i + ", id:  " + bGroupArray[i].getId());
	}	
    }
}

class Proc implements Runnable {
    private int id;
    private String group;
    
    public Proc(int x, String g) {
	id = x;
	group = g;
    }

    public void run() {
        try {
            for (int j = 0; j < id; j++) {
                System.out.println("Hello from Group " + group + ", id " + id);
                Thread.yield();
            }
        }
        catch (Exception e) {
	    e.printStackTrace();
	}
    }
}
