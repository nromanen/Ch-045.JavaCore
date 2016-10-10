package net.gavrilyuk.person;

/**
 *
 * Created by Igor Gavrilyuk on 09.10.2016.
 */
public abstract class Staff extends Person {

    private final static String TYPE_PERSON = Staff.class.getSimpleName();

    public Staff() {
        System.out.println(TYPE_PERSON);
    }

    @Override
    public void print() {
        System.out.println("I am a ");
    }

    public abstract void salary();
}
