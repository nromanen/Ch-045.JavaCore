package net.gavrilyuk.person;

/**
 *
 * Created by Igor Gavrilyuk on 09.10.2016.
 */
public class Student extends Person {

    private final static String TYPE_PERSON = Student.class.getSimpleName();

    public Student() {
        System.out.println(TYPE_PERSON);
    }

    @Override
    public void print() {
        System.out.println("I am a "+TYPE_PERSON);
    }
}
