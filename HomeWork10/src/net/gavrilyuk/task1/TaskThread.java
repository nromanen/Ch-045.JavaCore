package net.gavrilyuk.task1;

/**
 *
 * Created by Igor Gavryliuk on 01.11.2016.
 */
public class TaskThread extends Thread {

    private int repeatCount;
    private String name;

    public TaskThread(String name, int repeatCount) {
        super(name);
        this.name= name;
        this.repeatCount = repeatCount;
    }

    @Override
    public void run() {
        System.out.println("Thread "+ name+" start." );
        for (int i = 0; i < repeatCount; i++) {
            try {
                sleep(1000);
            } catch (InterruptedException ignored) {
            }
            System.out.println("Thread " + name+ " work "+ (i+1) +" time.");
        }
        System.out.println("Thread "+ name+" end." );
    }
}
