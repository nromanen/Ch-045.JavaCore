package homework8.practical.rectangle;

/**
 * Created by roma on 27.10.2016.
 */
public class Rectangle {

    public static int square(int a, int b) throws NegativeValueException {
        if( a < 0){
            throw new NegativeValueException(a);
        } else if(b < 0){
            throw new NegativeValueException(b);
        } else {
            return a * b;
        }
    }
}
