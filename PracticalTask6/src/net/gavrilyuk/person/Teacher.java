package net.gavrilyuk.person;

/**
 *
 * Created by Igor Gavrilyuk on 09.10.2016.
 */
public class Teacher extends Staff {

    private final static String TYPE_PERSON = Teacher.class.getSimpleName();

    public Teacher() {
        super();
        System.out.println(TYPE_PERSON);
    }

    @Override
    public void salary() {

    }
}
