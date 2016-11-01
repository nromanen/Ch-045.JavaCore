package homework9.homework.deadlock;

/**
 * Created by roma on 31.10.2016.
 */
public class DeadlockDemo {
    public final static Object first = new Object();
    public final static Object second = new Object();

    public static void main(String s[]) {
        Thread t1 = new Thread() {
            public void run() {
                synchronized (first) {
                    Thread.yield();
                    synchronized (second) {
                        System.out.println("Success!");
                    }
                }
            }
        };
        Thread t2 = new Thread() {
            public void run() {
                synchronized (second) {
                    Thread.yield();
                    synchronized (first) {
                        System.out.println("Success!");
                    }
                }
            }
        };
        t1.start();
        t2.start();
    }
}


