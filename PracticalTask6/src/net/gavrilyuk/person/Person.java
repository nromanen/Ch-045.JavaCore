package net.gavrilyuk.person;

/**
 *
 * Created by Igor Gavrilyuk on 09.10.2016.
 */
public abstract class Person  {

    private final static String TYPE_PERSON = Person.class.getSimpleName();

    private String mName;
    public abstract void print();

    public Person() {
        System.out.println(TYPE_PERSON);
    }
}
