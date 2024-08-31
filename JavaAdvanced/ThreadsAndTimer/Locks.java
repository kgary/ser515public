import java.util.concurrent.locks.*;

class Locks {
    public static void main(String args[]) throws Exception {
        Lock mutex = new ReentrantLock();

        for (int i=0; i < 5; i++) {
            (new LockThread(i, mutex)).start();
        }
    }
}


class LockThread extends Thread {
    protected int id;
    protected Lock mutex;

    public LockThread (int id, Lock mutex) {
        this.id = id;
        this.mutex = mutex;
    }

    public void run() {
        for (int loop=0; loop < 3; loop++) {
            mutex.lock();
            try {
                System.out.println("Thread" + id + " has lock");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            } finally {
                System.out.println("Thread" + id + " releasing lock");
                mutex.unlock();
            }
        }
    }
}
