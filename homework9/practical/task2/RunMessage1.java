package homework9.practical.task2;

/**
 * Created by roma on 30.10.2016.
 */
public class RunMessage1 implements Runnable {
    @Override
    public void run() {
        for (int i=0; i<5; i++){
            try {
                System.out.println("World");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
