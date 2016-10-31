package homework9.practical.task1;

/**
 * Created by roma on 30.10.2016.
 */
public class Run1 implements Runnable {
    @Override
    public void run() {
        for (int i=10; i>0; i--){
            System.out.print(i+" I study Java\n");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

