package inheritance.homework.bird;

import static util.Print.println;

// Abstract class for Flying Birds
public abstract class FlyingBird extends Bird {

    // Method show that this birds can fly
    @Override
    public void fly() {
        println("I can fly");
    }

}
