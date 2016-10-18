package inheritance.practice.person;


import static util.Print.println;

public abstract class Staff extends Person {

    private final String TYPE_PERSON = "Staff";
    public Staff() {
        println("Constructor ", TYPE_PERSON);
    }

    public abstract int salary();
}
