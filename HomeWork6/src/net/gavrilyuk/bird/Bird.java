package net.gavrilyuk.bird;

/**
 *  Abstract Bird Calss
 * Created by Igor Gavryliuk on 10.10.2016.
 */
public abstract class Bird {

    private int feathers;//feathers length
    private int layEggs;//the number of eggs carried by a bird

    public Bird(int feathers, int layEggs) {
        this.feathers = feathers;
        this.layEggs = layEggs;
    }

    abstract void fly();

    public int getFeathers() {
        return feathers;
    }

    public void setFeathers(int feathers) {
        this.feathers = feathers;
    }

    public int getLayEggs() {
        return layEggs;
    }

    public void setLayEggs(int layEggs) {
        this.layEggs = layEggs;
    }

    @Override
    public String toString() {
        return  "Feathers=" + feathers + ", LayEggs=" + layEggs;
    }
}
