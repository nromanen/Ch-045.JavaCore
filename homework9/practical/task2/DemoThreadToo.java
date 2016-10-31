package homework9.practical.task2;

/**
 * Created by roma on 30.10.2016.
 * Output two messages «Hello, world» and «Peace in the peace» 5 times each with the intervals of 2 seconds,
 and the second - 3 seconds. After printing messages, print the text «My name is …»
 */
public class DemoThreadToo {
    public static void main(String[] args){
        Runnable runnable1 = new RunMessage1();
        Runnable runnable2 = new RunMessage2();

        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);

        thread1.start();
        thread2.start();

    }
}
