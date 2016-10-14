package net.gavrilyuk.bird;

/**
 *
 * Created by Igor Gavryliuk on 10.10.2016.
 */
public class Eagle extends FlyingBird {

    public Eagle() {
        this(10, false);
    }

    public Eagle( boolean layEggs) {
        this(10, layEggs);
    }

    public Eagle(int feathers, boolean layEggs) {
        super(feathers, layEggs);
    }

    @Override
    public String toString() {
        return "Eagle "+super.toString();
    }
}
