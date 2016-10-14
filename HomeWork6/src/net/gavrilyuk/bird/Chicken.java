package net.gavrilyuk.bird;

/**
 *
 * Created by Igor Gavryliuk on 10.10.2016.
 */
public class Chicken extends NonFlyingBird {

    public Chicken(int feathers, boolean layEggs) {
        super(feathers, layEggs);
    }

    public Chicken( boolean layEggs) {
        this(5, layEggs);
    }
    public Chicken() {
        this(5,false);
    }

    @Override
    public String toString() {
        return "Chicken "+super.toString();
    }
}
