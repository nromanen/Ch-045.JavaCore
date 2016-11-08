package thread.practice.producerConsumer;

public class Consumer extends Thread {

    Bucket bucket;
    String consumerName;

    public Consumer(Bucket b, String consName) {
        bucket = b;
        consumerName = consName;
    }

    @Override
    public void run() {

        while (bucket.isProducerFinished()==false ) {
            synchronized (bucket) {

                String fruit = bucket.getFruit();


                if (fruit == null) {
                    try {
                        bucket.wait();
                        System.out.println(consumerName+"  waiting" );
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else{
                    System.out.println("Consumed fruit :" + fruit +" by "+consumerName);
                }


            }
        }
        synchronized (bucket) {
            bucket.notifyAll();
            System.out.println(consumerName +" finised" );
        }

    }

}

