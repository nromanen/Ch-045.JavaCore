package net.gavrilyuk.bird;

/**
 *
 * Created by Igor Gavryliuk on 10.10.2016.
 */
public class Swallow extends FlyingBird {

    public Swallow(int feathers, boolean layEggs) {
        super(feathers, layEggs);
    }

    public Swallow( boolean layEggs) {
        this(3, layEggs);
    }

    public Swallow() {
        this(3, false);
    }

    @Override
    public String toString() {
        return "Swallow "+super.toString();
    }
}
