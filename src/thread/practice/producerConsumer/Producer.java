package thread.practice.producerConsumer;

public class Producer extends Thread {

    Bucket bucket;

    public Producer(Bucket b) {
        bucket = b;
    }

    @Override
    public void run() {

        int fruitCount = 0;
        while (fruitCount < 50) {
            synchronized (bucket) {
                System.out.println("produced : Fruit_" + fruitCount);
                bucket.addFruit("Fruit_" + fruitCount++);

                bucket.notifyAll();

            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        synchronized (bucket) {
            bucket.setProducerFinished(true);
            bucket.notifyAll();
        }
        System.out.println("Producer finised" );

    }
}