package homework8.practical.rectangle;

/**
 * Created by roma on 27.10.2016.
 */
public class NegativeValueException extends Exception {

    private int value;

    public NegativeValueException() {
    }

    public NegativeValueException( int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "NegativeValueException - a = " + value;
    }
}
