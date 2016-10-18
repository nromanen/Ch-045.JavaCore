package inheritance.homework.bird;

import java.util.ArrayList;
import java.util.List;

import static util.Print.println;

 /*
 *Develop abstract class Bird with attributes feathers and layEggs and an abstarct method fly().
 * Develop classes FlyingBird and NonFlyingBird. Create class Eagle, Swallow, Penguin and Chicken.
 * Create array Bird and add different birds to it.
 * Call fly() method for all of it. Output the information about each type of created bird.
 */

public class Main {
    public static void main(String[] args) {

        List<Bird> birds = new ArrayList<>();

        birds.add(new Eagle("mountains"));
        birds.add(new Chicken("home"));
        birds.add(new Penguin("Antarctica"));
        birds.add(new Chicken("farm"));
        birds.add(new Swallow("village"));
        birds.add(new Penguin("South Africa"));

        for (Bird bird : birds) {
            bird.fly();
        }

        println();

        for (Bird bird : birds) {
            bird.info();
        }

    }
    }
