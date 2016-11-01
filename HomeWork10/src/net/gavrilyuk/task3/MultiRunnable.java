package net.gavrilyuk.task3;

/**
 *
 * Created by Igor Gavryliuk on 01.11.2016.
 */
public class MultiRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Thread number one");
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <3 ; i++) {
                    System.out.println("Thread number two");
                }
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i <5 ; i++) {
                            System.out.println("Thread number three");
                        }
                    }
                }).start();
            }
        }).start();

    }
}


