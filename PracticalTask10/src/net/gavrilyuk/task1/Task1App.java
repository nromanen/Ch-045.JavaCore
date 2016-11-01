package net.gavrilyuk.task1;

/**
 *
 * Created by Igor Gavryliuk on 01.11.2016.
 */

//Output text «I study Java» 10 times with the intervals of one second (Thread.sleep(1000);).

public class Task1App {

    public static void main(String[] args) {
        Thread t1 = new TaskThread("I study Java",10, 1000);
        t1.start();
    }
}
