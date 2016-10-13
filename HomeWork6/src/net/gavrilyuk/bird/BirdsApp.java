package net.gavrilyuk.bird;

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

    public static void main(String[] args) {
        Bird [] birds = new Bird[10];
        //fill array
        for (int i = 0; i < 10; i++) {
            switch (i) {
               case 0:
               case 5:
                   birds[i] = new Eagle();
                   break;
                case 1:
                case 6:
                    birds[i] = new Swallow();
                    break;
                case 2:
                case 7:
                    birds[i] = new Penguin();
                    break;
               default:
                   birds[i] = new Chicken();
            }
        }
        //and show
        for (Bird bird : birds) {
            System.out.print(bird.toString());
            bird.fly();
        }
    }
}
