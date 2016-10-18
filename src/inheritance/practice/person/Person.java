package inheritance.practice.person;

import static util.Print.println;

public abstract class Person {

    private final String TYPE_PERSON = "Person";

    public Person() {
        println("Constructor ", TYPE_PERSON);
    }

    public String name;

    public abstract void print();
}
