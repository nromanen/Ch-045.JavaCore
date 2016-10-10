package net.gavrilyuk.animals;

/**
 * Create interface Animal with methods voice() and feed().
 * Create two classes Cat and Dog, which implement this interface.
 * Create array of Animal and add some Cats and Dogs to it.
 * Call voice() and feed() method for all of it
 *
 * Created by Igor Gavrilyuk on 09.10.2016.
 */
public class AnimalsApp {

    public static void main(String[] args) {
        Animals animals = new Animals(10);
        for (int i = 0; i < 10; i++) { // fill
            if (i % 2 == 0) {
                animals.addAnimal(i, new Cat());
            } else animals.addAnimal(i, new Dog());
        }
       animals.voiceAll();
       animals.feedAll();
    }
}
