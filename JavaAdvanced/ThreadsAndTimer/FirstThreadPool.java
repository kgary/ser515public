import java.net.*;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

class ThreadPool {
    public static void main(String args[]) throws Exception {
        Executor pool = Executors.newFixedThreadPool(2);

        for (int i=0; i < 5; i++) {
            pool.execute(new Worker(i));
        }
    }
}


class Worker implements Runnable {
    protected int id;

    public Worker (int assignedID) {
        id = assignedID;
    }

    public void run() {

        for (int loop=0; loop < 5; loop++) {
            System.out.println("Hello from " + id  + " loop=" + loop);
            try {
                Thread.sleep(2000);
            } catch (Exception e) {}
        }
    }
}


class FirstThreadPool {
    public static void main(String args[]) {
        int  times= Integer.parseInt(args[0]);

        for (int loop=0; loop < times; loop++) {
            Runnable worker = new Worker(loop);
            Thread task = new Thread(worker, "Task#"+loop);
            task.start();
        }
    }
}

