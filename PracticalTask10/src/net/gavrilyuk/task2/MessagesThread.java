package net.gavrilyuk.task2;

/**
 * Messages Thread
 * Created by Igor Gavryliuk on 01.11.2016.
 */
public class MessagesThread extends Thread {

    private String text;
    private int count;
    private int pause;

    public MessagesThread(String text, int count, int pause) {
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
            System.out.println("My name is "+toString());
        }

    }
    @Override
    public String toString() {
        return "Thread[" + getName()+"]";
    }
}
