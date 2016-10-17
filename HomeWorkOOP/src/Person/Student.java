package Person;

/**
 * Created by evil on 17.10.16.
 */
public class Student extends Person {
    private final String TYPE_PERSON = "Student";
    public Student(String name){
        super(name);
    }
    @Override
    public void print() {
        System.out.println("I am a " + TYPE_PERSON
                            + " name is " + getName());
    }
}
