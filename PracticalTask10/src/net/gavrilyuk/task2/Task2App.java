package net.gavrilyuk.task2;

/**
 *
 * Created by Igor Gavryliuk on 01.11.2016.
 */

// Output two messages «Hello, world» and «Peace in the peace»
// 5 times each with the intervals of 2 seconds,
// and the second - 3 seconds.
// After printing messages, print the text «My name is …»

public class Task2App {

    public final static Object first = new Object();
    public final static Object second = new Object();

    public static void main(String[] args) {
        MessagesThread thread1 = new MessagesThread("Hello, world", 5, 2000);
        MessagesThread thread2 = new MessagesThread("Peace in the peace", 5, 3000);
        thread1.start();
        thread2.start();
    }
}
