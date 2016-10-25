package exception.homework.task2;

/**
 * Created by Admin on 25.10.16.
 */
public class IncorrectIntegerException extends Exception {

    public IncorrectIntegerException(int b, int e) {
        super("Integer number is not in range [" + b + ", " + e + "]");
    }
}
