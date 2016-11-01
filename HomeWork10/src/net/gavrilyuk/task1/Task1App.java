package net.gavrilyuk.task1;

/**
 *
 * Created by Igor Gavryliuk on 01.11.2016.
 */


/*Run three threads and output there different messages for 5 times.
 The third thread supposed to start after finishing working of the two previous threads.*/

public class Task1App {

    public static void main(String[] args) {

        System.out.println("Start run threads:");
        Thread t1 = new TaskThread("t1",5);
        Thread t2 = new TaskThread("t2",5);
        Thread t3 = new TaskThread("t3",5);
        t1.start();
        t2.start();
        //start third thread  after finishing working of the t1,t2 threads
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t3.start();


    }
}
