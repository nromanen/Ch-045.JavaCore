package AnimalTask;

/**
 * Created by evil on 17.10.16.
 */
public class Dog implements Animal {
    @Override
    public void voice() {
        System.out.println("Gav");
    }

    @Override
    public void feed() {
        System.out.println("Dog feed");
    }
}
