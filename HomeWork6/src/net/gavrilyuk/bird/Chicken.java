package net.gavrilyuk.bird;

/**
 *
 * Created by Igor Gavryliuk on 10.10.2016.
 */
public class Chicken extends NonFlyingBird {

    public Chicken(int feathers, int layEggs) {
        super(feathers, layEggs);
    }

    public Chicken() {
        super(5,10);
    }

    @Override
    public String toString() {
        return "Chicken "+super.toString();
    }
}
