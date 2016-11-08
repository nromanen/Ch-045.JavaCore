package thread.practice.producerConsumer;


import java.util.ArrayList;
import java.util.List;

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