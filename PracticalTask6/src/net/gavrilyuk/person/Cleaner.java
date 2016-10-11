package net.gavrilyuk.person;

/**
 *
 * Created by Igor Gavrilyuk on 09.10.2016.
 */
public class Cleaner extends Staff {

    private final static String TYPE_PERSON = Cleaner.class.getSimpleName();

    public Cleaner() {
        System.out.println(TYPE_PERSON);
    }
    @Override
    public void print() {
        System.out.print("I am a " + TYPE_PERSON);
    }

    @Override
    public void salary() {
        System.out.println(" salary=50$");
    }
}
