package Person;

/**
 * Created by evil on 17.10.16.
 */
public class Teacher extends Staff {
    private final String TYPE_PERSON = "Teacher";
    private int salary;

    public Teacher(String name, int salary){
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
