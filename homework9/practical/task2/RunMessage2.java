package homework9.practical.task2;

/**
 * Created by roma on 30.10.2016.
 */
public class RunMessage2 implements Runnable {
    @Override
    public void run() {
        for (int i=0; i<5; i++){
            try {
                System.out.println("Peace");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
