package net.gavrilyuk.animals;

/**
 *
 * Created by Igor Gavrilyuk on 09.10.2016.
 */
public class Cat implements Animal {

    @Override
    public void voice() {
        System.out.println("Meow-meow!");
    }

    @Override
    public void feed() {
        System.out.println("Kitty Kitty!");
    }
}