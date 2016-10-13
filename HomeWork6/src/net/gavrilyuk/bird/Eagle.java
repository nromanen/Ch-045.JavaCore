package net.gavrilyuk.bird;

/**
 *
 * Created by Igor Gavryliuk on 10.10.2016.
 */
public class Eagle extends FlyingBird {

    public Eagle() {
        super(10,4);
    }

    public Eagle(int feathers, int layEggs) {
        super(feathers, layEggs);
    }

    @Override
    public String toString() {
        return "Eagle "+super.toString();
    }
}
