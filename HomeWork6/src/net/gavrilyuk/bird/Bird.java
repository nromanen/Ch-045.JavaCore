package net.gavrilyuk.bird;

/**
 *  Abstract Bird Calss
 * Created by Igor Gavryliuk on 10.10.2016.
 */
public abstract class Bird {

    private int feathers;//feathers length
    private boolean layEggs;//bird lays eggs

    public Bird(int feathers, boolean layEggs) {
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

    public boolean getLayEggs() {
        return layEggs;
    }

    public void setLayEggs(boolean layEggs) {
        this.layEggs = layEggs;
    }

    @Override
    public String toString() {
        return  "Feathers=" + feathers + ", LayEggs=" + layEggs;
    }
}
