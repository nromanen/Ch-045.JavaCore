package homework9.practical.task1;

/**
 * Created by roma on 30.10.2016.
 * Output text «I study Java» 10 times with the intervals of one second (Thread.sleep(1000);).
 */
public class DemoSleepThread {
    public static void main(String[ ] args) throws InterruptedException {
        Runnable r1 = new Run1();
        Thread t1 = new Thread(r1);
        t1.start();
    }
}

