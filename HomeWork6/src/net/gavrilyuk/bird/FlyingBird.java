package net.gavrilyuk.bird;

/**
 *
 * Created by Igor Gavryliuk on 10.10.2016.
 */
public class FlyingBird extends Bird {

    public FlyingBird(int feathers, boolean layEggs) {
        super(feathers, layEggs);
    }

    @Override
   public void fly() {
        System.out.println(" I'm flying");
    }
}
