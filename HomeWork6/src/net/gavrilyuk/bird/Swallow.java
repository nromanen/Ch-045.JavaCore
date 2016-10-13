package net.gavrilyuk.bird;

/**
 *
 * Created by Igor Gavryliuk on 10.10.2016.
 */
public class Swallow extends FlyingBird {

    public Swallow(int feathers, int layEggs) {
        super(feathers, layEggs);
    }

    public Swallow() {
        super(3, 5);
    }

    @Override
    public String toString() {
        return "Swallow "+super.toString();
    }
}
