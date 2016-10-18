package inheritance.practice.person;

import static util.Print.println;

public class Student extends Person {

    private final String TYPE_PERSON = "Student";

    public Student(){
        println("Constructor ", TYPE_PERSON);
    }

    @Override
    public void print() {
        println("I am a Student");
    }
}
