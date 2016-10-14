package hohework5.practical.person;

/**
 * Created by roma on 14.10.2016.
 */
public class Cleaner extends Staff {

    public static String TYPE_PERSON = Cleaner.class.getSimpleName();
    public int hourNumber;
    public int rate;

    public Cleaner(){}

    public Cleaner(String name, int hourNumber, int rate){
        super(name);
        this.hourNumber = hourNumber;
        this.rate = rate;
    }

    @Override
    public int salary() {
        return rate * hourNumber;
    }

    @Override
    public String print() {
        return "I am " + TYPE_PERSON;
    }
}
