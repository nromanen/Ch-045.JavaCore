package net.gavrilyuk.bird;

import java.util.ArrayList;
import java.util.List;

/**
 *  BirdsApp Class
 * Created by Igor Gavryliuk on 10.10.2016.
 */
        // Develop abstract class Bird with attributes feathers and layEggs and an abstract method fly().
        // Develop classes FlyingBird and NonFlyingBird.
        // Create class Eagle, Swallow, Penguin and Chicken.
        // Create array Bird and add different birds to it.
        // Call fly() method for all of it.
        // Output the information about each type of created bird.

public class BirdsApp {

    private static final int NUMBER_OF_BIRDS = 10;

    public static void main(String[] args) {
        List<Bird> birds = new ArrayList<>();
        //fill birds list
        for (int i = 0; i < NUMBER_OF_BIRDS; i++) {
            switch (i) {
               case 0:
                   birds.add(new Eagle());
               case 5:
                   birds.add(new Eagle(true));
                   break;
                case 1:
                    birds.add(new Swallow());
                case 6:
                    birds.add(new Swallow(true));
                    break;
                case 2:
                    birds.add(new Penguin());
                case 7:
                    birds.add(new Penguin(true));
                    break;
               default:
                   birds.add(new Chicken());
            }
        }
        //and show
        for (Bird bird : birds) {
            System.out.print(bird.toString());
            bird.fly();
        }
    }
}
