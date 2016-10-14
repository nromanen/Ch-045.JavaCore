package net.gavrilyuk.bird;

/**
 *
 * Created by Igor Gavryliuk on 10.10.2016.
 */
public class NonFlyingBird extends Bird {


    public NonFlyingBird(int feathers, boolean layEggs) {
        super(feathers,layEggs);
    }

    @Override
    void fly() {
        System.out.println(" I can not fly");
    }
}
