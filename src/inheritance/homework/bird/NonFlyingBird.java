package inheritance.homework.bird;

// Abstract class for Non Flying Birds
public abstract class NonFlyingBird extends Bird{

    // Method show that this birds can't fly
    @Override
    public void fly() {
        System.out.println("I want to fly but I can't.");
    }


}
