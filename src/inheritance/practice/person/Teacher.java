package inheritance.practice.person;

import static util.Print.println;


public class Teacher extends Staff {

    private final String TYPE_PERSON = "Teacher";

    public Teacher() {
        println("Constructor ", TYPE_PERSON);
    }

    @Override
    public void print() {
        println("I am a Teacher");
    }

    @Override
    public int salary() {
        return 0;
    }
}
