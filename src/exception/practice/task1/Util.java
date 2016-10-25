package exception.practice.task1;

/**
 * Created by Admin on 23.10.16.
 */
public class Util {
    public static int squareRectangle(int a, int b) throws IncorrectDataException {

        if(a < 0 || b < 0){
            throw new IncorrectDataException("The sides of the rectangle can't be negative");
        } else{
            return a * b;
        }
    }
}