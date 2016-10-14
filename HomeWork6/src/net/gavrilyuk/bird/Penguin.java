package net.gavrilyuk.bird;

/**
 *
 * Created by Igor Gavryliuk on 10.10.2016.
 */
public class Penguin extends NonFlyingBird {

    public Penguin(int feathers, boolean layEggs) {
        super(feathers, layEggs);
    }

    public Penguin(boolean layEggs) {
        this(1, layEggs);
    }


    public Penguin() {
        this(1, false);
    }

    @Override
    public String toString() {
        return "Penguin "+super.toString();
    }
}
