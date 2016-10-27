package bucket; 

import java.util.ArrayList;
import java.util.List;


public class ProducerConsumer {

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

 public static void main(String[] args) {
  new ProducerConsumer().initlize();
 }

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

 public class Consumer extends Thread {

  Bucket bucket;
  String consumerName;

  public Consumer(Bucket b, String consName) {
   bucket = b;
   consumerName =consName;
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

 public class Bucket {

  private List<String> fruitBuket  = new ArrayList<String>();
  private boolean producerFinished = false;

  
  public boolean isProducerFinished() {
   return producerFinished;
  }

  public void setProducerFinished(boolean producerFinished) {
   this.producerFinished = producerFinished;
  }

  public int getBucketSize() {
   return fruitBuket.size();
  }

  public void addFruit(String fruit) {
   fruitBuket.add(fruit);
  }

  public String getFruit() {
   if (fruitBuket.size() == 0)
    return null;
   return fruitBuket.remove(fruitBuket.size() - 1);
  }
 }

}
