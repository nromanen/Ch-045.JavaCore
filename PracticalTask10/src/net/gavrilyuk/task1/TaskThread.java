package net.gavrilyuk.task1;

/**
 *
 * Created by Igor Gavryliuk on 01.11.2016.
 */
public class TaskThread extends Thread {

    private String text;
    private int count;
    private int pause;

    public TaskThread(String text, int count, int pause) {
        this.count = count;
        this.text = text;
        this.pause = pause;
    }

    @Override
    public void run() {
        for (int i = 0; i < count; i++) {
            try {
                sleep(pause);
            } catch (InterruptedException ignored) {
            }
            System.out.println(text);
        }

    }
}