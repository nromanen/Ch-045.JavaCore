package AnimalTask;

/**
 * Created by evil on 17.10.16.
 */
public class Cat implements Animal {
    @Override
    public void feed() {
        System.out.println("Cat feed");
    }

    @Override
    public void voice() {
        System.out.println("Meow");
    }
}
