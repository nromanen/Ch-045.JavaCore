package net.gavrilyuk.task3;

/**
 *
 * Created by Igor Gavryliuk on 01.11.2016.
 */

/*
        Create a thread «one», which would start the thread «two»,
        which has to output its number («Thread number two») 3 times and create thread «three»,
        which would to output message «Thread number three» 5 times.
*/

public class Task3App {


    public static void main(String[] args) {

      Thread multiThread = new Thread(new MultiRunnable());
        multiThread.start();
    }
}
