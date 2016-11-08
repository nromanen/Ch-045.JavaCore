package thread.practice.producerConsumer;


public class ProducerConsumer {

    public static void main(String[] args) {
        new ProducerConsumer().initlize();
    }

    public void initlize() {
        Bucket b = new Bucket();
        Producer producer = new Producer(b);
        Consumer consumer_1 = new Consumer(b,"Consumer 1");
        Consumer consumer_2 = new Consumer(b,"Consumer 2");
        Consumer consumer_3 = new Consumer(b,"Consumer 3");

        producer.start();
        consumer_1.start();
        consumer_2.start();
        consumer_3.start();

    }
}