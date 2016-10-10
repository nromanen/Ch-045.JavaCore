package net.gavrilyuk.animals;

/**
 *
 * Created by Igor Gavrilyuk on 09.10.2016.
 */
public class Dog implements Animal {
    @Override
    public void voice() {
        System.out.println("Woof woof!");
    }

    @Override
    public void feed() {
        System.out.println("Eat food!");
    }
}
