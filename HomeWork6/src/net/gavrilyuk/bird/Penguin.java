package net.gavrilyuk.bird;

/**
 *
 * Created by Igor Gavryliuk on 10.10.2016.
 */
public class Penguin extends NonFlyingBird {

    public Penguin(int feathers, int layEggs) {
        super(feathers, layEggs);
    }

    public Penguin() {
        super(1,1);
    }

    @Override
    public String toString() {
        return "Penguin "+super.toString();
    }
}
