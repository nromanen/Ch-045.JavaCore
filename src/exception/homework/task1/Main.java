package exception.homework.task1;

/* Create method div(), which calculates the dividing of two double numbers.
 * In main method input 2 double numbers and call this method.
 * Catch all exceptions.
 */

import exception.homework.task2.IncorrectIntegerException;

import java.io.IOException;

import static util.Print.println;

public class Main {
    public static void main(String[] args) {

        try {
            println(Util.div());
        } catch (IOException e) {
            println("IOException: " + e.getMessage());
        } catch (NumberFormatException e){
            println("NumberFormatException: " + e.getMessage());
        } catch (ArithmeticException e) {
            println("ArithmeticException: " + e.getMessage());
        }
    }
}
