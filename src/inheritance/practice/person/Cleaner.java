package inheritance.practice.person;

import static util.Print.println;

public class Cleaner extends Staff {

    private final String TYPE_PERSON = "Cleaner";

    public Cleaner() {
        println("Constructor ", TYPE_PERSON);
    }

    @Override
    public void print() {
        println("I am a Cleaner");
    }

    @Override
    public int salary() {
        return 0;
    }
}
