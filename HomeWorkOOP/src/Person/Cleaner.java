package Person;

/**
 * Created by evil on 17.10.16.
 */
public class Cleaner extends Staff {
    private final String TYPE_PERSON = "Cleaner";
    private int salary;

    public Cleaner (String name, int salary){
        super(name);
        this.salary = salary;
    }

    @Override
    public void print() {
        System.out.println("I am a " + TYPE_PERSON
                            + " name is " + getName());
        salary();
    }

    @Override
    public void salary() {
        System.out.println("Salary = " + salary);
    }
}
